package com.gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.bean.Student;
import com.dao.StudentDao;
import com.db.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class StudentManageFrames extends JInternalFrame {
	private JTextField searchStudentNameTextField;
	private JTextField searchStudentNoTextField;
	private JTable studentListTable;
	private JTextField editStudentNameTextField;
	private JTextField editStudentPasswordTextField;
	private JButton deleteStudentButton;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentManageFrames frame = new StudentManageFrames();
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
	public StudentManageFrames() {
		setClosable(true); //可关闭
		setIconifiable(true); //可放大缩小
		setTitle("\u5B66\u751F\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 914, 630);
		
		JLabel label = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		label.setIcon(new ImageIcon(StudentManageFrames.class.getResource("/img/\u7528\u6237\u540D2.png")));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		searchStudentNameTextField = new JTextField();
		searchStudentNameTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5B66\u53F7\uFF1A");
		label_1.setIcon(new ImageIcon(StudentManageFrames.class.getResource("/img/\u5B66\u53F7.png")));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		searchStudentNoTextField = new JTextField();
		searchStudentNoTextField.setColumns(10);
		
		JButton searchButton = new JButton("");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				searchStudent(ae);
			}
		});
		searchButton.setIcon(new ImageIcon(StudentManageFrames.class.getResource("/img/\u67E5\u8BE2.png")));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label_2 = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		label_2.setIcon(new ImageIcon(StudentManageFrames.class.getResource("/img/\u7528\u6237\u540D2.png")));
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editStudentNameTextField = new JTextField();
		editStudentNameTextField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		label_3.setIcon(new ImageIcon(StudentManageFrames.class.getResource("/img/\u7BA1\u7406\u5458\u4FEE\u6539\u5BC6\u7801.png")));
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editStudentPasswordTextField = new JTextField();
		editStudentPasswordTextField.setColumns(10);
		
		JButton submitEditButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		submitEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitEditMsg(ae);
			}
		});
		submitEditButton.setIcon(new ImageIcon(StudentManageFrames.class.getResource("/img/\u786E\u8BA4.png")));
		submitEditButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		deleteStudentButton = new JButton("\u5220\u9664\u5B66\u751F");
		deleteStudentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				deleteStudent(ae);
			}
		});
		deleteStudentButton.setIcon(new ImageIcon(StudentManageFrames.class.getResource("/img/\u5220\u9664 .png")));
		deleteStudentButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(98)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(41)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchStudentNameTextField, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
							.addGap(66)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchStudentNoTextField, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(searchButton))
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 701, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(92)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(label_3)
								.addComponent(label_2))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(editStudentPasswordTextField)
								.addComponent(editStudentNameTextField, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
							.addGap(109)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(deleteStudentButton)
								.addComponent(submitEditButton))))
					.addContainerGap(99, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(56, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(label)
							.addComponent(searchStudentNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_1)
							.addComponent(searchStudentNoTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(searchButton))
					.addGap(26)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 337, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(editStudentNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(submitEditButton))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_3)
						.addComponent(editStudentPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(deleteStudentButton))
					.addGap(51))
		);
		
		studentListTable = new JTable();
		studentListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedTableRow(arg0);
			}
		});
		studentListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u5E8F\u53F7", "\u5B66\u751F\u5B66\u53F7", "\u5B66\u751F\u59D3\u540D", "\u767B\u5F55\u5BC6\u7801"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(studentListTable);
		getContentPane().setLayout(groupLayout);
		setTable(new Student());
		setAuthority();

	}
	protected void submitEditMsg(ActionEvent ae) {
		// TODO Auto-generated method stub
		int row = studentListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请选中要修改的数据！");
			return;
		}
		String studentName = editStudentNameTextField.getText().toString();
		String studentPassword = editStudentPasswordTextField.getText().toString();
		if(StringUtil.isEmpty(studentName)){
			JOptionPane.showMessageDialog(this, "请填写学生姓名！");
			return;
		}
		if(StringUtil.isEmpty(studentPassword)){
			JOptionPane.showMessageDialog(this, "请填写密码！");
			return;
		}
		
		Student student = new Student();
		student.setStudent_name(studentName);
		student.setStudent_password(studentPassword);
		student.setStudent_id(Integer.parseInt(studentListTable.getValueAt(row, 0).toString()));
		StudentDao studentDao = new StudentDao();
		if(studentDao.update(student)){
			JOptionPane.showMessageDialog(this, "更新成功！");
		}else{
			JOptionPane.showMessageDialog(this, "更新失败！");
		}
		studentDao.closeDao();
		setTable(new Student());
		
	}

	protected void selectedTableRow(MouseEvent arg0) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) studentListTable.getModel();
		editStudentNameTextField.setText(dft.getValueAt(studentListTable.getSelectedRow(), 2).toString());
		editStudentPasswordTextField.setText(dft.getValueAt(studentListTable.getSelectedRow(), 3).toString());
	
	}

	protected void deleteStudent(ActionEvent ae) {
		// TODO Auto-generated method stub
		int row = studentListTable.getSelectedRow();
		if(row == -1){   //没选中
			JOptionPane.showMessageDialog(this, "请选中要删除的数据！");
			return;
		}
		if(JOptionPane.showConfirmDialog(this, "您确定删除么？") != JOptionPane.OK_OPTION){
			return;
		}
		StudentDao studentDao = new StudentDao();
		if(studentDao.delete(Integer.parseInt(studentListTable.getValueAt(row, 0).toString()))){
			JOptionPane.showMessageDialog(this, "删除成功！");
		}else{
			JOptionPane.showMessageDialog(this, "删除失败！");
		}
		studentDao.closeDao();
		setTable(new Student());
	}

	protected void searchStudent(ActionEvent ae) {
		// TODO Auto-generated method stub
		Student student = new Student();
		student.setStudent_name(searchStudentNameTextField.getText().toString());
		student.setStudent_number(searchStudentNoTextField.getText().toString());
		//StudentClass sc = (StudentClass)searchStudentComboBox.getSelectedItem();
		//student.setClassId(sc.getId());
		setTable(student);
		
	}

	private void setTable(Student student){
		if("学生".equals(MainFrame.userType.getName())){
			Student s = (Student)MainFrame.userObject;
			student.setStudent_name(s.getStudent_name());  //学生只能查询到本人信息
		}
		DefaultTableModel dft = (DefaultTableModel) studentListTable.getModel();
		dft.setRowCount(0);
		StudentDao studentDao = new StudentDao();
		List<Student> studentList = studentDao.getStudentList(student);
		for (Student s : studentList) {
			Vector v = new Vector();
			v.add(s.getStudent_id());
			v.add(s.getStudent_number());
			v.add(s.getStudent_name());
			v.add(s.getStudent_password());
			
			dft.addRow(v);
		}
		studentDao.closeDao();
	}
	private void setAuthority(){
		if("学生".equals(MainFrame.userType.getName())){
			Student s = (Student)MainFrame.userObject;
			searchStudentNameTextField.setText(s.getStudent_name());
			System.out.println(s.getStudent_name());
			searchStudentNameTextField.setEnabled(false);
			searchStudentNoTextField.setText(s.getStudent_number());
			System.out.println(s.getStudent_number());
			searchStudentNoTextField.setEnabled(false);
			deleteStudentButton.setEnabled(false);
			}
	}
}
