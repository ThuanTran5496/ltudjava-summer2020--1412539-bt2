package app.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import constants.Constants;

public class MainMenuView extends JFrame implements ActionListener, ListSelectionListener {
	private static final long serialVersionUID = 1L;
	private JLabel label;
	private JButton importNewClassBtn;
	private JButton importScheduleBtn;
	private JButton viewStudentInClassBtn;
	private JButton viewScheduleBtn;
	private JButton addStudentBtn;
	private JButton editStudentBtn;
	private JButton deleteStudentBtn;
	private JButton viewStudentBtn;
	private Constants constants;

	public MainMenuView() {
		this.label = new JLabel("Welcome to student management app");
//		create items
		this.importNewClassBtn = new JButton();
		this.importScheduleBtn = new JButton();
		this.viewStudentInClassBtn = new JButton();
		this.viewScheduleBtn = new JButton();
		this.addStudentBtn = new JButton();
		this.editStudentBtn = new JButton();
		this.deleteStudentBtn = new JButton();
		this.viewStudentBtn = new JButton();
		SpringLayout layout = new SpringLayout();
		JPanel panel = new JPanel();
		constants = new Constants();
		this.label.setBorder(new EmptyBorder(40, 30, 0, 0));
		panel.setSize(400, 350);
		panel.setLayout(layout);
//		add menu items
		panel.add(this.importNewClassBtn);
		panel.add(this.addStudentBtn);
		panel.add(this.importScheduleBtn);
		panel.add(this.viewStudentInClassBtn);
		panel.add(this.viewScheduleBtn);
		panel.add(this.editStudentBtn);
		panel.add(this.deleteStudentBtn);
		panel.add(this.viewStudentBtn);
		panel.add(this.label);
//		set name menu items
		this.importNewClassBtn.setText(constants.importTitle);
		this.addStudentBtn.setText(constants.addTitle);
		this.importScheduleBtn.setText(constants.importScheduleTitle);
		this.viewStudentInClassBtn.setText(constants.viewStudentClasses);
		this.viewScheduleBtn.setText(constants.viewSchedule);
		this.editStudentBtn.setText(constants.editTitle);
		this.deleteStudentBtn.setText(constants.deleteTitle);
		this.viewStudentBtn.setText(constants.viewTitle);
		this.setLayoutConstraint(layout, panel);
		this.add(panel);
		this.pack();
		this.setTitle("Main Menu");
		this.setSize(400, 380);
		this.setResizable(true);
	}

	public void actionPerformed(ActionEvent e) {
	}

	public void valueChanged(ListSelectionEvent e) {
	}

	public void importNewClassListener(ActionListener listener) {
		importNewClassBtn.addActionListener(listener);
	}

	public void importScheduleListener(ActionListener listener) {
		importScheduleBtn.addActionListener(listener);
	}
	public void viewStudentClassListener(ActionListener listener) {
		viewStudentInClassBtn.addActionListener(listener);
	}
	public void viewScheduleListener(ActionListener listener) {
		viewScheduleBtn.addActionListener(listener);
	}
	public void addAddNewListener(ActionListener listener) {
		addStudentBtn.addActionListener(listener);
	}

	public void addEditListener(ActionListener listener) {
		editStudentBtn.addActionListener(listener);
	}

	public void addDeleteListener(ActionListener listener) {
		deleteStudentBtn.addActionListener(listener);
	}

	public void addViewListener(ActionListener listener) {
		viewStudentBtn.addActionListener(listener);
	}

	public void setLayoutConstraint(SpringLayout layout, JPanel panel) {
		layout.putConstraint(SpringLayout.WEST, this.label, 20, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, this.importNewClassBtn, 100, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, this.importNewClassBtn, 20, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, this.addStudentBtn, 130, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, this.addStudentBtn, 20, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.WEST, this.importScheduleBtn, 20, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, this.importScheduleBtn, 160, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, this.viewStudentInClassBtn, 20, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, this.viewStudentInClassBtn, 190, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, this.viewScheduleBtn, 20, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, this.viewScheduleBtn, 220, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, this.editStudentBtn, 20, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, this.editStudentBtn, 250, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, this.deleteStudentBtn, 20, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, this.deleteStudentBtn, 280, SpringLayout.NORTH, panel);
		layout.putConstraint(SpringLayout.WEST, this.viewStudentBtn, 20, SpringLayout.WEST, panel);
		layout.putConstraint(SpringLayout.NORTH, this.viewStudentBtn, 310, SpringLayout.NORTH, panel);
	}
}
