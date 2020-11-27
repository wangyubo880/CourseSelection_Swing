package com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import com.bean.Admin;
import com.bean.Student;
import com.bean.UserType;
import com.dao.AdminDao;
import com.dao.StudentDao;
import com.db.StringUtil;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTextField;
	private JPasswordField passwordTextField;
	private JComboBox userTypeComboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setTitle("\u767B\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		JLabel label = new JLabel("\u5B66\u751F\u9009\u8BFE\u7CFB\u7EDF\u767B\u5F55");
		label.setIcon(new ImageIcon(LoginFrame.class.getResource("/img/\u5B66\u751F (1).png")));
		label.setFont(new Font("微软雅黑", Font.BOLD, 18));
		
		JLabel label_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		label_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/img/\u7528\u6237\u540D1.png")));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		userNameTextField = new JTextField();
		userNameTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5BC6  \u7801 \uFF1A");
		label_2.setIcon(new ImageIcon(LoginFrame.class.getResource("/img/\u5BC6\u7801.png")));
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		passwordTextField = new JPasswordField();
		passwordTextField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u7C7B  \u578B \uFF1A");
		label_3.setIcon(new ImageIcon(LoginFrame.class.getResource("/img/\u7C7B\u578B.png")));
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		userTypeComboBox = new JComboBox();
		userTypeComboBox.setModel(new DefaultComboBoxModel(new UserType[] {UserType.ADMIN, UserType.TEACHER, UserType.STUDENT}));
		userTypeComboBox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton loginButton = new JButton("\u767B\u5F55");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				loginAct(ae);
			}
		});
		loginButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		loginButton.setIcon(new ImageIcon(LoginFrame.class.getResource("/img/\u767B\u5F55.png")));
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		resetButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		resetButton.setIcon(new ImageIcon(LoginFrame.class.getResource("/img/\u91CD\u7F6E.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(135, Short.MAX_VALUE)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
					.addGap(74))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(122)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_1)
								.addComponent(label_2))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
								.addComponent(passwordTextField)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(9)
							.addComponent(loginButton)
							.addPreferredGap(ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
							.addComponent(resetButton)
							.addGap(15))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(label_3)
							.addGap(18)
							.addComponent(userTypeComboBox, 0, 147, Short.MAX_VALUE)))
					.addGap(161))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(12)
					.addComponent(label, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(userNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_2))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(userTypeComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(loginButton)
						.addComponent(resetButton))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void loginAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		String userName=userNameTextField.getText().toString();
		String passWord=passwordTextField.getText().toString();
		UserType selectedItem = (UserType)userTypeComboBox.getSelectedItem();
		//用户名不为空
		if(StringUtil.isEmpty(userName)) {
			JOptionPane.showMessageDialog(this, "用户名不能为空");
			return;
		}
		//密码不为空
		if(StringUtil.isEmpty(passWord)) {
			JOptionPane.showMessageDialog(this, "密码不能为空");
			return;
		}
		Admin admin = null;
		if("系统管理员".equals(selectedItem.getName())) {
			AdminDao adminDao = new AdminDao();
			Admin adminTmp = new Admin();
			adminTmp.setAdmin_name(userName);
			adminTmp.setAdmin_password(passWord);
			admin = adminDao.login(adminTmp);
			adminDao.closeDao();
			if(admin == null){
				JOptionPane.showMessageDialog(this, "用户名或密码错误！");
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎【"+selectedItem.getName()+"】："+admin.getAdmin_name()+"登录本系统");
			this.dispose();  //登录成功后隐藏登录界面
			new MainFrame(selectedItem, admin).setVisible(true);  //传值 登录用户信息
			//系统管理员登录
		}else if("教师".equals(selectedItem.getName())) {
			//教师登录
		}else {
			//学生登陆
			Student student = null; 
			StudentDao studentDao = new StudentDao();
			Student studentTmp = new Student();
			studentTmp.setStudent_name(userName);
			studentTmp.setStudent_password(passWord);
			student = studentDao.login(studentTmp);
			studentDao.closeDao();
			if(student == null){
				JOptionPane.showMessageDialog(this, "用户名或密码错误！");
				return;
			}
			JOptionPane.showMessageDialog(this, "欢迎【"+selectedItem.getName()+"】："+student.getStudent_name()+"登录本系统！");
			this.dispose();
			new MainFrame(selectedItem, student).setVisible(true);
		}
		
	}

	protected void resetValue(ActionEvent ae) {
		// 实现重置reset
		userNameTextField.setText("");
		passwordTextField.setText("");
		userTypeComboBox.setSelectedIndex(0);
		
	}
}
