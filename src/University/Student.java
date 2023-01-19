package University;

import java.util.List;
import java.util.Set;

/*
Create class Student extends class User. Add next variables to class Student:
    - facNumber
    - list of courses
Define constructors - pass with super keyword to the constructor in the base class User
 */
public class Student extends User{
    private String facNumber;
    private Set<String> courseNameList;

    public Student(int id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }

    /*
    Define next 2 methods:
        - add a Course for the student
        - delete a Course for the student
    Maximum courses per student are 10!
     */
    public boolean addCourseForTheStudent(String course) {
        if (courseNameList.size() < 10) {
            courseNameList.add(course);
            return true;
        } return false;
    }

    public boolean removeCourseFromTheStudent(String course) {
        if (courseNameList.contains(course)) {
            courseNameList.remove(course);
            return true;
        }
        return false;
    }
}
