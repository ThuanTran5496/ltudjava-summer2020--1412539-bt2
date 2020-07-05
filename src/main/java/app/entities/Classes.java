package app.entities;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;
import app.entities.*;

@Entity
@Table(name = "classes", schema="public")
public class Classes {
	private Schedule schedule;
	private List<Student> student;
	private String id;
    private String name;
    public Classes() {
    }
    public Classes(String id, String name) {
    	this.id = id;
    	this.name = name;
    }
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    public Schedule getSchedule() {
    	return schedule;
    }
    
    public void setSchedule(Schedule schedule) {
    	this.schedule = schedule;
    }
    
    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }
    @OneToMany(mappedBy="classes", cascade = CascadeType.ALL, orphanRemoval=false)
    public List<Student> getStudent() {
        return student;
    }
    public void setStudent(List<Student> student) {
        this.student = student;
    }
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
}
