package com.gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.bean.Course;
import com.bean.Teacher;
import com.dao.CourseDao;
import com.dao.TeacherDao;
import com.db.StringUtil;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class AddCourseFrame extends JInternalFrame {
	private JTextField courseNameTextField;
	private JTextField studentNumberTextField;
	private JComboBox teacherListComboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCourseFrame frame = new AddCourseFrame();
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
	public AddCourseFrame() {
		setClosable(true); //可关闭
		setIconifiable(true); //可放大缩小
		setTitle("\u6DFB\u52A0\u8BFE\u7A0B");
		setBounds(100, 100, 470, 324);
		
		JLabel label = new JLabel("\u8BFE\u7A0B\u540D\u79F0\uFF1A");
		label.setIcon(new ImageIcon(AddCourseFrame.class.getResource("/img/\u8BFE\u7A0B.png")));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		courseNameTextField = new JTextField();
		courseNameTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6388\u8BFE\u8001\u5E08\uFF1A");
		label_1.setIcon(new ImageIcon(AddCourseFrame.class.getResource("/img/\u6559\u5E08\u5217\u8868.png")));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		teacherListComboBox = new JComboBox();
		
		JLabel label_2 = new JLabel("\u5B66\u751F\u4EBA\u6570\uFF1A");
		label_2.setIcon(new ImageIcon(AddCourseFrame.class.getResource("/img/\u4EBA\u6570.png")));
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		studentNumberTextField = new JTextField();
		studentNumberTextField.setColumns(10);
		
		JButton addCourseButton = new JButton("\u6DFB\u52A0");
		addCourseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addCourseAct(ae);
			}
		});
		addCourseButton.setIcon(new ImageIcon(AddCourseFrame.class.getResource("/img/\u6559\u5E08\u6DFB\u52A0.png")));
		addCourseButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton resetButton = new JButton("\u91CD\u7F6E");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetValue(e);
			}
		});
		resetButton.setIcon(new ImageIcon(AddCourseFrame.class.getResource("/img/\u91CD\u7F6E.png")));
		resetButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(77)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(studentNumberTextField))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label_1)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(teacherListComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(label)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(courseNameTextField, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(102)
							.addComponent(addCourseButton)
							.addGap(62)
							.addComponent(resetButton)))
					.addContainerGap(159, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(courseNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(teacherListComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2)
						.addComponent(studentNumberTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(resetButton)
						.addComponent(addCourseButton))
					.addContainerGap(93, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		setTeacherCombox();
	}

	protected void resetValue(ActionEvent e) {
		// TODO Auto-generated method stub
		courseNameTextField.setText("");
		studentNumberTextField.setText("");
		teacherListComboBox.setSelectedIndex(0);
	}

	protected void addCourseAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		String couserName = courseNameTextField.getText().toString();
		Teacher selectedTeacher = (Teacher)teacherListComboBox.getSelectedItem();
		int studentMaxNum = 0;
		try {
			studentMaxNum = Integer.parseInt(studentNumberTextField.getText());
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "学生人数只能输入数字!");
			return;
		}
		if(StringUtil.isEmpty(couserName)){
			JOptionPane.showMessageDialog(this, "请输入课程名称!");
			return;
		}
		if(studentMaxNum <= 0){
			JOptionPane.showMessageDialog(this, "学生人数只能输入大于0的数字!");
			return;
		}
		Course course = new Course();
		course.setCourse_name(couserName);
		course.setMaxNumber(studentMaxNum);
		course.setTeacher_id(selectedTeacher.getTeacher_id());
		CourseDao courseDao = new CourseDao();
		if(courseDao.addCourse(course)){
			JOptionPane.showMessageDialog(this, "添加成功!");
		}else{
			JOptionPane.showMessageDialog(this, "添加失败!");
		}
		courseDao.closeDao();
		resetValue(ae);
	}
	private void setTeacherCombox(){
		TeacherDao teacherDao = new TeacherDao();
		List<Teacher> teacherList = teacherDao.getTeacherList(new Teacher());
		teacherDao.closeDao();
		for (Teacher teacher : teacherList) {
			teacherListComboBox.addItem(teacher);
		}
	}
}
