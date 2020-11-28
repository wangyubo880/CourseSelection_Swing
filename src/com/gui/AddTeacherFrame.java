package com.gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.bean.Teacher;
import com.dao.TeacherDao;
import com.db.StringUtil;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddTeacherFrame extends JInternalFrame {
	private JTextField teacherNameTextField;
	private JTextField teacherTitleTextField;
	private JTextField teacherPasswordTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTeacherFrame frame = new AddTeacherFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddTeacherFrame() {
		setClosable(true); //可关闭
		setIconifiable(true); //可放大缩小
		setTitle("\u6DFB\u52A0\u6559\u5E08");
		setBounds(100, 100, 435, 327);
		
		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		label.setIcon(new ImageIcon(AddTeacherFrame.class.getResource("/img/\u6559\u5E08.png")));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		teacherNameTextField = new JTextField();
		teacherNameTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u804C\u79F0\uFF1A");
		label_1.setIcon(new ImageIcon(AddTeacherFrame.class.getResource("/img/\u804C\u79F0.png")));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		teacherTitleTextField = new JTextField();
		teacherTitleTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5BC6\u7801\uFF1A");
		label_2.setIcon(new ImageIcon(AddTeacherFrame.class.getResource("/img/\u539F\u5BC6\u7801.png")));
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		teacherPasswordTextField = new JTextField();
		teacherPasswordTextField.setColumns(10);
		
		JButton submitButton = new JButton("\u786E\u8BA4\u6DFB\u52A0");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addTeacherAct(ae);
			}
		});
		submitButton.setIcon(new ImageIcon(AddTeacherFrame.class.getResource("/img/\u786E\u8BA4.png")));
		submitButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(AddTeacherFrame.class.getResource("/img/\u91CD\u7F6E.png")));
		resetButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(68)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(teacherPasswordTextField))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(teacherTitleTextField))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(teacherNameTextField, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(78)
							.addComponent(submitButton)
							.addGap(29)
							.addComponent(resetButton)))
					.addContainerGap(105, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(teacherNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(teacherTitleTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(teacherPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(submitButton)
						.addComponent(resetButton))
					.addContainerGap(65, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}

	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		teacherNameTextField.setText("");
		teacherTitleTextField.setText("");
		teacherPasswordTextField.setText("");
	}

	protected void addTeacherAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		//获取值
		String teacherName = teacherNameTextField.getText().toString();
		String teacherTitle = teacherTitleTextField.getText().toString();
		String teacherPassword = teacherPasswordTextField.getText().toString();
		
		if(StringUtil.isEmpty(teacherName)){
			JOptionPane.showMessageDialog(this, "教师姓名必须填写！");
			return;
		}
		if(StringUtil.isEmpty(teacherTitle)){
			JOptionPane.showMessageDialog(this, "教师职称必须填写！");
			return;
		}
		if(StringUtil.isEmpty(teacherPassword)){
			JOptionPane.showMessageDialog(this, "教师登录密码必须填写！");
			return;
		}
		Teacher teacher = new Teacher();
		teacher.setTeacher_name(teacherName);
		teacher.setTeacher_title(teacherTitle);
		teacher.setTeacher_password(teacherPassword);
		TeacherDao teacherDao = new TeacherDao();
		if(teacherDao.addTeacher(teacher)){
			JOptionPane.showMessageDialog(this, "教师添加成功！");
		}else{
			JOptionPane.showMessageDialog(this, "教师添加失败！");
		}
		resetValue(ae);
	}
}
