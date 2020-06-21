package app.entities;
import javax.persistence.*;

@Entity
@Table(name = "classes")
public class Classes {
	private int id;
    private String name;
    
    public Classes() {
    }
 
    @Id
    @Column(name = "classes_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
}