package com.gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.bean.Course;
import com.bean.Teacher;
import com.dao.CourseDao;
import com.dao.TeacherDao;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;

public class CourseManageFrame extends JInternalFrame {
	private JTextField searchCourseNameTextField;
	private JTable courseListTable;
	private JTextField editCourseTextField;
	private JTextField editCourseNumTextField;
	private JComboBox editCourseTeacherComboBox;
	private JComboBox searchTeacherComboBox;
	private List<Teacher> teacherList = new ArrayList<Teacher>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourseManageFrame frame = new CourseManageFrame();
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
	public CourseManageFrame() {
		setClosable(true); //¿É¹Ø±Õ
		setIconifiable(true); //¿É·Å´óËõÐ¡
		setTitle("\u8BFE\u7A0B\u7BA1\u7406");
		setBounds(100, 100, 971, 624);
		
		JLabel label = new JLabel("\u8BFE\u7A0B\u540D\u79F0\uFF1A");
		label.setIcon(new ImageIcon(CourseManageFrame.class.getResource("/img/\u8BFE\u7A0B.png")));
		label.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		searchCourseNameTextField = new JTextField();
		searchCourseNameTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6388\u8BFE\u8001\u5E08\uFF1A");
		label_1.setIcon(new ImageIcon(CourseManageFrame.class.getResource("/img/\u6559\u5E08.png")));
		label_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JButton searchButton = new JButton("\u67E5\u8BE2");
		searchButton.setIcon(new ImageIcon(CourseManageFrame.class.getResource("/img/\u67E5\u8BE2.png")));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u7F16\u8F91\u8BFE\u7A0B\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		searchTeacherComboBox = new JComboBox();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(111)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchCourseNameTextField, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
							.addGap(55)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchTeacherComboBox, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
							.addGap(60)
							.addComponent(searchButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(91)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 772, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 771, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(92, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(45)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(searchCourseNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(searchButton)
						.addComponent(searchTeacherComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 252, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(46, Short.MAX_VALUE))
		);
		
		JLabel label_2 = new JLabel("\u8BFE\u7A0B\u540D\u79F0\uFF1A");
		label_2.setIcon(new ImageIcon(CourseManageFrame.class.getResource("/img/\u8BFE\u7A0B.png")));
		label_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		editCourseTextField = new JTextField();
		editCourseTextField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u6388\u8BFE\u8001\u5E08\uFF1A");
		label_3.setIcon(new ImageIcon(CourseManageFrame.class.getResource("/img/\u6559\u5E08.png")));
		label_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		editCourseTeacherComboBox = new JComboBox();
		
		JLabel label_4 = new JLabel("\u5B66\u751F\u4EBA\u6570\uFF1A");
		label_4.setIcon(new ImageIcon(CourseManageFrame.class.getResource("/img/\u5B66\u751F\u4EBA\u6570.png")));
		label_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		editCourseNumTextField = new JTextField();
		editCourseNumTextField.setColumns(10);
		
		JButton submitEditButton = new JButton("\u4FEE\u6539");
		submitEditButton.setIcon(new ImageIcon(CourseManageFrame.class.getResource("/img/\u786E\u8BA4.png")));
		submitEditButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		
		JButton deleteCourseButton = new JButton("\u5220\u9664");
		deleteCourseButton.setIcon(new ImageIcon(CourseManageFrame.class.getResource("/img/\u5220\u9664 .png")));
		deleteCourseButton.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editCourseNumTextField))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editCourseTextField, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)))
					.addGap(73)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_3)
						.addComponent(submitEditButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(editCourseTeacherComboBox, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
						.addComponent(deleteCourseButton, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(134, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(editCourseTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(editCourseTeacherComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_4)
						.addComponent(editCourseNumTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(deleteCourseButton)
						.addComponent(submitEditButton))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		courseListTable = new JTable();
		courseListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BFE\u7A0B\u7F16\u53F7", "\u8BFE\u7A0B\u540D\u79F0", "\u6388\u8BFE\u8001\u5E08", "\u8BFE\u7A0B\u5BB9\u91CF", "\u5DF2\u9009\u4EBA\u6570"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(courseListTable);
		getContentPane().setLayout(groupLayout);
		setTeacherCombox();
		setCourseListTable(new Course());

	}
	private void setCourseListTable(Course course){
		CourseDao courseDao = new CourseDao();
		List<Course> courseList = courseDao.getCourseList(course);
		DefaultTableModel dft = (DefaultTableModel) courseListTable.getModel();
		dft.setRowCount(0);
		for (Course c : courseList) {
			Vector v = new Vector();
			v.add(c.getCourse_id());
			v.add(c.getCourse_name());
			//v.add(c.getTeacher_id());
			v.add(getTeacherNameById(c.getTeacher_id()));
			v.add(c.getMaxNumber());
			v.add(c.getSelectedNum());
			
			dft.addRow(v);
		}
		courseDao.closeDao();
	}
	private void setTeacherCombox(){
		TeacherDao teacherDao = new TeacherDao();
		teacherList = teacherDao.getTeacherList(new Teacher());
		teacherDao.closeDao();
		for (Teacher teacher : teacherList) {
			editCourseTeacherComboBox.addItem(teacher);
			searchTeacherComboBox.addItem(teacher);
		}
	}
	private String getTeacherNameById(int teacher_id){
		String retString = "";
		for (Teacher teacher : teacherList) {
			if(teacher.getTeacher_id() == teacher_id){
				retString = teacher.getTeacher_name();
				break;
			}
		}
		return retString;
	}
	private int getTeacherIdByName(String teacher_name){
		int retId = -1;
		for (Teacher teacher : teacherList) {
			if(teacher_name.equals(teacher.getTeacher_name())){
				retId = teacher.getTeacher_id();
				break;
			}
		}
		return retId;
	}

}
