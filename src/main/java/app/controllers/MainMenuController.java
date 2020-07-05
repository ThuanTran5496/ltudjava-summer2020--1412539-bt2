package app.controllers;

import app.hibernate.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

import app.entities.Classes;
import app.entities.Schedule;
import app.entities.Student;
import app.entities.Subject;
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainMenuController {
	private MainMenuView mainMenuView;
	private Constants constants;

	public MainMenuController(MainMenuView view) {
		constants = new Constants();
		this.mainMenuView = view;

//        add listeners
		view.importNewClassListener(new ImportListener());
		view.addAddNewListener(new AddStudentListener());
		view.importScheduleListener(new ImportScheduleListener());
		view.addEditListener(new EditListener());
		view.addDeleteListener(new DeleteListener());
		view.viewStudentClassListener(new ViewListener());
	}

	public void showMainMenuView() {
		mainMenuView.setVisible(true);
	}

	class ImportListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			Transaction transaction = null;
			Session session = HibernateUtil.getSessionFactory().openSession();
			String filePath = "classes.csv";
			StudentView studentView = new StudentView(1);
			StudentController studentController = new StudentController(studentView);

			try {
				mainMenuView.setVisible(false);
				studentController.showStudentView();
				BufferedReader lineReader = new BufferedReader(new FileReader(filePath));
				transaction = session.beginTransaction();
				String className = lineReader.readLine();
				Classes newClass = new Classes(className, className);
				session.save(newClass);
				transaction.commit();
				String dataLine = lineReader.readLine();

				while (dataLine != null) {
					transaction = session.beginTransaction();
					String[] data = dataLine.split(",");
					Student student = new Student(Integer.parseInt(data[0]), data[1], data[2], data[3], newClass);

					session.save(student);
					transaction.commit();
					dataLine = lineReader.readLine();
				}
				lineReader.close();
				studentView.showMessage("Import class " + className + " successfully!");
			} catch (IOException ex) {
				System.err.println(ex);
			} catch (Exception ex) {
				studentView.showMessage("This class already exist!");
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
			StudentView studentView = new StudentView(2);
			StudentController studentController = new StudentController(studentView);
			try {
				mainMenuView.setVisible(false);
				studentController.showStudentView();
				Student data = studentView.getStudentInfo();
				if (data != null) {
					transaction = session.beginTransaction();
					session.save(data);
					transaction.commit();
				}
			} catch (Exception e) {
				transaction.rollback();
				System.err.println(e);
			} finally {
				session.close();
			}

		}
	}

	class ImportScheduleListener implements ActionListener {
		public void actionPerformed(ActionEvent evt) {
			Transaction transaction = null;
			Session session = HibernateUtil.getSessionFactory().openSession();
			String filePath = "schedule.csv";
			StudentView studentView = new StudentView(3);
			StudentController studentController = new StudentController(studentView);

			try {
				mainMenuView.setVisible(false);
				studentController.showStudentView();
				BufferedReader lineReader = new BufferedReader(new FileReader(filePath));
				
				String className = lineReader.readLine();
				Classes newClass = new Classes(className, className);
				
				String dataLine = lineReader.readLine();
				
				transaction = session.beginTransaction();
				Schedule schedule = new Schedule(newClass);
				session.save(schedule);
				transaction.commit();
				while (dataLine != null) {
					transaction = session.beginTransaction();
					String[] data = dataLine.split(",");
					Subject subject = new Subject(data[0], data[1], data[2], schedule);
					session.save(subject);
					transaction.commit();
					dataLine = lineReader.readLine();
				}
				lineReader.close();
				
				studentView.showMessage("Import schedule for " + className + " successfully!");
			} catch (IOException ex) {
				System.err.println(ex);
			} catch (Exception ex) {
				studentView.showMessage("There is something wrong!");
				transaction.rollback();
				System.err.println(ex);
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
			StudentView studentView = new StudentView(4);
			StudentController studentController = new StudentController(studentView);
			try {
				mainMenuView.setVisible(false);
				studentController.showStudentView();
				Student data = studentView.getStudentInfo();
				if (data != null) {
					transaction = session.beginTransaction();
					session.save(data);
					transaction.commit();
				}
			} catch (Exception e) {
				transaction.rollback();
				System.err.println(e);
			} finally {
				session.close();
			}
		}
	}
}
