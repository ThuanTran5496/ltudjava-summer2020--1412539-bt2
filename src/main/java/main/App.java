package main;

import java.awt.EventQueue;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import app.controllers.LoginController;
import app.entities.Student;
import app.views.LoginView;

public class App {
	protected SessionFactory sessionFactory;
	public static Session session;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginController controller = new LoginController(new LoginView());
                controller.showLoginView();
            }
        });
    }
    
    public void setup() {
    	try {
    		sessionFactory = new Configuration().configure().buildSessionFactory();
    	    if (sessionFactory != null) {
    	    	session = sessionFactory.openSession();
    	    	// check to see if db connected
//    	    	Student student = (Student)session.get(Student.class, 14141);
//    	    	if (student!= null) {
//    	    		
//    	    	}
//    	    	session.beginTransaction();
    	    	
    	    }
    	} catch (Exception ex) {
    	 
    		throw new RuntimeException(ex);
    	}
    }
    protected void exit() {
    }
 
    protected void create() {
    }
 
    protected void view() {
    }
 
    protected void edit() {
    }
 
    protected void delete() {
    }
 
}