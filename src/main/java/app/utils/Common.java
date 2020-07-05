package app.utils;

import app.hibernate.HibernateUtil;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import app.entities.LoginUser;

public class Common {
    public boolean checkUserLogin(LoginUser user) {
    	Transaction transaction = null;
    	boolean found = false;
        Session session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        try {
        	Query query = session.createQuery("FROM LoginUser");
        	List<LoginUser> users = (List<LoginUser>)query.list();
        	for (int i =0; i<users.size(); i++) {
        		if (user != null && users.get(i) != null && user.getUserName().equals(users.get(i).getUserName()) && user.getPassword().equals(users.get(i).getPassword())) {
        			found = true;
        			break;
	            }
        	}
	    } catch (HibernateException ex) {
	    	System.err.println(ex);
	    	return false;
    	}
        return found;
    }
}
