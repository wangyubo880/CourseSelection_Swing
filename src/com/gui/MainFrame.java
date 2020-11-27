package com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.bean.UserType;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.Color;
import java.awt.SystemColor;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	public static UserType userType;
	public static Object userObject;
	private JDesktopPane desktopPane;
	private JMenuItem studentAddMenuItem;


	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainFrame frame = new MainFrame();
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
	public MainFrame(UserType userType,Object userObject) {
		this.userType=userType;
		this.userObject=userObject;
		setTitle("\u9009\u8BFE\u7CFB\u7EDF\u4E3B\u754C\u9762");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1170, 861);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u7CFB\u7EDF\u8BBE\u7F6E");
		menu.setIcon(new ImageIcon(MainFrame.class.getResource("/img/\u7CFB\u7EDF\u8BBE\u7F6E.png")));
		menu.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				editPassword(ae);
			}
		});
		menuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/img/\u4FEE\u6539\u5BC6\u7801.png")));
		menuItem.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		menu.add(menuItem);
		//�˳�ϵͳ
		JMenuItem menuItem_1 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(MainFrame.this, "�Ƿ�ȷ���˳�") == JOptionPane.OK_OPTION){
					System.exit(0);
				}
			}
		});
		menuItem_1.setIcon(new ImageIcon(MainFrame.class.getResource("/img/\u9000\u51FA.png")));
		menuItem_1.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		menu.add(menuItem_1);
		
		JMenu menu_1 = new JMenu("\u5B66\u751F\u7BA1\u7406");
		menu_1.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		menu_1.setIcon(new ImageIcon(MainFrame.class.getResource("/img/\u5B66\u751F\u7BA1\u7406.png")));
		menuBar.add(menu_1);
		
		studentAddMenuItem = new JMenuItem("\u5B66\u751F\u6DFB\u52A0");
		studentAddMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				EditPasswordFrame editPasswordFrm = new EditPasswordFrame();
//				editPasswordFrm.setVisible(true);
//				desktopPane.add(editPasswordFrm);
				AddStudentFrame addStudentFrames = new AddStudentFrame();
				addStudentFrames.setVisible(true);
				desktopPane.add(addStudentFrames);
				//editPasswordFrm.setVisible(true);
				//desktopPane.add(editPasswordFrm);
			}
		});
		studentAddMenuItem.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		studentAddMenuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/img/\u5B66\u751F\u6DFB\u52A0.png")));
		menu_1.add(studentAddMenuItem);
		
		JMenuItem menuItem_3 = new JMenuItem("\u5B66\u751F\u5217\u8868");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentManageFrames studentManageFrame=new StudentManageFrames();
				studentManageFrame.setVisible(true);
				desktopPane.add(studentManageFrame);
			}
		});
		menuItem_3.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		menuItem_3.setIcon(new ImageIcon(MainFrame.class.getResource("/img/\u5B66\u751F\u5217\u8868.png")));
		menu_1.add(menuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.control);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		setLocationRelativeTo(null);
	}

	protected void editPassword(ActionEvent ae) {
		// TODO Auto-generated method stub
		//new EditPasswordFrame().setVisible(true);
		EditPasswordFrame editPasswordFrm = new EditPasswordFrame();
		editPasswordFrm.setVisible(true);
		desktopPane.add(editPasswordFrm);
	}

}
