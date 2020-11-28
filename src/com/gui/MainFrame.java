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
	private JMenuItem teacherAddMenuItem;
	private JMenu manageTeacherMenu;
	private JMenu courseMenu;

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
		menu.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				editPassword(ae);
			}
		});
		menuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/img/\u4FEE\u6539\u5BC6\u7801.png")));
		menuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		menu.add(menuItem);
		//ÍË³öÏµÍ³
		JMenuItem menuItem_1 = new JMenuItem("\u9000\u51FA\u7CFB\u7EDF");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(MainFrame.this, "ÊÇ·ñÈ·¶¨ÍË³ö") == JOptionPane.OK_OPTION){
					System.exit(0);
				}
			}
		});
		menuItem_1.setIcon(new ImageIcon(MainFrame.class.getResource("/img/\u9000\u51FA.png")));
		menuItem_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		menu.add(menuItem_1);
		
		JMenu menu_1 = new JMenu("\u5B66\u751F\u7BA1\u7406");
		menu_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
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
		studentAddMenuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		studentAddMenuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/img/\u5B66\u751F\u6DFB\u52A0.png")));
		menu_1.add(studentAddMenuItem);
		
		JMenuItem studentListMenuItem = new JMenuItem("\u5B66\u751F\u5217\u8868");
		studentListMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentManageFrames studentManageFrame=new StudentManageFrames();
				studentManageFrame.setVisible(true);
				desktopPane.add(studentManageFrame);
			}
		});
		studentListMenuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		studentListMenuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/img/\u5B66\u751F\u5217\u8868.png")));
		menu_1.add(studentListMenuItem);
		
		manageTeacherMenu = new JMenu("\u6559\u5E08\u7BA1\u7406");
		manageTeacherMenu.setIcon(new ImageIcon(MainFrame.class.getResource("/img/\u6559\u5E08.png")));
		manageTeacherMenu.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		menuBar.add(manageTeacherMenu);
		
		teacherAddMenuItem = new JMenuItem("\u6559\u5E08\u6DFB\u52A0");
		teacherAddMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddTeacherFrame addTeacherFrm = new AddTeacherFrame();
				addTeacherFrm.setVisible(true);
				desktopPane.add(addTeacherFrm);
			}
		});
		teacherAddMenuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/img/\u6559\u5E08\u6DFB\u52A0.png")));
		teacherAddMenuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		manageTeacherMenu.add(teacherAddMenuItem);
		
		JMenuItem teacherListMenuItem = new JMenuItem("\u6559\u5E08\u5217\u8868");
		teacherListMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TeacherManageFrame manageTeacherFrm = new TeacherManageFrame();
				manageTeacherFrm.setVisible(true);
				desktopPane.add(manageTeacherFrm);
			}
		});
		teacherListMenuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/img/\u6559\u5E08\u5217\u8868.png")));
		teacherListMenuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		manageTeacherMenu.add(teacherListMenuItem);
		
		JMenu menu_2 = new JMenu("\u8BFE\u7A0B\u7BA1\u7406");
		menu_2.setIcon(new ImageIcon(MainFrame.class.getResource("/img/\u8BFE\u7A0B\u7BA1\u7406.png")));
		menu_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		menuBar.add(menu_2);
		
		JMenuItem addCourseMenuItem = new JMenuItem("\u6DFB\u52A0\u8BFE\u7A0B");
		addCourseMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddCourseFrame addCourseFrm = new AddCourseFrame();
				addCourseFrm.setVisible(true);
				desktopPane.add(addCourseFrm);
			}
		});
		addCourseMenuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/img/\u6559\u5E08\u6DFB\u52A0.png")));
		addCourseMenuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		menu_2.add(addCourseMenuItem);
		
		JMenuItem courseListMenuItem = new JMenuItem("\u8BFE\u7A0B\u5217\u8868");
		courseListMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CourseManageFrame manageCourseFrm = new CourseManageFrame();
				manageCourseFrm.setVisible(true);
				desktopPane.add(manageCourseFrm);
			}
		});
		courseListMenuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/img/\u8BFE\u7A0B\u5217\u8868.png")));
		courseListMenuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		menu_2.add(courseListMenuItem);
		
		courseMenu = new JMenu("\u9009\u8BFE\u7BA1\u7406");
		courseMenu.setIcon(new ImageIcon(MainFrame.class.getResource("/img/\u9009\u8BFE\u7BA1\u7406.png")));
		courseMenu.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		menuBar.add(courseMenu);
		//Ñ¡¿ÎÑ¡¿Î
		JMenuItem StudentSelectCourseMenuItem = new JMenuItem("\u9009\u8BFE");
		StudentSelectCourseMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentCourseFrame manageSelectedCourseFrm = new StudentCourseFrame();
				manageSelectedCourseFrm.setVisible(true);
				desktopPane.add(manageSelectedCourseFrm);
			}
		});
		StudentSelectCourseMenuItem.setIcon(new ImageIcon(MainFrame.class.getResource("/img/\u9009\u62E9.png")));
		StudentSelectCourseMenuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		courseMenu.add(StudentSelectCourseMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(SystemColor.control);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		setLocationRelativeTo(null);
		setAuthority();
	}

	protected void editPassword(ActionEvent ae) {
		// TODO Auto-generated method stub
		//new EditPasswordFrame().setVisible(true);
		EditPasswordFrame editPasswordFrm = new EditPasswordFrame();
		editPasswordFrm.setVisible(true);
		desktopPane.add(editPasswordFrm);
	}
	private void setAuthority(){
		if("Ñ§Éú".equals(userType.getName())){
			studentAddMenuItem.setEnabled(false);
			manageTeacherMenu.setEnabled(false);
		}
		if("½ÌÊ¦".equals(userType.getName())){
			teacherAddMenuItem.setEnabled(false);
		}
	}
}
