package University;
/*
Create interface UniManagement which will define the contract , or all functions, which will
be used for management of the university courses as:
 */
public interface UniManagement {
/*
Create a new course with name courseName and return it @return new instance of course with
the passed name if it's created or null in another case. A course will be created only if already
does not exists another course with the same courseName
 */
    Course createCourse (String courseName);

/*
Delete a course with name courseName. @return <code>true</code> only in case the course with passed
name was removed
 */
    boolean deleteCourse (String courseName) throws CourseNotFoundException;

/*
Create and return new instance of Student with the passed arguments and initial state
of the student. return new instance of a student identified with the passed ID, if already does not exist,
and the other arguments as initial state if it's created or null in another case
 */
    Student createStudent(int id, String firstName, String lastName, String facNumber);

/*
 * Delete a student with the passed ID. @return <code>true</code> only in cae the student was removed
 */
    boolean deleteStudent(int id) throws StudentNotFountException;

/*
Create a new assistance in the university with the passed arguments as initial state
@return new created professor assistance identified with the passed ID, if already does not exists with that ID
 */
    Lector createAssistant(int id, String firstName, String lastName, String lectorType);

/*
Delete an professor assistant with the passed ID, if such exists
@return <code>true</code> ONLY in case the assistance was removed
 */
    boolean deleteAssistant (int id);

/*
Assign an assistance to a course @return <code>true</code> ONLY n case the assistance was successfully assigned to
the course
 */
    boolean assignAssistantToCourse (Lector assistant, Course course);

/*
Assign a professor to a course. @return <code>true</code> ONLY n case the professor was successfully assigned to
the course
 */
    boolean assignProfessorToCourse (Lector professor, Course course);

/*
 Add all student to a course. @return <code.true</code> ONLY in case the student is successfully added to the
course
 */
    boolean addStudentsToCourse(Student[] students, Course course);
/*
Add a student to a course. @return <code.true</code> ONLY inca se the student is successfully added to the
course
 */
     boolean addStudentToCourse (Student student, Course course);
/*
Remove a student from a course. @return <code>true</code> only in case the student was
successfully removed from a course
 */
    boolean removeStudentFromCourse (Student student, Course course);

}
