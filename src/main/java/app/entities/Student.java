package app.entities;
import javax.persistence.*;

@Entity
@Table(name = "student", schema="student")
public class Student implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Classes classId;
	private int MSSV;
    private String name;
    private String sex;
    private String CMND;

    public Student() {
    }

    public Student(int mssv, String name, String sex, String CMND) {
        super();
        this.MSSV = mssv;
        this.name = name;
        this.sex = sex;
        this.CMND = CMND;
    }
    
    @Id
    @Column(name = "mssv")
    public int getMSSV() {
        return MSSV;
    }

    public void setMSSV(int mssv) {
        this.MSSV = mssv;
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
