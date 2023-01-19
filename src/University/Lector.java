package University;

import java.util.List;
/*
Create class Lector extends class User. Add next variables to class Lector
    - enum lectorType (with predefined values - DOCENT, PROFESSOR, ASSISTANCE)
    - list of courses
Define constructors - pass with super keyword to the constructor in the base class User
 */
public class Lector extends User{
    public Lector(int id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }
    public enum LectorType { Docent, Professor, Assistant}
    public LectorType lectorType;
    private List<String> courseList;
/*
Define next 2 methods:
    - add a Course for the Lector
    - delete a Course for the Lector
Maximum courses per Lector are 4!
 */
    public boolean addLectortoTheCourse(String course) {
        if(courseList.size() < 4) {
            courseList.add(course);
            return true;
        } return false;
    }

    public void removeLectorFromCourse(String course) {
        courseList.remove(course);
    }
}
