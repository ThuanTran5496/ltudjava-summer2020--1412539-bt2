package app.controllers;

import app.utils.StudentUtils;
import app.views.MainMenuView;
import app.views.StudentView;
import constants.Constants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import app.entities.Student;

public class StudentController {
    private StudentUtils stdUtil;
    private StudentView studentView;
    public StudentController(StudentView view) {
        stdUtil = new StudentUtils();
        this.studentView = view;
        view.addBackListener(new BackListener());
    }

    public void showStudentView() {
//        List<Student> studentList = stdUtil.getListStudents();
        studentView.setVisible(true);
//        studentView.showListStudents(studentList);
    }
    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	MainMenuController mainMenuController = new MainMenuController(new MainMenuView());
        	mainMenuController.showMainMenuView();
            studentView.setVisible(false);
        }
    }
}
