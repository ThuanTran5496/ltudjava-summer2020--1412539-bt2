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
    
    private JTextField mssvInput;
    private JTextField nameInput;
    private JTextField sexInput;
    private JTextField cmndInput;
    
    private String [] columnNames = new String [] {"MSSV", "Name", "Sex", "CMND"};
    
    public StudentView(int type) {
        init(type);
    }

    private void init(int type) {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        jScrollPaneStudentTable = new JScrollPane();
        studentTable = new JTable();
        mssvLabel = new JLabel("MSSV");
        nameLabel = new JLabel("Name");
        ageLabel = new JLabel("Gender");
        cmndLabel = new JLabel("CMND");
        mssvInput = new JTextField(6);
        mssvInput.setEditable(false);
        nameInput = new JTextField(15);
        sexInput = new JTextField(6);
        cmndInput = new JTextField(6);
        
        studentTable.setModel(new DefaultTableModel((Object[][])(new Object [][] {}), columnNames));
        jScrollPaneStudentTable.setViewportView(studentTable);
        jScrollPaneStudentTable.setPreferredSize(new Dimension (480, 300));
        SpringLayout layout = new SpringLayout();
        JPanel panel = new JPanel();
        panel.setSize(700, 400);
        panel.setLayout(layout);
        // view  
        if (type == 1) {
        	panel.add(jScrollPaneStudentTable);
        	layout.putConstraint(SpringLayout.WEST, jScrollPaneStudentTable, 300, SpringLayout.WEST, panel);
            layout.putConstraint(SpringLayout.NORTH, jScrollPaneStudentTable, 10, SpringLayout.NORTH, panel);
        }
        
        // add or edit
        else if (type == 2) {
        	panel.add(mssvLabel);
            panel.add(nameLabel);
            panel.add(ageLabel);
            panel.add(cmndLabel);
            
            panel.add(mssvInput);
            panel.add(nameInput);
            panel.add(sexInput);
            panel.add(cmndInput);

            layout.putConstraint(SpringLayout.WEST, mssvLabel, 10, SpringLayout.WEST, panel);
            layout.putConstraint(SpringLayout.NORTH, mssvLabel, 10, SpringLayout.NORTH, panel);
            layout.putConstraint(SpringLayout.WEST, nameLabel, 10, SpringLayout.WEST, panel);
            layout.putConstraint(SpringLayout.NORTH, nameLabel, 40, SpringLayout.NORTH, panel);
            layout.putConstraint(SpringLayout.WEST, ageLabel, 10, SpringLayout.WEST, panel);
            layout.putConstraint(SpringLayout.NORTH, ageLabel, 70, SpringLayout.NORTH, panel);
            layout.putConstraint(SpringLayout.WEST, cmndLabel, 10, SpringLayout.WEST, panel);
            layout.putConstraint(SpringLayout.NORTH, cmndLabel, 100, SpringLayout.NORTH, panel);
            
            layout.putConstraint(SpringLayout.WEST, mssvInput, 100, SpringLayout.WEST, panel);
            layout.putConstraint(SpringLayout.NORTH, mssvInput, 10, SpringLayout.NORTH, panel);
            layout.putConstraint(SpringLayout.WEST, nameInput, 100, SpringLayout.WEST, panel);
            layout.putConstraint(SpringLayout.NORTH, nameInput, 40, SpringLayout.NORTH, panel);
            layout.putConstraint(SpringLayout.WEST, sexInput, 100, SpringLayout.WEST, panel);
            layout.putConstraint(SpringLayout.NORTH, sexInput, 70, SpringLayout.NORTH, panel);
            layout.putConstraint(SpringLayout.WEST, cmndInput, 100, SpringLayout.WEST, panel);
            layout.putConstraint(SpringLayout.NORTH, cmndInput, 100, SpringLayout.NORTH, panel);
        } else if (type == 3 ){
        	panel.add(mssvLabel);
        	panel.add(mssvInput);
        	layout.putConstraint(SpringLayout.WEST, mssvLabel, 10, SpringLayout.WEST, panel);
            layout.putConstraint(SpringLayout.NORTH, mssvLabel, 10, SpringLayout.NORTH, panel);
            layout.putConstraint(SpringLayout.WEST, mssvInput, 100, SpringLayout.WEST, panel);
            layout.putConstraint(SpringLayout.NORTH, mssvInput, 10, SpringLayout.NORTH, panel);
        }

        this.add(panel);
        this.pack();
        this.setTitle("Student Information");
        this.setSize(800, 420);
    }
    
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    
    public void showListStudents(List<Student> list) {
        int size = list.size();
        Object [][] students = new Object[size][5];
        for (int i = 0; i < size; i++) {
            students[i][0] = list.get(i).getMSSV();
            students[i][1] = list.get(i).getName();
            students[i][2] = list.get(i).getSex();
            students[i][3] = list.get(i).getCMND();
        }
        studentTable.setModel(new DefaultTableModel(students, columnNames));
    }

   
    public void showStudent(Student student) {
    	mssvInput.setText(student.getMSSV() + " ");
        nameInput.setText(student.getName() + " ");
        sexInput.setText(student.getSex() + " ");
        cmndInput.setText(student.getCMND());
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
            return student;
        } catch (Exception e) {
            showMessage(e.getMessage());
        }
        return null;
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

}
