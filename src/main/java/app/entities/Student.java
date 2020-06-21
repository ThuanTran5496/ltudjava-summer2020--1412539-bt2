package app.entities;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "student")
@XmlAccessorType(XmlAccessType.FIELD)
public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private int MSSV;
    private String name;
    private String sex;
    private String CMND;

    public Student() {
    }

    public Student(int mssv, String name, String sex, String CMND, float gpa) {
        super();
        this.MSSV = mssv;
        this.name = name;
        this.sex = sex;
        this.CMND = CMND;
    }

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
