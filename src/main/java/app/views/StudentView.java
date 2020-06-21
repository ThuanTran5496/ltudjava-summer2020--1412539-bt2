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

public class StudentView extends JFrame implements ActionListener, ListSelectionListener {
    private static final long serialVersionUID = 1L;
    private JButton addStudentBtn;
    private JButton editStudentBtn;
    private JButton deleteStudentBtn;
    private JButton clearBtn;
    private JButton sortStudentNameBtn;
    private JScrollPane jScrollPaneStudentTable;
    private JTable studentTable;
    
    private JLabel mssvLabel;
    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel cmndLabel;
    
    private JTextField mssvInput;
    private JTextField nameInput;
    private JTextField sexInput;
    private JTextField cmndInput;
    
    // định nghĩa các cột của bảng student
    private String [] columnNames = new String [] {
            "MSSV", "Name", "Sex", "CMND"};
    // định nghĩa dữ liệu mặc định của bẳng student là rỗng
    private Object data = new Object [][] {};
    
    public StudentView() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addStudentBtn = new JButton("Add");
        editStudentBtn = new JButton("Edit");
        deleteStudentBtn = new JButton("Delete");
        clearBtn = new JButton("Clear");
        sortStudentNameBtn = new JButton("Sort By Name");
        // khởi tạo bảng student
        jScrollPaneStudentTable = new JScrollPane();
        studentTable = new JTable();
        
        // khởi tạo các label
        mssvLabel = new JLabel("MSSV");
        nameLabel = new JLabel("Name");
        ageLabel = new JLabel("Sex");
        cmndLabel = new JLabel("CMND");
        
        // khởi tạo các trường nhập dữ liệu cho student
        mssvInput = new JTextField(6);
        mssvInput.setEditable(false);
        nameInput = new JTextField(15);
        sexInput = new JTextField(6);
        cmndInput = new JTextField();
        
        // cài đặt các cột và data cho bảng student
        studentTable.setModel(new DefaultTableModel((Object[][]) data, columnNames));
        jScrollPaneStudentTable.setViewportView(studentTable);
        jScrollPaneStudentTable.setPreferredSize(new Dimension (480, 300));
        
         // tạo spring layout
        SpringLayout layout = new SpringLayout();
        // tạo đối tượng panel để chứa các thành phần của màn hình quản lý Student
        JPanel panel = new JPanel();
        panel.setSize(800, 420);
        panel.setLayout(layout);
        panel.add(jScrollPaneStudentTable);
        
        panel.add(addStudentBtn);
        panel.add(editStudentBtn);
        panel.add(deleteStudentBtn);
        panel.add(clearBtn);
        panel.add(sortStudentNameBtn);
        
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
        
        layout.putConstraint(SpringLayout.WEST, jScrollPaneStudentTable, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneStudentTable, 10, SpringLayout.NORTH, panel);
        
        layout.putConstraint(SpringLayout.WEST, addStudentBtn, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addStudentBtn, 240, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, editStudentBtn, 60, SpringLayout.WEST, addStudentBtn);
        layout.putConstraint(SpringLayout.NORTH, editStudentBtn, 240, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deleteStudentBtn, 60, SpringLayout.WEST, editStudentBtn);
        
        layout.putConstraint(SpringLayout.NORTH, clearBtn, 240, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, clearBtn, 80, SpringLayout.WEST, deleteStudentBtn);
        
        layout.putConstraint(SpringLayout.NORTH, deleteStudentBtn, 240, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.NORTH, sortStudentNameBtn, 330, SpringLayout.NORTH, panel);
        
        this.add(panel);
        this.pack();
        this.setTitle("Student Information");
        this.setSize(800, 420);
        editStudentBtn.setEnabled(false);
        deleteStudentBtn.setEnabled(false);
        // enable Add button
        addStudentBtn.setEnabled(true);
    }
    
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    
    public void showListStudents(List<Student> list) {
        int size = list.size();
        // với bảng studentTable có 5 cột, 
        // khởi tạo mảng 2 chiều students, trong đó:
        // số hàng: là kích thước của list student 
        // số cột: là 5
        Object [][] students = new Object[size][5];
        for (int i = 0; i < size; i++) {
            students[i][0] = list.get(i).getMSSV();
            students[i][1] = list.get(i).getName();
            students[i][2] = list.get(i).getSex();
            students[i][3] = list.get(i).getCMND();
        }
        studentTable.setModel(new DefaultTableModel(students, columnNames));
    }
    
    /**
     * điền thông tin của hàng được chọn từ bảng student 
     * vào các trường tương ứng của student.
     */
    public void fillStudentFromSelectedRow() {
        // lấy chỉ số của hàng được chọn 
        int row = studentTable.getSelectedRow();
        if (row >= 0) {
            mssvInput.setText(studentTable.getModel().getValueAt(row, 0).toString());
            nameInput.setText(studentTable.getModel().getValueAt(row, 1).toString());
            sexInput.setText(studentTable.getModel().getValueAt(row, 2).toString());
            cmndInput.setText(studentTable.getModel().getValueAt(row, 3).toString());
            
            editStudentBtn.setEnabled(true);
            deleteStudentBtn.setEnabled(true);
            // disable Add button
            addStudentBtn.setEnabled(false);
        }
    }

    public void clearStudentInfo() {
    	mssvInput.setText("");
        nameInput.setText("");
        sexInput.setText("");
        cmndInput.setText("");
        // disable Edit and Delete buttons
        editStudentBtn.setEnabled(false);
        deleteStudentBtn.setEnabled(false);
        // enable Add button
        addStudentBtn.setEnabled(true);
    }
    public void showStudent(Student student) {
    	mssvInput.setText("" + student.getMSSV());
        nameInput.setText(student.getName());
        sexInput.setText("" + student.getSex());
        cmndInput.setText(student.getCMND());
        // enable Edit and Delete buttons
        editStudentBtn.setEnabled(true);
        deleteStudentBtn.setEnabled(true);
        // disable Add button
        addStudentBtn.setEnabled(false);
    }
    
    public Student getStudentInfo() {
        if (!validateName() || !validateSex() || !validateCMND()) {
            return null;
        }
        try {
            Student student = new Student();
            if (mssvInput.getText() != null && !"".equals(mssvInput.getText())) {
                student.setMSSV(Integer.parseInt(mssvInput.getText()));
            }
            student.setName(nameInput.getText().trim());
            student.setSex(sexInput.getText().trim());
            student.setCMND(cmndInput.getText().trim());
            return student;
        } catch (Exception e) {
            showMessage(e.getMessage());
        }
        return null;
    }
    
    private boolean validateName() {
        String name = nameInput.getText();
        if (name == null || "".equals(name.trim())) {
            nameInput.requestFocus();
            showMessage("Name không được trống.");
            return false;
        }
        return true;
    }
    
    private boolean validateCMND() {
        String cmnd = cmndInput.getText();
        if (cmnd == null || "".equals(cmnd.trim())) {
        	cmndInput.requestFocus();
            showMessage("CMND không được trống.");
            return false;
        }
        return true;
    }
    
    private boolean validateSex() {
        if (sexInput.getText() == null || sexInput.getText().trim().equals("")) {
        	sexInput.requestFocus();
            showMessage("Sex không được trống.");
            return false;
        }
        return true;
    }
    
    public void actionPerformed(ActionEvent e) {
    }
    
    public void valueChanged(ListSelectionEvent e) {
    }
    
    public void addAddStudentListener(ActionListener listener) {
        addStudentBtn.addActionListener(listener);
    }
    
    public void addEdiStudentListener(ActionListener listener) {
        editStudentBtn.addActionListener(listener);
    }
    
    public void addDeleteStudentListener(ActionListener listener) {
        deleteStudentBtn.addActionListener(listener);
    }
    
    public void addClearListener(ActionListener listener) {
        clearBtn.addActionListener(listener);
    }
    
    public void addSortStudentNameListener(ActionListener listener) {
        sortStudentNameBtn.addActionListener(listener);
    }
    
    public void addListStudentSelectionListener(ListSelectionListener listener) {
        studentTable.getSelectionModel().addListSelectionListener(listener);
    }
}
