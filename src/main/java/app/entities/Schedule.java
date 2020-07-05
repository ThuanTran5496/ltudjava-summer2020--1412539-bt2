package app.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "schedule", schema = "public")
public class Schedule implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Classes classes;
	private int id;
	private List<Subject> subject; 

	public Schedule() {

	}

	public Schedule(Classes classes) {
		this.classes = classes;
	}
	
	@OneToOne(mappedBy = "schedule")
	public Classes getClasses() {
		return classes;
	}
	
	public void setClasses(Classes classes) {
		this.classes = classes;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	public int getId() {
        return id;
    }
	public void setId(int id) {
		this.id = id;
	}
	
	@OneToMany(mappedBy="schedule", cascade = CascadeType.ALL, orphanRemoval=false)
	public List<Subject> getSubject() {
        return subject;
    }
	public void setSubject(List<Subject> subject) {
		this.subject = subject;
	}
	
}
