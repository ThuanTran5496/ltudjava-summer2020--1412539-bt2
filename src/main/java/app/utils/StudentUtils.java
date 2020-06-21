package app.utils;
import java.util.List;
import app.entities.Student;

public class StudentUtils {
    private List<Student> listStudents;
    public StudentUtils() {
    }
    // { get , set }
    public void setListStudents(List<Student> listStudents) {
        this.listStudents = listStudents;
    }
    public List<Student> getListStudents() {
        return listStudents;
    }
}