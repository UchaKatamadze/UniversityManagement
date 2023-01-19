package University;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class UniManagementImpl implements UniManagement {
    // Define an array of Students - it will save all students in the course. Max 1000!
    Student[] students = new Student[1000];
    int studentCount = 0;
/*
For the array of Students define an int variable for pointing to the last used index for the array,
which could be used for inserting of a new item.
This index will be used for next purposes:
- when you add a new Student to the relevant array, you will also increment the index with one
- when you remove an item, you will decrement that index
 */

    // Define a list of Courses - it will save all courses. Max 10!
    Course[] courses = new Course[10];
    int courseCount = 0;
    // Define a list of Lectors - it will save all assistants
    List<Lector> allAssistants = new ArrayList<>();
    // Define a list of Lectors - it will save all docents and professors
    List<Lector> allOther = new ArrayList<>();


    /*
    Create a new Course via next method signature:
    This method makes next operations:
        1. Define a lambda predicate function which to check if there is already a course in the
            list of Course instances
        2. if there is no such a course, create a new instance of Course AND save the returned
            Course instance in the array with courses.
        3. In another case, throw an exception (or print in the console an error message).
     */
    @Override
    public Course createCourse(String courseName) {
        Predicate<String> existingCourse = course -> {
            return courseName.equals(courseName);
        };
        for (Course co : courses) {
            if (existingCourse.test(co.getCourseName())) {
                return null;
            }
        }
        Course newCourse = new Course(courseName);
        if (courseCount < 10) {
            courses[courseCount] = newCourse;
            courseCount++;
        }
        return newCourse;

    }

    /*
    Delete a Course via next method signature:
        This method makes next operations:
        1. Use the same lambda predicate function you created already for finding if there is a
            course with the passed name already
     */
    @Override
    public boolean deleteCourse(String courseName) throws CourseNotFoundException {
        Predicate<String> courseExists = name -> name.equals(name);
        for (int i = 0; i < courses.length; i++) {
            if (courses[i] == courseExists) {
                courses = removeElement(courses, i);
                courseCount--;
                return true;
            }
        }
        throw new CourseNotFoundException();
    }

    public static Course[] removeElement(Course[] original, int element) {
        Course[] n = new Course[original.length - 1];
        System.arraycopy(original, 0, n, 0, element);
        System.arraycopy(original, element + 1, n, element, original.length - element - 1);
        return n;
    }

    // Create a new Student via next method signature. Add the new created student to the array of students
    @Override
    public Student createStudent(int id, String firstName, String lastName, String facNumber) {
        Student newStudent = new Student(id, firstName, lastName);
        students[studentCount++] = newStudent;
        return newStudent;
    }

    /*
    Delete the student from the array of students with the passed ID. Also, when you remove a student,
    shift all remaining students with one index behind it. Decrement the lastUsedStdentIndex with 1.
    So, to point to the index where next student could be inserted in the array.
     */
    @Override
    public boolean deleteStudent(int id) throws StudentNotFountException {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getId() == id) {
                students = removeElement(students, i);
                studentCount--;
                return true;
            }
        }
        throw new StudentNotFountException();
    }

    public static Student[] removeElement(Student[] original, int element) {
        Student[] n = new Student[original.length - 1];
        System.arraycopy(original, 0, n, 0, element);
        System.arraycopy(original, element + 1, n, element, original.length - element - 1);
        return n;
    }

    /*
    Create an assistance. Add the new assistance to the array of assistants as well
     */
    @Override
    public Lector createAssistant(int id, String firstName, String lastName, String lectorType) {
        Lector l = new Lector(id, firstName, lastName);
        l.lectorType = Lector.LectorType.valueOf(lectorType);
        return l;
    }

    /*
    Delete an assistance with next method signature:
     */
    @Override
    public boolean deleteAssistant(int id) {
        allAssistants.remove(id);
        return true;
    }

    // Assign a course to an assistance as:
    @Override
    public boolean assignAssistantToCourse(Lector assistant, Course course) {
        course.setAssistant(assistant);
        return assistant.addLectortoTheCourse(course.getCourseName());
    }

    // Assign a course to an professor as
    @Override
    public boolean assignProfessorToCourse(Lector professor, Course course) {
        course.setLector(professor);
        return professor.addLectortoTheCourse(course.getCourseName());
    }

    /*
    Add a student to a course as: NOTE: when you add a student to a course, also have in mind to update
    the list of courses for in Student instance, also the list of students in Course instance
     */
    @Override
    public boolean addStudentToCourse(Student student, Course course) {
        return student.addCourseForTheStudent(course.getCourseName()) &&
                course.addStudent(student);
    }

    // Add many students to a course as
    @Override
    public boolean addStudentsToCourse(Student[] students, Course course) {
        for (int i = 0; i < students.length; i++) {
            if (!addStudentToCourse(students[i], course)) {
                return false;
            }
        }
        return true;
    }

    // Remove a student from a course as:
    @Override
    public boolean removeStudentFromCourse(Student student, Course course) {
        return student.removeCourseFromTheStudent(course.getCourseName()) &&
                course.deleteStudent(student);

    }

    public Student getStudent(int id) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getId() == id) {
                return students[i];
            }
        }
        return null;
    }

    public Course getCourse(String courseNamee) {
        for (int i = 0; i < courses.length; i++) {
            if (courses[i].getCourseName() == courseNamee) {
                return courses[i];
            }
        }
        return null;
    }

    public Lector getAssistant(int id) {
        for (int i = 0; i < allAssistants.size(); i++) {
            if (allAssistants.get(i).getId() == id) {
                return allAssistants.get(i);
            }
        }
        return null;
    }

    public Lector getProfessor(int id) {
        for (int i = 0; i < allOther.size(); i++) {
            if (allOther.get(i).getId() == id) {
                return allOther.get(i);
            }
        }
        return null;
    }
}