package com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.db.StringUtil;

import com.bean.Admin;
import com.bean.Student;
import com.bean.Teacher;
import com.bean.UserType;
import com.dao.AdminDao;
import com.dao.StudentDao;
import com.dao.TeacherDao;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EditPasswordFrame extends JInternalFrame {

	private JPanel contentPane;

	private JLabel currentUserLabel;
	private JTextField oldPasswordTextField;
	private JTextField newPasswordTextField;
	private JTextField confirmPasswordTextField;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					EditPasswordFrame frame = new EditPasswordFrame();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public EditPasswordFrame() {
		setTitle("\u4FEE\u6539\u5BC6\u7801");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 472, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setClosable(true); //可关闭
		setIconifiable(true); //可放大缩小
		
		JLabel label = new JLabel("    \u539F\u5BC6\u7801\uFF1A ");
		label.setIcon(new ImageIcon(EditPasswordFrame.class.getResource("/img/\u539F\u5BC6\u7801.png")));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		oldPasswordTextField = new JTextField();
		oldPasswordTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("    \u65B0\u5BC6\u7801\uFF1A ");
		label_1.setIcon(new ImageIcon(EditPasswordFrame.class.getResource("/img/\u7BA1\u7406\u5458\u4FEE\u6539\u5BC6\u7801.png")));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		newPasswordTextField = new JTextField();
		newPasswordTextField.setColumns(10);
		
		JLabel label_2 = new JLabel(" \u786E\u8BA4\u5BC6\u7801\uFF1A");
		label_2.setIcon(new ImageIcon(EditPasswordFrame.class.getResource("/img/\u786E\u8BA4\u5BC6\u7801.png")));
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		confirmPasswordTextField = new JTextField();
		confirmPasswordTextField.setColumns(10);
		//修改密码
		JButton submitButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				submitEdit(e);
			}
		});
		submitButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		submitButton.setIcon(new ImageIcon(EditPasswordFrame.class.getResource("/img/\u786E\u8BA4.png")));
		
		JLabel label_3 = new JLabel(" \u5F53\u524D\u7528\u6237\uFF1A ");
		label_3.setIcon(new ImageIcon(EditPasswordFrame.class.getResource("/img/\u7528\u6237\u540D2.png")));
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		currentUserLabel = new JLabel("New label");
		//currentUserLabel.setEnabled(false);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(70)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(label_1)
							.addContainerGap())
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_2)
								.addComponent(label)
								.addComponent(label_3))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(currentUserLabel, GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
								.addComponent(newPasswordTextField, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
								.addComponent(confirmPasswordTextField, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
								.addComponent(oldPasswordTextField, GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE))
							.addGap(120))))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(158)
					.addComponent(submitButton)
					.addContainerGap(188, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(43)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(label_3)
						.addComponent(currentUserLabel))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(oldPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(newPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(confirmPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addComponent(submitButton)
					.addContainerGap(46, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		if("系统管理员".equals(MainFrame.userType.getName())) {
			Admin admin=(Admin)MainFrame.userObject;
			currentUserLabel.setText("【系统管理员】"+admin.getAdmin_name());
		}else if("学生".equals(MainFrame.userType.getName())){
			Student student = (Student)MainFrame.userObject;
			currentUserLabel.setText("【学生】" + student.getStudent_name());
		}else{
			Teacher teacher = (Teacher)MainFrame.userObject;
			currentUserLabel.setText("【教师】" + teacher.getTeacher_name());
		}
		
	}
	private void submitEdit(ActionEvent e) {
		// TODO Auto-generated method stub
		String oldPassword = oldPasswordTextField.getText().toString();
		String newPassword = newPasswordTextField.getText().toString();
		String conformPassword = confirmPasswordTextField.getText().toString();
		if(StringUtil.isEmpty(oldPassword)){
			JOptionPane.showMessageDialog(this, "请填写旧密码");
			return;
		}
		if(StringUtil.isEmpty(newPassword)){
			JOptionPane.showMessageDialog(this, "请填写新密码");
			return;
		}
		if(StringUtil.isEmpty(conformPassword)){
			JOptionPane.showMessageDialog(this, "请确认新密码");
			return;
		}
		if(!newPassword.equals(conformPassword)){
			JOptionPane.showMessageDialog(this, "两次密码输入不一致");
			return;
		}
		if("系统管理员".equals(MainFrame.userType.getName())){
			AdminDao adminDao = new AdminDao();
			Admin adminTmp = new Admin();
			Admin admin = (Admin)MainFrame.userObject;
			adminTmp.setAdmin_name(admin.getAdmin_name());
			adminTmp.setId(admin.getId());
			adminTmp.setAdmin_password(oldPassword);
			JOptionPane.showMessageDialog(this, adminDao.editPassword(adminTmp, newPassword));
			adminDao.closeDao();
			return;
		}
		if("学生".equals(MainFrame.userType.getName())){
			StudentDao studentDao = new StudentDao();
			Student studentTmp = new Student();
			Student student = (Student)MainFrame.userObject;
			studentTmp.setStudent_name(student.getStudent_name());
			studentTmp.setStudent_password(oldPassword);
			studentTmp.setStudent_id(student.getStudent_id());
			JOptionPane.showMessageDialog(this, studentDao.editPassword(studentTmp, newPassword));
			studentDao.closeDao();
			return;
		}
		if("教师".equals(MainFrame.userType.getName())){
			TeacherDao teacherDao = new TeacherDao();
			Teacher teacherTmp = new Teacher();
			Teacher teacher = (Teacher)MainFrame.userObject;
			teacherTmp.setTeacher_name(teacher.getTeacher_name());
			teacherTmp.setTeacher_password(oldPassword);
			teacherTmp.setTeacher_id(teacher.getTeacher_id());
			JOptionPane.showMessageDialog(this, teacherDao.editPassword(teacherTmp, newPassword));
			teacherDao.closeDao();
			return;
		}
	}

}
