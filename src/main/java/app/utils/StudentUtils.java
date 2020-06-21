package app.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import app.entities.Student;
import app.entities.XmlBinding;
import app.utils.FileUtils;

/**
 * StudentDao class
 * 
 * @author viettuts.vn
 */
public class StudentUtils {
    private static final String STUDENT_FILE_NAME = "student.xml";
    private List<Student> listStudents;

    public StudentUtils() {
        this.listStudents = readListStudents();
    }

    /**
     * Lưu các đối tượng student vào file student.xml
     * 
     * @param students
     */
    public void writeListStudents(List<Student> students) {
        XmlBinding studentXML = new XmlBinding();
        studentXML.setStudent(students);
        FileUtils.writeXMLtoFile(STUDENT_FILE_NAME, studentXML);
    }

    /**
     * Đọc các đối tượng student từ file student.xml
     * 
     * @return list student
     */
    public List<Student> readListStudents() {
        List<Student> list = new ArrayList<Student>();
        XmlBinding studentXML = (XmlBinding) FileUtils.readXMLFile(
                STUDENT_FILE_NAME, XmlBinding.class);
        if (studentXML != null) {
            list = studentXML.getStudent();
        }
        return list;
    }
    

    public void add(Student student) {
        int id = (listStudents.size() > 0) ? (listStudents.size() + 1) : 1;
        student.setMSSV(id);
        listStudents.add(student);
        writeListStudents(listStudents);
    }

    public void edit(Student student) {
        int size = listStudents.size();
        for (int i = 0; i < size; i++) {
            if (listStudents.get(i).getMSSV() == student.getMSSV()) {
                listStudents.get(i).setName(student.getName());
                listStudents.get(i).setSex(student.getSex());
                listStudents.get(i).setCMND(student.getCMND());
                writeListStudents(listStudents);
                break;
            }
        }
    }

    /**
     * xóa student từ listStudents và lưu listStudents vào file
     * 
     * @param student
     */
    public boolean delete(Student student) {
        boolean isFound = false;
        int size = listStudents.size();
        for (int i = 0; i < size; i++) {
            if (listStudents.get(i).getMSSV() == student.getMSSV()) {
                student = listStudents.get(i);
                isFound = true;
                break;
            }
        }
        if (isFound) {
            listStudents.remove(student);
            writeListStudents(listStudents);
            return true;
        }
        return false;
    }

    public void sortStudentByName() {
        Collections.sort(listStudents, new Comparator<Student>() {
            public int compare(Student student1, Student student2) {
                return student1.getName().compareTo(student2.getName());
            }
        });
    }

    public List<Student> getListStudents() {
        return listStudents;
    }

    public void setListStudents(List<Student> listStudents) {
        this.listStudents = listStudents;
    }
}