/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import java.sql.ResultSet;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import modelsconnection.Database;
import objects.Assignment;
import objects.Course;
import objects.Student;
import objects.Trainer;

/**
 *
 * @author User
 */
public final class Tools {

    private List<Student> listOfStudents = new ArrayList();
    private List<Trainer> listOfTrainers = new ArrayList();
    private List<Assignment> listOfAssignments = new ArrayList();
    private List<Course> listOfCourses = new ArrayList();
    private Database db;
    private Scanner scan = new Scanner(System.in);

    public Tools() {
        setScan();
        setDb();
    }

    /////////////////////////////GET LISTS /////////////////////////////
    public List<Student> getListOfStudents() {
        return listOfStudents;
    }

    public List<Trainer> getListOfTrainers() {
        return listOfTrainers;
    }

    public List<Assignment> getListOfAssignments() {
        return listOfAssignments;
    }

    public List<Course> getListOfCourses() {
        return listOfCourses;
    }

    ///////////////////////////Set and Connect To Database//////////////////
    public Database getDb() {
        return db;
    }

    private void setDb() {
        this.db = new Database("localhost", "3306", "bootcamp", "root", "1234");

    }
    
    public  ResultSet executeQuery(String sql) {
        
        ResultSet rs = null;
        rs = db.connectAndExecuteQuery(sql);
        return (rs);
    }

    /////////////////////////////String/////////////////////////////
    public void QueL(String question) {

        System.out.print(question);
    }

    public void QueNL(String question) {

        System.out.println(question);
    }

    /////////////////////////////Scanner /////////////////////////////
    public void setScan() {
        getScan().useDelimiter("\\n");

    }

    public Scanner getScan() {
        return scan;
    }

    public int ScanForInt() {
        int number;
        do {
            while (!getScan().hasNextInt()) {
                System.out.println("That's not a number! Try Again ");
                getScan().next(); // this is important!
            }
            number = getScan().nextInt();
            if (number < 0) {
                System.out.println("Please enter a positive number! Try Again");
            }
        } while (number <= 0);
        return (number);
    }

    public double ScanForDouble() {
        double number;
        do {
            while (!getScan().hasNextDouble()) {
                System.out.println("That's not a number! Try Again ");
                getScan().next(); // this is important!
            }
            number = getScan().nextDouble();
            if (number < 0) {
                System.out.println("Please enter a positive number! Try Again");
            }
        } while (number <= 0);
        return (number);
    }

    public String ScanForString() {
        String answer = getScan().nextLine();
        return (answer);
    }

    public LocalDate ScanForDate() {
        boolean exit = false;
        boolean validate = true;
        LocalDate date = null;
        String dateFromString;
        String pattern = "dd/M/yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        dateFromString = ScanForString();
        do {

            validate = validateLocalDate(dateFromString, formatter);

            if (validate == false) {

                System.out.println("That's not a Date! Try Again With This Pattern [dd/M/yyyy] ");
                dateFromString = getScan().next(); // this is important!

            } else if (validate == true) {

                date = LocalDate.parse(dateFromString, formatter);
                exit = true;

            }

        } while (exit == false);
        return (date);
    }

    public void closeScan() {
        this.scan.close();
    }
    /////////////////////////////DATE  /////////////////////////////

    public static boolean validateLocalDate(String dateFromString, DateTimeFormatter formatter) {
        LocalDate date = null;
        boolean validate = true;
        try {
            date = LocalDate.parse(dateFromString, formatter);
        } catch (DateTimeParseException e) {
            validate = false;
        }
        return validate;
    }

    ///////////////////////////// READ THE ArrayLISTS /////////////////////////////
    public void loopTheList(List x) {

        for (Object object : x) {
            System.out.println(object);
        }

    }
    ///////////////////////////// REPEAT METHODS  /////////////////////////////

    public Boolean chooseYesOrNo() {

        QueNL("Do you want to add more [YES / NO] :");

        while (true) {

            String answer = ScanForString();
            if ((answer.contains("YES")) || (answer.contains("Yes")) || (answer.contains("yes")) || (answer.contains("y")) || (answer.contains("Y"))) {

                return (true);

            } else if ((answer.contains("NO")) || (answer.contains("No")) || (answer.contains("no")) || (answer.contains("N")) || (answer.contains("n"))) {

                return (false);

            }

        }

    }

}
