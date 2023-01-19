package University;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) throws StudentNotFountException {
/*
Let’s in the Main class method from where our program starts has a command based
implementation. What I mean is that the user will enter commands in the console, then the
program should read them, parse them and recognize which is the command and printto the
console a message to the user if the command has been executed successfully or not.
Hints:
- use the Scanner class for reading of user’s input
- Use a while loop by the type the user enter Exit command
- For parsing the use sinput use the methods of String API (let’s say you need to parse the
words in the whole command line entered: e.g. “createStudent 1 Gio Gio 34565” in order
to take the sub strung u can use the method split(...) method with passing the right
argument in it of course.
 */
        Scanner sc = new Scanner(System.in);
        UniManagementImpl uniManagement = new UniManagementImpl();
        String line = " ";
        while(sc.hasNextLine()) {
            line = sc.nextLine();
            String[] par = line.split(" ");
            switch (par[0]) {
                case "createStudent":
                    uniManagement.createStudent(Integer.valueOf(par[1]), par[2], par[3], par[4]);
                    break;
                case "createCourse" :
                    uniManagement.createCourse(par[1]);
                    break;
                case "createAssistance" :
                    uniManagement.createAssistant(Integer.valueOf(par[1]), par[2], par[3], "Assistant");
                    break;
                case "createProfessor":
                    uniManagement.createAssistant(Integer.valueOf(par[1]), par[2], par[3],par[4]);
                    break;
                case "assignStudentToCourse":
                    uniManagement.addStudentToCourse(uniManagement.getStudent(Integer.valueOf(par[1])), uniManagement.getCourse(par[2]));
                    break;
                case "assignAssistantToCourse":
                    uniManagement.assignAssistantToCourse(uniManagement.getAssistant(Integer.valueOf(par[1])),uniManagement.getCourse(par[2]));
                    break;
                case "assignProfessorToCourse":
                    uniManagement.assignProfessorToCourse(uniManagement.getProfessor(Integer.valueOf(par[1])),uniManagement.getCourse(par[2]));
                    break;
        }
        }

/*
createStudent <user_id> <userFirstName> <userLastName> <facNumber>
Example commands: createStudent 1 Gio Gio 34565
This command will create a new student
 */

/*
createCourse <courseName>. Example commands: createCourse java
This command will create a new course in the university
 */

/*
createAssistance <user_id> <userFirstName> <userLastName>
Example: createAssistance 5 Marya Petkova
 */

/*
- createProfessor <user_id> <userFirstName> <userLastname> <lectorType>
Example: createProfessor 10 Jon Evans DOCENT
 */

/*
asighStudentToCourse <student_id> <courseName>
Example: asighStudentToCourse 1 java
Assign a student with passed ID to the course with passed name
 */

/*
asighStudentToCourse <assistance_id> <courseName>
Example: asighAssistanceToCourse 5 java
Sigh a assistance with passed ID to the course with passed name
 */

/*
asighProfessorToCourse <lectort_id> <courseName>
Example: asighProfessorToCourse 10 java
Asigh a lectorwith passed ID to the course with passed name
 */

/*
Please in order to implement the arguments line command use another class ArgumentParser,
which will
define as constant all possible commands as:
public static final String CREATE_STUDENT = "createStudent";
and all the others ...
Use these constants to check if the user input current command as argument and only then
check the arguments for each command
and use these arguments for execution of the command (creation of a course, assigning student
to a course and etc.)
 */
    }
}
