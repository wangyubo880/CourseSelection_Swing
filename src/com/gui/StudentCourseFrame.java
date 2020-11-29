package com.gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.bean.Course;
import com.bean.Student;
import com.bean.StudentCourse;
import com.dao.CourseDao;
import com.dao.StudentCourseDao;
import com.dao.StudentDao;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class StudentCourseFrame extends JInternalFrame {
	private JTable selectedCourseListTable;
	private JComboBox searchCourseComboBox;
	private JComboBox searchStudentComboBox;
	private JComboBox editSelectedStudentComboBox;
	private JComboBox editSelectedCourseComboBox;
	private List<Student> studentList = new ArrayList<Student>();
	private List<Course> courseList = new ArrayList<Course>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentCourseFrame frame = new StudentCourseFrame();
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
	public StudentCourseFrame() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u9009\u8BFE\u7BA1\u7406");
		setBounds(100, 100, 796, 560);
		
		JLabel label = new JLabel("\u5B66\u751F\uFF1A");
		label.setIcon(new ImageIcon(StudentCourseFrame.class.getResource("/img/\u7528\u6237\u540D2.png")));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		searchStudentComboBox = new JComboBox();
		searchStudentComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				studentChangeAct(ie);
			}
		});
		
		JLabel label_1 = new JLabel("\u8BFE\u7A0B\uFF1A");
		label_1.setIcon(new ImageIcon(StudentCourseFrame.class.getResource("/img/\u8BFE\u7A0B.png")));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		searchCourseComboBox = new JComboBox();
		
		JButton confirmSelectedButton = new JButton("\u9009\u8BFE");
		confirmSelectedButton.setIcon(new ImageIcon(StudentCourseFrame.class.getResource("/img/\u9009\u62E9.png")));
		confirmSelectedButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		confirmSelectedButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				confirmSelectedCourse(ae);
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u4FEE\u6539\u9009\u8BFE", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValue(e);
			}
		});
		button.setIcon(new ImageIcon(StudentCourseFrame.class.getResource("/img/\u91CD\u7F6E.png")));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(65)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 662, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 659, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addGap(18)
							.addComponent(searchStudentComboBox, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addGap(28)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchCourseComboBox, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(confirmSelectedButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(button)))
					.addContainerGap(29, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(searchStudentComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(searchCourseComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(confirmSelectedButton)
						.addComponent(button))
					.addGap(35)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(34, Short.MAX_VALUE))
		);
		
		JLabel label_2 = new JLabel("\u5B66\u751F\uFF1A");
		label_2.setIcon(new ImageIcon(StudentCourseFrame.class.getResource("/img/\u7528\u6237\u540D2.png")));
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editSelectedStudentComboBox = new JComboBox();
		
		JLabel label_3 = new JLabel("\u8BFE\u7A0B\uFF1A");
		label_3.setIcon(new ImageIcon(StudentCourseFrame.class.getResource("/img/\u8BFE\u7A0B.png")));
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editSelectedCourseComboBox = new JComboBox();
		
		JButton confirmEditButton = new JButton("\u4FEE\u6539");
		confirmEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				editSelectCourseAct(ae);
			}
		});
		confirmEditButton.setIcon(new ImageIcon(StudentCourseFrame.class.getResource("/img/\u786E\u8BA4\u4FEE\u6539.png")));
		confirmEditButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton deleteCourseButton = new JButton("\u9000\u9009");
		deleteCourseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				deleteSelectedCourse(ae);
			}
		});
		deleteCourseButton.setIcon(new ImageIcon(StudentCourseFrame.class.getResource("/img/\u9000\u9009.png")));
		deleteCourseButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(editSelectedStudentComboBox, GroupLayout.PREFERRED_SIZE, 164, GroupLayout.PREFERRED_SIZE)
					.addGap(47)
					.addComponent(label_3)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(editSelectedCourseComboBox, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(95, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(151)
					.addComponent(confirmEditButton)
					.addPreferredGap(ComponentPlacement.RELATED, 170, Short.MAX_VALUE)
					.addComponent(deleteCourseButton)
					.addGap(167))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(editSelectedStudentComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(editSelectedCourseComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(deleteCourseButton)
						.addComponent(confirmEditButton))
					.addContainerGap(17, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		selectedCourseListTable = new JTable();
		selectedCourseListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				selectedCourse(me);
			}
		});
		selectedCourseListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u9009\u8BFE\u7F16\u53F7", "\u5B66\u751F\u59D3\u540D", "\u8BFE\u7A0B\u540D\u79F0"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		selectedCourseListTable.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		scrollPane.setViewportView(selectedCourseListTable);
		getContentPane().setLayout(groupLayout);
		setStudentCombox();
		setCourseCombox();
		Student student=(Student) searchStudentComboBox.getSelectedItem();
		StudentCourse sc=new StudentCourse();
		sc.setStudent_id(student.getStudent_id());
		getSelectedCourse(sc);
		initTable();
		setAuthority();

	}
	protected void resetValue(ActionEvent e) {
		// TODO Auto-generated method stub
		searchCourseComboBox.setSelectedIndex(0);
		searchStudentComboBox.setSelectedIndex(0);
	}

	protected void deleteSelectedCourse(ActionEvent ae) {
		// TODO Auto-generated method stub
		int row = selectedCourseListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请选择要修改的数据！");
			return;
		}
		int selected_id = Integer.parseInt(selectedCourseListTable.getValueAt(row, 0).toString());
		String courseName = selectedCourseListTable.getValueAt(row, 2).toString();
		StudentCourse sc = new StudentCourse();
		sc.setId(selected_id);
		StudentCourseDao scDao = new StudentCourseDao();
		CourseDao courseDao = new CourseDao();
		if(scDao.delete(selected_id)){
			if(courseDao.updateSelectedNum(getCourseIdByName(courseName), -1)){
				JOptionPane.showMessageDialog(this, "退课成功！");
			}else{
				JOptionPane.showMessageDialog(this, "退课成功，更新课程信息失败！");
			}
		}else{
			JOptionPane.showMessageDialog(this, "退课失败！");
		}
		scDao.closeDao();
		courseDao.closeDao();
		initTable();
	}

	protected void editSelectCourseAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		int row = selectedCourseListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请选择要修改的数据！");
			return;
		}
		int selected_id = Integer.parseInt(selectedCourseListTable.getValueAt(row, 0).toString());
		String studentName = selectedCourseListTable.getValueAt(row, 1).toString();
		String courseName = selectedCourseListTable.getValueAt(row, 2).toString();
		Student student = (Student) editSelectedStudentComboBox.getSelectedItem();
		Course course = (Course) editSelectedCourseComboBox.getSelectedItem();
		if(studentName.equals(student.getStudent_name())&&courseName.equals(course.getCourse_name())){
			JOptionPane.showMessageDialog(this, "还未修改数据！");
			return;
		}
		CourseDao courseDao = new CourseDao();
		if(!courseDao.selectedEnable(course.getCourse_id())){
			JOptionPane.showMessageDialog(this, "该课程已经选满，不能再选!");
			return;
		}
		
		StudentCourse sc = new StudentCourse();
		sc.setId(selected_id);
		sc.setStudent_id(student.getStudent_id());
		sc.setCourse_id(course.getCourse_id());
		StudentCourseDao scDao = new StudentCourseDao();
		if(scDao.isSelected(sc)){
			JOptionPane.showMessageDialog(this, "已经选过这门课程了，不能再选!");
			return;
		}
		if(scDao.updateSelectedCourse(sc)){
			if(courseDao.updateSelectedNum(sc.getCourse_id(),1)){
				if(courseDao.updateSelectedNum(getCourseIdByName(courseName), -1)){
					JOptionPane.showMessageDialog(this, "修改成功！!");
				}
			}else{
				JOptionPane.showMessageDialog(this, "修改成功，课程信息更新失败!");
			}
		}
		courseDao.closeDao();
		scDao.closeDao();
		initTable();
		
	}

	protected void selectedCourse(MouseEvent me) {
		// TODO Auto-generated method stub
		int row = selectedCourseListTable.getSelectedRow();
		String studentName = selectedCourseListTable.getValueAt(row, 1).toString();
		String courseName = selectedCourseListTable.getValueAt(row, 2).toString();
		for (int i = 0; i < editSelectedStudentComboBox.getItemCount();i++) {
			Student student = (Student) editSelectedStudentComboBox.getItemAt(i);
			if(studentName.equals(student.getStudent_name())){
				editSelectedStudentComboBox.setSelectedIndex(i);
				break;
			}
		}
		for (int i = 0; i < editSelectedCourseComboBox.getItemCount();i++) {
			Course course = (Course) editSelectedCourseComboBox.getItemAt(i);
			if(courseName.equals(course.getCourse_name())){
				editSelectedCourseComboBox.setSelectedIndex(i);
				break;
			}
		}
	}

	protected void studentChangeAct(ItemEvent ie) {
		// TODO Auto-generated method stub
		if(ie.getStateChange() == ItemEvent.SELECTED){
			initTable();
		}
		//JOptionPane.showMessageDialog(this, ie.getStateChange());
	}

	protected void confirmSelectedCourse(ActionEvent ae) {
		// TODO Auto-generated method stub
		Student sstudent = (Student) searchStudentComboBox.getSelectedItem();
		Course scourse = (Course) searchCourseComboBox.getSelectedItem();
		StudentCourse sc = new StudentCourse();
		sc.setStudent_id(sstudent.getStudent_id());
		sc.setCourse_id(scourse.getCourse_id());
		CourseDao courseDao = new CourseDao();
		if(!courseDao.selectedEnable(scourse.getCourse_id())){
			JOptionPane.showMessageDialog(this, "该课程已经选满，不能再选!");
			return;
		}
		StudentCourseDao scDao = new StudentCourseDao();
		if(scDao.isSelected(sc)){
			JOptionPane.showMessageDialog(this, "已经选过这门课程了，不能再选!");
			return;
		}
		if(scDao.addSelectedCourse(sc)){
			if(courseDao.updateSelectedNum(sc.getCourse_id(),1)){
				JOptionPane.showMessageDialog(this, "选课成功！!");
			}else{
				JOptionPane.showMessageDialog(this, "选课成功，课程信息更新失败!");
			}
		}else{
			JOptionPane.showMessageDialog(this, "选课失败!");
		}
		courseDao.closeDao();
		scDao.closeDao();
		initTable();
	}

	private void setStudentCombox(){
		StudentDao studentDao = new StudentDao();
		studentList = studentDao.getStudentList(new Student());
		studentDao.closeDao();
		for (Student student : studentList) {
			searchStudentComboBox.addItem(student);
			editSelectedStudentComboBox.addItem(student);
		}
		if("学生".equals(MainFrame.userType.getName())){
			Student user = (Student) MainFrame.userObject;
			for(int i = 0; i < searchStudentComboBox.getItemCount();i++){
				Student student = (Student) searchStudentComboBox.getItemAt(i);
				if(student.getStudent_id() == user.getStudent_id()){
					searchStudentComboBox.setSelectedIndex(i);
					editSelectedStudentComboBox.setSelectedIndex(i);
					break;
				}
			}
		}
	}
	private void setCourseCombox(){
		CourseDao courseDao = new CourseDao();
		courseList = courseDao.getCourseList(new Course());
		courseDao.closeDao();
		for (Course course : courseList) {
			searchCourseComboBox.addItem(course);
			editSelectedCourseComboBox.addItem(course);
		}
	}
	private void getSelectedCourse(StudentCourse selectedCourse){
		StudentCourseDao selectedCourseDao = new StudentCourseDao();
		List<StudentCourse> selectedCourseList = selectedCourseDao.getSelectedCourseList(selectedCourse);
				//selectedCourseDao.getSelectedCourseList(selectedCourse);
		DefaultTableModel dft = (DefaultTableModel) selectedCourseListTable.getModel();
		dft.setRowCount(0);
		for (StudentCourse sc : selectedCourseList) {
			Vector v = new Vector();
			v.add(sc.getId());
			v.add(getStudentNameById(sc.getStudent_id()));
			v.add(getCourseNameById(sc.getCourse_id()));
			dft.addRow(v);
		}
		selectedCourseDao.closeDao();
	}
	private void initTable(){
		Student student = (Student) searchStudentComboBox.getSelectedItem();
		StudentCourse sc = new StudentCourse();
		sc.setStudent_id(student.getStudent_id());
		getSelectedCourse(sc);
	}
	private String getStudentNameById(int id){
		for (int i = 0; i < studentList.size(); i++) {
			if(studentList.get(i).getStudent_id() == id)return studentList.get(i).getStudent_name();
		}
		return "";
	}
	private String getCourseNameById(int id){
		for (int i = 0; i < courseList.size(); i++) {
			if(id == courseList.get(i).getCourse_id())
				return courseList.get(i).getCourse_name();
		}
		return "";
	}
	private int getCourseIdByName(String name){
		for (int i = 0; i < courseList.size(); i++) {
			if(name.equals(courseList.get(i).getCourse_name()))
				return courseList.get(i).getCourse_id();
		}
		return 0;
	}
	private void setAuthority(){
		if("学生".equals(MainFrame.userType.getName())){
			searchStudentComboBox.setEnabled(false);
			editSelectedStudentComboBox.setEnabled(false);
		}
	}
}
