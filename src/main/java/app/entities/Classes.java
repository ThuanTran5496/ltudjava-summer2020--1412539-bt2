package app.entities;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;
import app.entities.*;

@Entity
@Table(name = "classes", schema="public")
public class Classes {
	
	private List<Student> student;
	private int id;
    private String name;
    
    public Classes(String name) {
    	this.name = name;
    }
 
    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
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
