package app.views;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import app.views.GoBack;
import app.entities.Classes;
import app.entities.Student;
import constants.Constants;

public class StudentView extends JFrame implements ActionListener, ListSelectionListener {
    private JScrollPane jScrollPaneStudentTable;
    private JTable studentTable;
	private Constants constants;
    private JLabel mssvLabel;
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel cmndLabel;
    private JLabel classLabel;
    private JTextField mssvInput;
    private JTextField nameInput;
    private JTextField sexInput;
    private JTextField cmndInput;
    private JTextField classInput;
    private JButton backBtn;
    private JButton finishBtn;

    private String [] columnNames = new String [] {"MSSV", "Name", "Sex", "CMND", "Class"};
    
    public StudentView(int type) {
        init(type);
    }

    private void init(int type) {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        constants = new Constants();
        backBtn = new JButton();
        finishBtn = new JButton();
        jScrollPaneStudentTable = new JScrollPane();
        studentTable = new JTable();
        mssvLabel = new JLabel("MSSV");
        nameLabel = new JLabel("Name");
        ageLabel = new JLabel("Gender");
        cmndLabel = new JLabel("CMND");
        classLabel = new JLabel("Class");

        mssvInput = new JTextField(14);
        nameInput = new JTextField(14);
        sexInput = new JTextField(14);
        cmndInput = new JTextField(14);
        classInput = new JTextField(14);

        backBtn.setText("< Back");
        finishBtn.setText("Finish");
        
        studentTable.setModel(new DefaultTableModel((Object[][])(new Object [][] {}), columnNames));
        jScrollPaneStudentTable.setViewportView(studentTable);
        jScrollPaneStudentTable.setPreferredSize(new Dimension (480, 300));
        JPanel panel = new JPanel();
        SpringLayout layout = new SpringLayout();
        panel.add(backBtn);
        panel.setSize(700, 400);
        panel.setLayout(layout);
        // import  
        if (type == 1) {
        	this.setTitle("Import new class from csv");
        }
        
        // add
        else if (type == 2) {
        	this.setTitle("Add a student");
        	panel.add(mssvLabel);
            panel.add(nameLabel);
            panel.add(ageLabel);
            panel.add(cmndLabel);
            panel.add(classLabel);
            
            panel.add(mssvInput);
            panel.add(nameInput);
            panel.add(sexInput);
            panel.add(cmndInput);
            panel.add(classInput);
            panel.add(finishBtn);

            layout.putConstraint(SpringLayout.WEST, mssvLabel, 10, SpringLayout.WEST, panel);
            layout.putConstraint(SpringLayout.NORTH, mssvLabel, 40, SpringLayout.NORTH, panel);
            layout.putConstraint(SpringLayout.WEST, nameLabel, 10, SpringLayout.WEST, panel);
            layout.putConstraint(SpringLayout.NORTH, nameLabel, 70, SpringLayout.NORTH, panel);
            layout.putConstraint(SpringLayout.WEST, ageLabel, 10, SpringLayout.WEST, panel);
            layout.putConstraint(SpringLayout.NORTH, ageLabel, 100, SpringLayout.NORTH, panel);
            layout.putConstraint(SpringLayout.WEST, cmndLabel, 10, SpringLayout.WEST, panel);
            layout.putConstraint(SpringLayout.NORTH, cmndLabel, 130, SpringLayout.NORTH, panel);
            layout.putConstraint(SpringLayout.WEST, classLabel, 10, SpringLayout.WEST, panel);
            layout.putConstraint(SpringLayout.NORTH, classLabel, 160, SpringLayout.NORTH, panel);
            
            layout.putConstraint(SpringLayout.WEST, mssvInput, 100, SpringLayout.WEST, panel);
            layout.putConstraint(SpringLayout.NORTH, mssvInput, 40, SpringLayout.NORTH, panel);
            layout.putConstraint(SpringLayout.WEST, nameInput, 100, SpringLayout.WEST, panel);
            layout.putConstraint(SpringLayout.NORTH, nameInput, 70, SpringLayout.NORTH, panel);
            layout.putConstraint(SpringLayout.WEST, sexInput, 100, SpringLayout.WEST, panel);
            layout.putConstraint(SpringLayout.NORTH, sexInput, 100, SpringLayout.NORTH, panel);
            layout.putConstraint(SpringLayout.WEST, cmndInput, 100, SpringLayout.WEST, panel);
            layout.putConstraint(SpringLayout.NORTH, cmndInput, 130, SpringLayout.NORTH, panel);
            layout.putConstraint(SpringLayout.WEST, classInput, 100, SpringLayout.WEST, panel);
            layout.putConstraint(SpringLayout.NORTH, classInput, 160, SpringLayout.NORTH, panel);
            layout.putConstraint(SpringLayout.WEST, finishBtn, 100, SpringLayout.WEST, panel);
            layout.putConstraint(SpringLayout.NORTH, finishBtn, 190, SpringLayout.NORTH, panel);
            
        } else if (type == 3 ) {
        	this.setTitle("Import new schedule from csv");
        } else if (type == 4 ){
        	this.setTitle("View student in class");
        	panel.add(classLabel);
        	panel.add(classInput);
        	panel.add(finishBtn);
        	layout.putConstraint(SpringLayout.WEST, classLabel, 10, SpringLayout.WEST, panel);
            layout.putConstraint(SpringLayout.NORTH, classLabel, 40, SpringLayout.NORTH, panel);
            layout.putConstraint(SpringLayout.WEST, classInput, 100, SpringLayout.WEST, panel);
            layout.putConstraint(SpringLayout.NORTH, classInput, 40, SpringLayout.NORTH, panel);
            layout.putConstraint(SpringLayout.WEST, finishBtn, 100, SpringLayout.WEST, panel);
            layout.putConstraint(SpringLayout.NORTH, finishBtn, 70, SpringLayout.NORTH, panel);
        }
        
        this.add(panel);
        this.pack();
        this.setSize(600, 350);
    }
    
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    
    public void showListStudents(List<Student> list) {
        Object [][] students = new Object[list.size()][5];
        for (int i = 0; i <= list.size() - 1; i++) {
            students[i][0] = list.get(i).getMSSV();
            students[i][1] = list.get(i).getName();
            students[i][2] = list.get(i).getSex();
            students[i][3] = list.get(i).getCMND();
            students[i][4] = list.get(i).getClasses();
        }
        studentTable.setModel(new DefaultTableModel(students, columnNames));
    }

    public void showStudent(Student student) {
    	mssvInput.setText(student.getMSSV() + " ");
        nameInput.setText(student.getName() + " ");
        sexInput.setText(student.getSex() + " ");
        cmndInput.setText(student.getCMND() + " ");
        classInput.setText(student.getClasses().getName());
    }
    
    public int getMSSVFromInput() {
    	if (validateMSSV() == true) {
    		return Integer.parseInt(mssvInput.getText());
    	} else {
    		 return -1;
    	}
    }
    
    public Student getStudentInfo() {
        if (!validateName() || !validateSex() || !validateCMND()) {
            return null;
        }
        try {
            Student student = new Student();
            if (mssvInput.getText() != null && !(mssvInput.getText().contentEquals(""))) {
                student.setMSSV(Integer.parseInt(mssvInput.getText()));
            }
            student.setName(nameInput.getText());
            student.setSex(sexInput.getText());
            student.setClasses(new Classes(classInput.getText(), classInput.getText()));
            student.setCMND(cmndInput.getText());
            return student;
        } catch (Exception e) {
            showMessage(e.getMessage());
        }
        return null;
    }
    
    private boolean validateMSSV() {
        if (mssvInput.getText() == null || (mssvInput.getText().trim().equals(""))) {
        	mssvInput.requestFocus();
            showMessage(constants.EmptyString);
            return false;
        } else {
        	try {
       	     	int result = Integer.parseInt(mssvInput.getText());
        	}
        	catch (NumberFormatException e) {
        		showMessage(constants.NaN);
       	     	System.out.print("input mssv not a number");
        	}
           
        }
        return true;
    }
    
    private boolean validateName() {
        String name = nameInput.getText();
        if (name == null || (name.trim().equals(""))) {
            nameInput.requestFocus();
            showMessage(constants.EmptyString);
            return false;
        }
        return true;
    }
    
    private boolean validateCMND() {
        if (cmndInput.getText() == null || (cmndInput.getText().trim().equals(""))) {
        	cmndInput.requestFocus();
            showMessage(constants.EmptyString);
            return false;
        }
        return true;
    }
    
    private boolean validateSex() {
        if (sexInput.getText() == null || sexInput.getText().trim().equals("")) {
        	sexInput.requestFocus();
            showMessage(constants.EmptyString);
            return false;
        }
        return true;
    }
    
    public void actionPerformed(ActionEvent e) {
    }
    
    public void valueChanged(ListSelectionEvent e) {
    }
    public void addBackListener(ActionListener listener) {
        backBtn.addActionListener(listener);
    }
    public void addFinishListener(ActionListener listener) {
        finishBtn.addActionListener(listener);
    }
}
