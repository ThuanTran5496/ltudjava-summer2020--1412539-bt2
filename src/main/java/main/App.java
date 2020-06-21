package main;

import java.awt.EventQueue;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import app.controllers.LoginController;
import app.entities.Student;
import app.views.LoginView;

public class App {
	protected SessionFactory sessionFactory;
    public static void main(String[] args) {
    	App app = new App();
    	app.setup();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginView view = new LoginView();
                LoginController controller = new LoginController(view);

                controller.showLoginView();
            }
        });
    }
    
    public void setup() {
    	
    	try {
    		sessionFactory = new Configuration().configure().buildSessionFactory();
    	    if (sessionFactory != null) {
    	    	Session session = sessionFactory.openSession();
    	    	Student a = (Student)session.get(Student.class, 14141);
    	    	System.out.print(a);
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