package com.gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

public class AddTeacherFrame extends JInternalFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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
		setTitle("\u6DFB\u52A0\u6559\u5E08");
		setBounds(100, 100, 435, 327);
		
		JLabel label = new JLabel("\u59D3\u540D\uFF1A");
		label.setIcon(new ImageIcon(AddTeacherFrame.class.getResource("/img/\u6559\u5E08.png")));
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u804C\u79F0\uFF1A");
		label_1.setIcon(new ImageIcon(AddTeacherFrame.class.getResource("/img/\u804C\u79F0.png")));
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5BC6\u7801\uFF1A");
		label_2.setIcon(new ImageIcon(AddTeacherFrame.class.getResource("/img/\u539F\u5BC6\u7801.png")));
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JButton button = new JButton("\u786E\u8BA4\u6DFB\u52A0");
		button.setIcon(new ImageIcon(AddTeacherFrame.class.getResource("/img/\u786E\u8BA4.png")));
		button.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JButton button_1 = new JButton("\u91CD\u7F6E");
		button_1.setIcon(new ImageIcon(AddTeacherFrame.class.getResource("/img/\u91CD\u7F6E.png")));
		button_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
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
									.addComponent(textField_2))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField_1))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(78)
							.addComponent(button)
							.addGap(29)
							.addComponent(button_1)))
					.addContainerGap(105, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(29)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(36)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(button)
						.addComponent(button_1))
					.addContainerGap(65, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);

	}
}
