package com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bean.Student;
import com.dao.StudentDao;
import com.db.StringUtil;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddStudentFrame extends JInternalFrame {

	private JPanel contentPane;
	private JTextField studentNumberTextField;
	private JTextField studentNameTextField;
	private JPasswordField studentPasswordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudentFrame frame = new AddStudentFrame();
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
	public AddStudentFrame() {
		setTitle("\u6DFB\u52A0\u5B66\u751F");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setClosable(true); //¿É¹Ø±Õ
		setIconifiable(true); //¿É·Å´óËõÐ¡
		
		JLabel label = new JLabel("\u5B66\u751F\u4FE1\u606F\u6DFB\u52A0");
		label.setIcon(new ImageIcon(AddStudentFrame.class.getResource("/img/\u5B66\u751F\u6DFB\u52A02.png")));
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.BOLD, 16));
		
		JLabel label_1 = new JLabel("\u5B66\u53F7\uFF1A");
		label_1.setIcon(new ImageIcon(AddStudentFrame.class.getResource("/img/\u5B66\u53F7.png")));
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		studentNumberTextField = new JTextField();
		studentNumberTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u59D3\u540D\uFF1A");
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		label_2.setIcon(new ImageIcon(AddStudentFrame.class.getResource("/img/\u7528\u6237\u540D2.png")));
		
		studentNameTextField = new JTextField();
		studentNameTextField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u5BC6\u7801\uFF1A");
		label_3.setIcon(new ImageIcon(AddStudentFrame.class.getResource("/img/\u539F\u5BC6\u7801.png")));
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		studentPasswordField = new JPasswordField();
		
		JButton submitButton = new JButton("\u786E\u8BA4");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				studentAddAct(ae);
			}
		});
		submitButton.setIcon(new ImageIcon(AddStudentFrame.class.getResource("/img/\u786E\u8BA4.png")));
		submitButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		button_1.setIcon(new ImageIcon(AddStudentFrame.class.getResource("/img/\u91CD\u7F6E.png")));
		button_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(67)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
										.addComponent(label_2)
										.addComponent(label_1)
										.addComponent(label_3))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(studentPasswordField)
										.addComponent(studentNameTextField)
										.addComponent(studentNumberTextField, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)))
								.addComponent(submitButton)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(210)
							.addComponent(button_1)))
					.addContainerGap(111, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(127)
					.addComponent(label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(131))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addComponent(label)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(studentNumberTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(studentNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(studentPasswordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_1)
						.addComponent(submitButton))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	protected void studentAddAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		String studentName = studentNameTextField.getText().toString();
		String studentPassword = studentPasswordField.getText().toString();
		String studentNumber = studentNumberTextField.getText().toString();
		if(StringUtil.isEmpty(studentNumber)){
			JOptionPane.showMessageDialog(this, "ÇëÌîÐ´Ñ§ºÅ!");
			return;
		}
		if(StringUtil.isEmpty(studentName)){
			JOptionPane.showMessageDialog(this, "ÇëÌîÐ´Ñ§ÉúÐÕÃû!");
			return;
		}
		if(StringUtil.isEmpty(studentPassword)){
			JOptionPane.showMessageDialog(this, "ÇëÌîÐ´ÃÜÂë!");
			return;
		}
		Student student = new Student();
		student.setStudent_number(studentNumber);
		student.setStudent_name(studentName);
		student.setStudent_password(studentPassword);
		StudentDao studentDao = new StudentDao();
		if(studentDao.addStudent(student)){
			JOptionPane.showMessageDialog(this, "Ìí¼Ó³É¹¦!");
		}else{
			JOptionPane.showMessageDialog(this, "Ìí¼ÓÊ§°Ü!");
		}
		resetValue(ae);
	}

	protected void resetValue(ActionEvent ae) {
		// TODO Auto-generated method stub
		studentNumberTextField.setText("");
		studentNameTextField.setText("");
		studentPasswordField.setText("");
	}
}
