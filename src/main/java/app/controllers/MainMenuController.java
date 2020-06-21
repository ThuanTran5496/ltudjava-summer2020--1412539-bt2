package app.controllers;
import main.App;
import java.util.List;

import org.hibernate.Transaction;

import app.entities.Student;
import app.views.MainMenuView;
import app.views.StudentView;
import constants.Constants;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuController {
	private MainMenuView mainMenuView;
	private Constants constants;
	
	public MainMenuController(MainMenuView view) {
        
        this.mainMenuView = view;

//        add listeners
        view.addAddNewListener(new AddListener());
        view.addEditListener(new EditListener());
        view.addDeleteListener(new DeleteListener());
//        view.addViewListener(new ClearListener());
    }
	
	public void showMainMenuView() {
        mainMenuView.setVisible(true);
    }
	
	 class AddListener implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	        	mainMenuView.setVisible(false);
	        	 StudentView studentView = new StudentView();
	        	studentView.setVisible(true);
	        	Student mockData = new Student(141, "abc", "code", "cmnd");
	        	Transaction trans = App.session.beginTransaction();
	        	App.session.save(mockData);
	        	trans.commit();
	        }
	    }
	 class EditListener implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	        	mainMenuView.setVisible(false);
	        	 StudentView studentView = new StudentView();
	        	studentView.setVisible(true);
	        	// a = search function return student object
	        	Student mockData = new Student(141, "abc", "code", "cmnd");
	        	Transaction trans = App.session.beginTransaction();
	        	App.session.update(mockData);
	        	trans.commit();
	        }
	    }
	 class DeleteListener implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	        	mainMenuView.setVisible(false);
	        	 StudentView studentView = new StudentView();
	        	studentView.setVisible(true);
	        	Student mockData = new Student(141, "abc", "code", "cmnd");
	        	Transaction trans = App.session.beginTransaction();
	        	App.session.delete(mockData);
	        	trans.commit();
	        }
	    }
	 class ViewListener implements ActionListener {
	        public void actionPerformed(ActionEvent e) {
	        	mainMenuView.setVisible(false);
	        	 StudentView studentView = new StudentView();
	        	studentView.setVisible(true);
	        }
	    }
}
