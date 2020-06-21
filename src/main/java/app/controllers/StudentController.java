package app.controllers;

import app.utils.StudentUtils;
import app.views.StudentView;
import constants.Constants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import app.entities.Student;

public class StudentController {
    private StudentUtils stdUtil;
    private StudentView studentView;
    public StudentController(StudentView view) {
        stdUtil = new StudentUtils();
        this.studentView = view;
    }

    public void showStudentView() {
        List<Student> studentList = stdUtil.getListStudents();
        studentView.setVisible(true);
        studentView.showListStudents(studentList);
    }
}
