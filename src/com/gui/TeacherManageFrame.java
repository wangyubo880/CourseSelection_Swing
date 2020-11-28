package com.gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.bean.Teacher;
import com.dao.TeacherDao;
import com.db.StringUtil;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

public class TeacherManageFrame extends JInternalFrame {
	private JTable teacherListTable;
	private JTextField searchTeacherNameTextField;
	private JTextField editTeacherNameTextField;
	private JTextField editTeacherTitleTextField;
	private JPasswordField editTeacherPasswordTextField;
	private JButton searchTeacherButton;
	private JButton editTeacherSubmitButton;
	private JButton deleteTeacherButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TeacherManageFrame frame = new TeacherManageFrame();
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
	public TeacherManageFrame() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u6559\u5E08\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 953, 624);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JLabel label = new JLabel("\u6559\u5E08\u59D3\u540D\uFF1A");
		label.setIcon(new ImageIcon(TeacherManageFrame.class.getResource("/img/\u6559\u5E08.png")));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		searchTeacherNameTextField = new JTextField();
		searchTeacherNameTextField.setColumns(10);
		
		searchTeacherButton = new JButton("\u67E5\u8BE2");
		searchTeacherButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				searchTeacher(ae);
			}
		});
		searchTeacherButton.setIcon(new ImageIcon(TeacherManageFrame.class.getResource("/img/\u67E5\u8BE2.png")));
		searchTeacherButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\u6559\u5E08\u4FE1\u606F\u4FEE\u6539", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(212)
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(searchTeacherNameTextField, GroupLayout.PREFERRED_SIZE, 227, GroupLayout.PREFERRED_SIZE)
							.addGap(50)
							.addComponent(searchTeacherButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(117)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, 686, GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 685, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(134, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(51)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(searchTeacherNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchTeacherButton))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(38, Short.MAX_VALUE))
		);
		
		JLabel label_1 = new JLabel("\u6559\u5E08\u59D3\u540D\uFF1A");
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editTeacherNameTextField = new JTextField();
		editTeacherNameTextField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u6559\u5E08\u804C\u79F0\uFF1A");
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editTeacherTitleTextField = new JTextField();
		editTeacherTitleTextField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u767B\u5F55\u5BC6\u7801\uFF1A");
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		editTeacherPasswordTextField = new JPasswordField();
		editTeacherPasswordTextField.setColumns(10);
		
		editTeacherSubmitButton = new JButton("\u4FEE\u6539");
		editTeacherSubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				editTeacherAct(ae);
			}
		});
		editTeacherSubmitButton.setIcon(new ImageIcon(TeacherManageFrame.class.getResource("/img/\u786E\u8BA4\u4FEE\u6539.png")));
		editTeacherSubmitButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		deleteTeacherButton = new JButton("\u5220\u9664");
		deleteTeacherButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				deleteTeacher(ae);
			}
		});
		deleteTeacherButton.setIcon(new ImageIcon(TeacherManageFrame.class.getResource("/img/\u5220\u9664 .png")));
		deleteTeacherButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editTeacherTitleTextField))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editTeacherNameTextField, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)))
					.addGap(81)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(label_3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(editTeacherPasswordTextField, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGap(11)
							.addComponent(editTeacherSubmitButton)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(deleteTeacherButton)))
					.addContainerGap(117, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(editTeacherNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(editTeacherPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(label_2)
							.addComponent(editTeacherTitleTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(deleteTeacherButton)
							.addComponent(editTeacherSubmitButton)))
					.addContainerGap(30, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		teacherListTable = new JTable();
		teacherListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedTableRow(arg0);
			}
		});
		teacherListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u6559\u5E08ID", "\u6559\u5E08\u59D3\u540D", "\u6559\u5E08\u804C\u79F0", "\u767B\u5F55\u5BC6\u7801"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(teacherListTable);
		getContentPane().setLayout(groupLayout);
		setTable(new Teacher());
		setAuthority();

	}
	protected void editTeacherAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		int row = teacherListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请选择要修改的数据！");
			return;
		}
		String teacherName = editTeacherNameTextField.getText().toString();
		String teacherTitle = editTeacherTitleTextField.getText().toString();
		String teacherPassword = editTeacherPasswordTextField.getText().toString();
		if(StringUtil.isEmpty(teacherName)){
			JOptionPane.showMessageDialog(this, "教师姓名必须填写！");
			return;
		}
		if(StringUtil.isEmpty(teacherTitle)){
			JOptionPane.showMessageDialog(this, "教师职称必须填写！");
			return;
		}
		if(StringUtil.isEmpty(teacherPassword)){
			JOptionPane.showMessageDialog(this, "教师登录密码必须填写！");
			return;
		}
		Teacher teacher = new Teacher();
		teacher.setTeacher_id(Integer.parseInt(teacherListTable.getValueAt(row, 0).toString()));
		teacher.setTeacher_name(teacherName);
		teacher.setTeacher_title(teacherTitle);
		teacher.setTeacher_password(teacherPassword);
		TeacherDao teacherDao = new TeacherDao();
		if(teacherDao.update(teacher)){
			JOptionPane.showMessageDialog(this, "修改成功！");
		}else{
			JOptionPane.showMessageDialog(this, "修改失败！");
		}
		teacherDao.closeDao();
		setTable(new Teacher());
	}

	protected void searchTeacher(ActionEvent ae) {
		// TODO Auto-generated method stub
		String teacherNameString = searchTeacherNameTextField.getText().toString();
		Teacher teacher = new Teacher();
		teacher.setTeacher_name(teacherNameString);
		setTable(teacher);
	}

	protected void deleteTeacher(ActionEvent ae) {
		// TODO Auto-generated method stub
		int row = teacherListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请选择要删除的数据！");
			return;
		}
		if(JOptionPane.showConfirmDialog(this, "确定要删除么？") != JOptionPane.OK_OPTION)
			return;
		int id = Integer.parseInt(teacherListTable.getValueAt(row, 0).toString());
		TeacherDao teacherDao = new TeacherDao();
		if(teacherDao.delete(id)){
			JOptionPane.showMessageDialog(this, "删除成功！");
		}else{
			JOptionPane.showMessageDialog(this, "删除失败！");
		}
		teacherDao.closeDao();
		setTable(new Teacher());
		
	}

	private void setTable(Teacher teacher){
		if("教师".equals(MainFrame.userType.getName())){
			Teacher tLogined = (Teacher) MainFrame.userObject;
			teacher.setTeacher_name(tLogined.getTeacher_name());
			searchTeacherNameTextField.setText(teacher.getTeacher_name());
		}
		DefaultTableModel dft = (DefaultTableModel) teacherListTable.getModel();
		dft.setRowCount(0);
		TeacherDao teacherDao = new TeacherDao();
		List<Teacher> teacherList = teacherDao.getTeacherList(teacher);
		for (Teacher t : teacherList) {
			Vector v = new Vector();
			v.add(t.getTeacher_id());
			v.add(t.getTeacher_name());
			v.add(t.getTeacher_title());
			v.add(t.getTeacher_password());
			dft.addRow(v);
		}
		teacherDao.closeDao();
	}
	//点击显示选中信息
	protected void selectedTableRow(MouseEvent me) {
		// TODO Auto-generated method stub
		DefaultTableModel dft = (DefaultTableModel) teacherListTable.getModel();
		editTeacherNameTextField.setText(dft.getValueAt(teacherListTable.getSelectedRow(), 1).toString());
		editTeacherTitleTextField.setText(dft.getValueAt(teacherListTable.getSelectedRow(), 2).toString());
		editTeacherPasswordTextField.setText(dft.getValueAt(teacherListTable.getSelectedRow(), 3).toString());
	}
	private void setAuthority(){
		if("教师".equals(MainFrame.userType.getName())){
			deleteTeacherButton.setEnabled(false);
			searchTeacherNameTextField.setEditable(false);
		}
	}
}
