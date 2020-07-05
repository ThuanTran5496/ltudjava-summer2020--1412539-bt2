package app.entities;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "student", schema="public")
public class Student implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Classes classObj;
	private String class_id;
	private int MSSV;
    private String name;
    private String sex;
    private String CMND;

    public Student() {
    }

    public Student(int mssv, String name, String sex, String CMND, Classes classObj) {
        super();
        this.MSSV = mssv;
        this.name = name;
        this.sex = sex;
        this.CMND = CMND;
        this.classObj = classObj;
    }
    
    @Id
    @Column(name = "mssv")
    public int getMSSV() {
        return MSSV;
    }

    public void setMSSV(int mssv) {
        this.MSSV = mssv;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "class_id")
	public Classes getClasses() {
		return classObj;
	}

	public void setClasses(Classes classObj) {
		this.classObj = classObj;
	}
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }
}
