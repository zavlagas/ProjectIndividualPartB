/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectindividualpartb;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import objects.Student;
import tools.Tools;

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
            System.out.println("Enter \"1\", \"2\", \"3\" or \"4\"");
            choiceentry = x.ScanForInt();

            switch (choiceentry) {
                case 1:
                    // You Want To Create Student
                    break;
                case 2:
                    // You Want To Insert To Course (Students,Assignments,Trainers) 
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
            System.out.println("Enter \"1\", \"2\", \"3\", \"4\" or \"5\"");
            choiceentry = x.ScanForInt();

            switch (choiceentry) {
                case 1:
                    // Create A Student
                    break;
                case 2:
                    //  Create Trainer
                    break;
                case 3:
                    // Create assignment
                    break;
                case 4:
                    // Create course
                    break;
                case 5:
                    // go Back
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
        Boolean repeat = false;
        String answer;

        do {

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
            /////////Add To ArrayList///////////////////////////////

            x.getListOfStudents().add(student);

            /////////Ask If He Wants To Add More Students////////////
            System.out.println("----------------------------------------");
            System.out.println("Do you want to add Student [YES / NO]");
            answer = x.ScanForString();
            repeat = x.repeaterMethod(answer, repeat);
            do {
                
                if (repeat == null) {
                    System.out.println("That's not a Answer! Try Again With This Options [YES / NO] :");
                    answer = x.ScanForString();
                }else if (repeat == false){
                    System.out.println("\n");
                    System.out.println("Back To [CREATE] menu ");
                    startingSwitchMenu();
                }

                repeat = x.repeaterMethod(answer, repeat);

            } while (repeat == null);
        } while (repeat == true);
    }

    private static Student createObjectStudent(String name, String lastname, LocalDate dateofBirth, double tuitionFees) {

        Student student = new Student(name, lastname, dateofBirth, tuitionFees);

        return (student);
    }

}
