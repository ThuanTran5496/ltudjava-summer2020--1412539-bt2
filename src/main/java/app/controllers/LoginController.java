package app.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import app.entities.User;
import constants.Constants;
import app.utils.Common;
import app.views.LoginView;
import app.views.StudentView;

public class LoginController {

    private LoginView loginView;
    private StudentView studentView;
    private Constants constants;
    private Common commonUtil;

    public LoginController(LoginView view) {
        this.commonUtil = new Common();
        this.loginView = view;
        view.addLoginListener(new LoginListener());
    }
    public void showLoginView() {
        loginView.setVisible(true);
    }
    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            User user = loginView.getUser();
            if (commonUtil.checkUserLogin(user) == true) {
                studentView = new StudentView();
                StudentController studentController = new StudentController(studentView);
                studentController.showStudentView();
                loginView.setVisible(false);
            } else {
                loginView.showMessage(constants.loginErrorMessage);
            }
        }
    }
}
