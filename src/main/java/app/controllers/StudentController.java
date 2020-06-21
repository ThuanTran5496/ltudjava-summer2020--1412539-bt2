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
    private Constants constants;
    public StudentController(StudentView view) {
        
        stdUtil = new StudentUtils();
        
        this.studentView = view;

//        add listeners
        view.addAddStudentListener(new AddListener());
        view.addEdiStudentListener(new EditListener());
        view.addDeleteStudentListener(new DeleteListener());
        view.addClearListener(new ClearListener());
        view.addSortStudentNameListener(new SortListener());
        view.addListStudentSelectionListener(new ListStudentListener());
    }

    public void showStudentView() {
        List<Student> studentList = stdUtil.getListStudents();
        studentView.setVisible(true);
        studentView.showListStudents(studentList);
    }
    
    class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Student student = studentView.getStudentInfo();
            if (student != null) {
                stdUtil.add(student);
                studentView.showStudent(student);
                studentView.showListStudents(stdUtil.getListStudents());
                studentView.showMessage(constants.addSuccess);
            } else {
            	studentView.showMessage(constants.addFail);
            }
        }
    }

    class EditListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Student student = studentView.getStudentInfo();
            if (student != null) {
                stdUtil.edit(student);
                studentView.showStudent(student);
                studentView.showListStudents(stdUtil.getListStudents());
                studentView.showMessage(constants.editSuccess);
            } else {
            	studentView.showMessage(constants.editFail);
            }
        }
    }

    class DeleteListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Student student = studentView.getStudentInfo();
            if (student != null) {
                stdUtil.delete(student);
                studentView.clearStudentInfo();
                studentView.showListStudents(stdUtil.getListStudents());
                studentView.showMessage(constants.deleteSuccess);
            } else {
            	studentView.showMessage(constants.deleteFail);
            }
        }
    }

    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            studentView.clearStudentInfo();
        }
    }

    class SortListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            stdUtil.sortStudentByName();
            studentView.showListStudents(stdUtil.getListStudents());
        }
    }

    class ListStudentListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            studentView.fillStudentFromSelectedRow();
        }
    }
}
