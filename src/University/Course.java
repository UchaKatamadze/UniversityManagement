package University;

import java.util.List;
import java.util.function.Predicate;

public class Course {
    /*
    Create class Course with next variables:
        - name // It is unique for each course. There are no 2 courses with one and same name
        - list of students
        - assistance - it's a type of Lector, represents the professor assistance
        - lector - it's a type of Lector, represents the docent or professor
     */
    private String name;
    private List<Student> students;
    private Lector assistant;
    private Lector lector;
    private Object student;

    public Course(String name, Lector lector, Lector assistant) {
        this.name = name;
        this.lector = lector;
        this.assistant = assistant;
    }

    /*
    Define 2 constructors as:
        - one constructor with passing the name of the course as arguments to the constructor
        - another constructor (overloaded) with passing the name, the lector and the assistance as
        arguments to the constructor
     */
    public Course(String name) {
        this.name = name;
    }

    /*
    Define next methods:
    - one method for adding of a Student
    - one method for delete of a student
    - one method for setting the assistance
    - one method for setting the lector
    Maximum students per course are 30!
     */
    public boolean addStudent(Student student) {
        if (students.size() < 30) {
            students.add(student);
            return true;
        }
        return false;

    }

    public boolean deleteStudent(Student student) {
        Predicate<Student> existingStudent = stud -> stud.equals(student);
        if (existingStudent != null) {
            students.remove(existingStudent);
            return true;
        }return false;
    }
    public void setAssistant(Lector assistant) {
        this.assistant = assistant;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }
    public String getCourseName() {
        return name;
    }
}
