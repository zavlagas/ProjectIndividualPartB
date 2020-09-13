/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectindividualpartb;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import modelsconnection.Database;
import objects.Assignment;
import objects.Course;
import objects.Student;
import objects.Trainer;
import tools.Tools;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class ProjectIndividualPartB {

    static Tools x = new Tools();

    public static void main(String[] args) {
        createStudent();

    }

    /*Create A menu Which Has 
    1) Create Student
    2) Create Trainer
    3) Create assignment
    4) Create course
    5)Insert Students To Course
    6)Insert Trainers To Course
    7)Insert Assignments To Course
    8)Show Lists
    9)Input A Date And Find A List Of students Who need TO Submit Assignment
    10)Exit
    
    
     */
    public static void appearanceStartMenu() {

        x.QueNL("======= WELCOME TO BOOTCAMP =======");
        x.QueNL("\n");
        x.QueNL("CREATE [ Models ] :      [= 1 =]");
        x.QueNL("-----------------------------------");
        x.QueNL("INSERT INTO [ Course ] : [= 2 =]");
        x.QueNL("-----------------------------------");
        x.QueNL("SHOW LISTS :             [= 3 =]");
        x.QueNL("-----------------------------------");
        x.QueNL("SEARCH DATE :            [= 4 =]");
    }

    public static void startingSwitchMenu() {
        int choiceentry;

        do {
            x.QueNL("Create Entity :    [1]\nInsert Entity :    [2]\nShow Lists :       [3]\nSearch Date :      [4]\nExit Programm :    [5]");
            x.QueNL("-------------------------------");
            System.out.println("Enter [ \"1\", \"2\", \"3\", \"4\" or \"5\" ]");
            choiceentry = x.ScanForInt();

            switch (choiceentry) {
                case 1:
                    createOptionSwitchMenu();
                    break;
                case 2:
                    // You Want To Manage Courses (Students,Assignments,Trainers) 
                    break;
                case 3:
                    //  You Want To Show Our Lists
                    break;
                case 4:
                    // Search Date From Assignments
                    break;
                case 5:
                    // You Want To Exit The Program
                    break;
                default:
                    System.out.println("Choice must be a value between 1 and 5.");
            }
        } while (choiceentry != 4);

    }

    public static void createOptionSwitchMenu() {

        int choiceentry;

        do {
            x.QueNL("Student :    [1]\nTrainer :    [2]\nAssignment : [3]\nCourse :     [4]\nGo Back :    [5]");
            x.QueNL("-----------------------------------");
            System.out.println("Enter [ \"1\", \"2\", \"3\", \"4\" or \"5\" ]");
            choiceentry = x.ScanForInt();

            switch (choiceentry) {
                case 1:
                    createStudent();
                    break;
                case 2:
                    createTrainer();
                    break;
                case 3:
                    createAssignment();
                    break;
                case 4:
                    createCourse();
                    break;
                case 5:
                    startingSwitchMenu();
                    break;
                default:
                    System.out.println("Choice must be a value between 1 and 5.");
            }
        } while (choiceentry != 5);

    }

    public static void InsertIntoOptionSwitchMenu() {

        int choiceentry;

        do {
            System.out.println("Enter \"1\", \"2\", \"3\", \"4\" or \"5\"");
            choiceentry = x.ScanForInt();

            switch (choiceentry) {
                case 1:
                    // Insert Students To Course
                    break;
                case 2:
                    // Insert Trainers To Course
                    break;
                case 3:
                    // Insert Trainers To Course
                    break;
                case 4:
                    // Insert Assignments To Course
                    break;
                case 5:
                    // Go Back To Menu
                    break;
                default:
                    System.out.println("Choice must be a value between 1 and 5.");
            }
        } while (choiceentry != 5);

    }

    // Here We Connect Th Sql Queries From Database
    public static void showOptionSwitchMenu() {

        int choiceentry;

        do {
            System.out.println("Enter \"1\", \"2\", \"3\", \"4\", \"5\", \"6\", \"7\", \"8\", \"9\" or \"10\"");
            choiceentry = x.ScanForInt();

            switch (choiceentry) {
                case 1:
                    // A list of all the students
                    break;
                case 2:
                    //  A list of all the trainers
                    break;
                case 3:
                    // A list of all the assignments
                    break;
                case 4:
                    // A list of all the courses
                    break;
                case 5:
                    // A list of all students per course
                    break;
                case 6:
                    //  A list of all trainers per course
                    break;
                case 7:
                    // A list of all assignments per course
                    break;
                case 8:
                    // A list of all  assignments per student
                    break;
                case 9:
                    // A list of all students that belong to more than one courses
                    break;
                case 10:
                    // go Back
                    break;
                default:
                    System.out.println("Choice must be a value between 1 and 10.");
            }
        } while (choiceentry != 4);

    }

    public static void createStudent() {
        String name;
        String lastname;
        LocalDate date;
        double tuitionFees;
        boolean repeat = true;
        String answer = "";

        while (repeat == true) {

            x.QueL("Enter the name of the student : ");
            name = x.ScanForString();
            x.QueL("Enter the last name of student : ");
            lastname = x.ScanForString();
            x.QueL("Enter the birth date of student [ dd/M/yyyy ] : ");
            date = x.ScanForDate();
            x.QueL("Enter the tuitionFees of the student : ");
            tuitionFees = x.ScanForDouble();
            //////Creating Object////////////////////////////////

            Student student = createObjectStudent(name, lastname, date, tuitionFees);
            /////////Add To ArrayList And To Database///////////////////////////////

            x.getListOfStudents().add(student);
            insertStudentToDatabase(student);

            /////////Ask If He Wants To Add More Students////////////
            System.out.println("----------------------------------------");

            repeat = x.chooseYesOrNo();
        }
        System.out.println("\n");
        createOptionSwitchMenu();
    }

    public static void createTrainer() {

        String name;
        String lastname;
        String subject;
        boolean repeat = true;
        String answer = "";

        while (repeat == true) {

            x.QueL("Enter the name of the trainer : ");
            name = x.ScanForString();
            x.QueL("Enter the last name of trainer : ");
            lastname = x.ScanForString();
            x.QueL("Enter the subject of trainer : ");
            subject = x.ScanForString();
            //////Creating Object////////////////////////////////

            Trainer trainer = createObjectTrainer(lastname, lastname, answer);
            /////////Add To ArrayList///////////////////////////////

            x.getListOfTrainers().add(trainer);
            insertTrainerToDatabase(trainer);

            /////////Ask If He Wants To Add More Trainer////////////
            System.out.println("----------------------------------------");

            repeat = x.chooseYesOrNo();
        }
        System.out.println("\n");
        createOptionSwitchMenu();

    }

    public static void createAssignment() {

        String title;
        String description;
        LocalDate subDateTime;
        double oralMark;
        double totalMark;
        boolean repeat = true;
        String answer = "";

        while (repeat == true) {

            x.QueL("Enter the title of the assignment : ");
            title = x.ScanForString();
            x.QueL("Enter the description of assignment : ");
            description = x.ScanForString();
            x.QueL("Enter the subDateTime of assignment : ");
            subDateTime = x.ScanForDate();
            x.QueL("Enter the oral Mark of assignment : ");
            oralMark = x.ScanForDouble();
            x.QueL("Enter the total Mark of assignment : ");
            totalMark = x.ScanForDouble();
            //////Creating Object////////////////////////////////

            Assignment assignment = createObjectAssignment(title, description, subDateTime, oralMark, totalMark);
            /////////Add To ArrayList///////////////////////////////

            x.getListOfAssignments().add(assignment);
            insertAssignmentToDatabase(assignment);

            /////////Ask If He Wants To Add More assignment////////////
            System.out.println("----------------------------------------");

            repeat = x.chooseYesOrNo();
        }
        System.out.println("\n");
        createOptionSwitchMenu();

    }

    public static void createCourse() {

        String title;
        String stream;
        String type;
        LocalDate start_Date;
        LocalDate end_Date;
        boolean repeat = true;
        String answer = "";

        while (repeat == true) {

            x.QueL("Enter the title of the course : ");
            title = x.ScanForString();
            x.QueL("Enter the stream of course : ");
            stream = x.ScanForString();
            x.QueL("Enter the type of course : ");
            type = x.ScanForString();
            x.QueL("Enter the starting date of course : ");
            start_Date = x.ScanForDate();
            x.QueL("Enter the ending date of course : ");
            end_Date = x.ScanForDate();

            //////Creating Object////////////////////////////////
            Course course = createObjectCourse(title, stream, type, start_Date, end_Date);
            /////////Add To ArrayList///////////////////////////////

            x.getListOfCourses().add(course);
            insertCourseToDatabase(course);

            /////////Ask If He Wants To Add More course////////////
            System.out.println("----------------------------------------");

            repeat = x.chooseYesOrNo();
        }
        System.out.println("\n");
        createOptionSwitchMenu();

    }

    private static Student createObjectStudent(String name, String lastname, LocalDate dateofBirth, double tuitionFees) {

        Student student = new Student(name, lastname, dateofBirth, tuitionFees);

        return (student);
    }

    private static Trainer createObjectTrainer(String firstName, String lastName, String subject) {

        Trainer trainer = new Trainer(firstName, lastName, subject);
        return (trainer);
    }

    private static Assignment createObjectAssignment(String title, String description, LocalDate subDueDate, double oralMark, double totalMark) {

        Assignment assignment = new Assignment(title, description, subDueDate, oralMark, totalMark);
        return (assignment);

    }

    private static Course createObjectCourse(String title, String stream, String type, LocalDate start_Date, LocalDate end_Date) {

        Course course = new Course(title, stream, type, start_Date, end_Date);
        return (course);

    }

    private static void insertStudentToDatabase(Student student) {

        Database db = x.getDb();
        Connection conn = db.createConnection();

        String query = "INSERT INTO `bootcamp`.`students` (`fname`,`lname`,`dob`,`tfees`)"
                + "values (?,?,?,?);";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());
            preparedStatement.setDate(3, Date.valueOf(student.getDateOfBirth()));
            preparedStatement.setDouble(4, student.getTuitionFees());

            preparedStatement.execute();

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(ProjectIndividualPartB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void insertCourseToDatabase(Course course) {

        Database db = x.getDb();
        Connection conn = db.createConnection();

        String query = "INSERT INTO `bootcamp`.`courses` (`title`,`stream`,`type`,`start_date`,`start_date`)"
                + "values (?,?,?,?,?);";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, course.getTitle());
            preparedStatement.setString(2, course.getStream());
            preparedStatement.setString(3, course.getType());
            preparedStatement.setDate(4, Date.valueOf(course.getStart_Date()));
            preparedStatement.setDate(5, Date.valueOf(course.getEnd_Date()));

            preparedStatement.execute();

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(ProjectIndividualPartB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private static void insertAssignmentToDatabase(Assignment assignment) {

        Database db = x.getDb();
        Connection conn = db.createConnection();

        String query = "INSERT INTO `bootcamp`.`assignments` (`title`,`description`,`subDateTime`,`oralMark`,`totalMark`)"
                + "values (?,?,?,?,?);";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, assignment.getTitle());
            preparedStatement.setString(2, assignment.getDescription());
            preparedStatement.setDate(3, Date.valueOf(assignment.getSubDateTime()));
            preparedStatement.setDouble(4, assignment.getOralMark());
            preparedStatement.setDouble(5, assignment.getTotalMark());

            preparedStatement.execute();

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(ProjectIndividualPartB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void insertTrainerToDatabase(Trainer trainer) {

        Database db = x.getDb();
        Connection conn = db.createConnection();

        String query = "INSERT INTO `bootcamp`.`trainers` (`fname`,`lname`,`subject`)"
                + "values (?,?,?);";

        try {
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1, trainer.getFirstName());
            preparedStatement.setString(2, trainer.getLastName());
            preparedStatement.setString(3, trainer.getSubject());

            preparedStatement.execute();

            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(ProjectIndividualPartB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
    
    
}
