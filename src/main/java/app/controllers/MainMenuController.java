package app.controllers;

import app.hibernate.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;
import app.entities.Student;
import app.views.MainMenuView;
import app.views.StudentView;
import constants.Constants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

public class MainMenuController {
	private MainMenuView mainMenuView;
	private Constants constants;
	
	public MainMenuController(MainMenuView view) {
        constants = new Constants();
        this.mainMenuView = view;
        
//        add listeners
        view.importNewClassListener(new ImportListener());
        view.addAddNewListener(new AddStudentListener());
        view.addEditListener(new EditListener());
        view.addDeleteListener(new DeleteListener());
        view.addViewListener(new ViewListener());
    }
	
	public void showMainMenuView() {
        mainMenuView.setVisible(true);
    }
	
	class ImportListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
        	Transaction transaction = null;
            Session session = HibernateUtil.getSessionFactory().openSession();
            String filePath = "classes.csv";
            try {
            	mainMenuView.setVisible(false);
	        	StudentView studentView = new StudentView(1);
	        	studentView.setVisible(true);
                BufferedReader lineReader = new BufferedReader(new FileReader(filePath));
                String className = lineReader.readLine();
                String dataLine = lineReader.readLine();
     
                while (dataLine != null) {
                    String[] data = dataLine.split(",");
                    Student student = new Student(Integer.parseInt(data[0]), data[1],data[2],data[3]);
                    transaction = session.beginTransaction();
		        	session.save(student);
		        	transaction.commit();
                    dataLine = lineReader.readLine();
                }
                lineReader.close();
                studentView.showMessage("Import class" + className + "successfully!");
     
            } catch (IOException ex) {
                System.err.println(ex);
            } catch (Exception ex) {
            	transaction.rollback();
            	System.err.println(ex);
            } finally {
            	
            	session.close();
            }
        	
        }
	}
	 class AddStudentListener implements ActionListener {
	        public void actionPerformed(ActionEvent evt) {
	        	Transaction transaction = null;
	            Session session = HibernateUtil.getSessionFactory().openSession();
	        	try {
	        		mainMenuView.setVisible(false);
		        	StudentView studentView = new StudentView(2);
		        	studentView.setVisible(true);
		        	Student data = studentView.getStudentInfo();
		        	transaction = session.beginTransaction();
		        	session.save(data);
		        	transaction.commit();
	        	} catch (Exception e) {
	            	transaction.rollback();
	            	System.err.println(e);
	            } finally {
	            	session.close();
	            }
	        	
	        }
	    }
	 class EditListener implements ActionListener {
	        public void actionPerformed(ActionEvent evt) {
	        	Transaction transaction = null;
	            Session session = HibernateUtil.getSessionFactory().openSession();
	            try {
	            	mainMenuView.setVisible(false);
		        	 StudentView studentView = new StudentView(4);
		        	studentView.setVisible(true);
		        	Student data = studentView.getStudentInfo();
		        	transaction = session.beginTransaction();
		        	session.update(data);
		        	transaction.commit();
	            } catch (Exception e) {
	            	transaction.rollback();
	            	System.err.println(e);
	            } finally {
	            	session.close();
	            }
	        	
	        }
	    }
	 class DeleteListener implements ActionListener {
	        public void actionPerformed(ActionEvent evt) {
	        	Transaction transaction = null;
	            Session session = HibernateUtil.getSessionFactory().openSession();
	            try {
	        	mainMenuView.setVisible(false);
	        	StudentView studentView = new StudentView(3);
	        	studentView.setVisible(true);
	        	Student data = studentView.getStudentInfo();
	        	transaction = session.beginTransaction();
	        	session.delete(data);
	        	transaction.commit();
	            } catch (Exception e) {
	            	transaction.rollback();
	            	System.err.println(e);
	            } finally {
	            	session.close();
	            }
	        }
	    }
	 class ViewListener implements ActionListener {
	        public void actionPerformed(ActionEvent evt) {
	        	Transaction transaction = null;
	            Session session = HibernateUtil.getSessionFactory().openSession();
	            try {
	        	mainMenuView.setVisible(false);
	        	StudentView studentView = new StudentView(1);
	        	studentView.setVisible(true);
	            } catch (Exception e) {
	            	transaction.rollback();
	            	System.err.println(e);
	            } finally {
	            	session.close();
	            }
	        }
	    }
}
