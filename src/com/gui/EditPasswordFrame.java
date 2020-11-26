package com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.bean.UserType;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

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
		setClosable(true); //¿É¹Ø±Õ
		setIconifiable(true); //¿É·Å´óËõÐ¡
		
		JLabel label = new JLabel("    \u539F\u5BC6\u7801\uFF1A ");
		label.setIcon(new ImageIcon(EditPasswordFrame.class.getResource("/img/\u539F\u5BC6\u7801.png")));
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		oldPasswordTextField = new JTextField();
		oldPasswordTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("    \u65B0\u5BC6\u7801\uFF1A ");
		label_1.setIcon(new ImageIcon(EditPasswordFrame.class.getResource("/img/\u7BA1\u7406\u5458\u4FEE\u6539\u5BC6\u7801.png")));
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		newPasswordTextField = new JTextField();
		newPasswordTextField.setColumns(10);
		
		JLabel label_2 = new JLabel(" \u786E\u8BA4\u5BC6\u7801\uFF1A");
		label_2.setIcon(new ImageIcon(EditPasswordFrame.class.getResource("/img/\u786E\u8BA4\u5BC6\u7801.png")));
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		confirmPasswordTextField = new JTextField();
		confirmPasswordTextField.setColumns(10);
		
		JButton submitButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		submitButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		submitButton.setIcon(new ImageIcon(EditPasswordFrame.class.getResource("/img/\u786E\u8BA4.png")));
		
		JLabel label_3 = new JLabel(" \u5F53\u524D\u7528\u6237\uFF1A ");
		label_3.setIcon(new ImageIcon(EditPasswordFrame.class.getResource("/img/\u7528\u6237\u540D2.png")));
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		currentUserLabel = new JLabel("New label");
		currentUserLabel.setEnabled(false);
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
		
	}

}
