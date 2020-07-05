package app.controllers;

import app.entities.Classes;
import app.entities.LoginUser;
import app.entities.Student;
import app.hibernate.HibernateUtil;
import app.utils.StudentUtils;
import app.views.MainMenuView;
import app.views.StudentView;
import constants.Constants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentController {
    private StudentUtils stdUtil;
    private StudentView studentView;
    public StudentController(StudentView view) {
        stdUtil = new StudentUtils();
        this.studentView = view;
        view.addBackListener(new BackListener());
        view.addFinishListener(new FinishListener());
    }

    public void showStudentView() {
//        List<Student> studentList = stdUtil.getListStudents();
        studentView.setVisible(true);
//        studentView.showListStudents(studentList);
    }
    class BackListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
        	MainMenuController mainMenuController = new MainMenuController(new MainMenuView());
        	mainMenuController.showMainMenuView();
            studentView.setVisible(false);
        }
    }
    class FinishListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
        	Transaction transaction = null;
            Session session = HibernateUtil.getSessionFactory().openSession();
            try {
	        	Student data = studentView.getStudentInfo();
	        	if (data != null) {
	        		boolean isExist = false;
	        		transaction = session.beginTransaction();
	        		Query query = session.createQuery("FROM Classes");
	            	List<Classes> classes = (List<Classes>)query.list();
	            	for (int i =0; i<classes.size(); i++) {
	            		if (classes.get(i).getId().contentEquals(data.getClasses().getId())) {
	            			isExist = true;
	            			session.save(data);
	    		        	transaction.commit();
	    		        	studentView.showMessage("Add new student success!");
	            			break;
	            		}
	            	}
	            	if (isExist == false) {
	            		studentView.showMessage("This class does not exist, please import first!");
	            	}
	        	}
        	} catch (Exception e) {
        		studentView.showMessage("MSSV was duplicated!");
            	transaction.rollback();
            	System.err.println(e);
            } finally {
            	session.close();
            }
        }
    }
}
