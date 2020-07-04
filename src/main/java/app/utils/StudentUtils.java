package app.utils;
import java.util.List;

import javax.persistence.TypedQuery;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import app.entities.Student;
import app.hibernate.HibernateUtil;

public class StudentUtils {
    private List<Student> listStudents;
    public StudentUtils() {
    }
    // { get , set }
    public void setListStudents(List<Student> listStudents) {
        this.listStudents = listStudents;
    }
    public List<Student> getListStudents() {
    	Session session = HibernateUtil.getSessionFactory().openSession();
    	try {
			TypedQuery<Student> query = session.createQuery("select sv from SinhVien sv");
			listStudents = query.getResultList();
	    } catch (HibernateException ex) {
	    	System.err.println(ex);
    	} finally {
    		session.close();
    	}
    	return listStudents;
    }
}