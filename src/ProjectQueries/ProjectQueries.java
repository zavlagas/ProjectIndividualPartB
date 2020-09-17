/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjectQueries;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelsconnection.Database;
import tools.Tools;

/**
 *
 * @author User
 */
public class ProjectQueries {

    private Tools x = new Tools();
    private Database db = x.getDb();

    public void callListOfStudents() {
        Connection conn = db.createConnection();
        ResultSet rs;
        try {
            CallableStatement callableStatement = conn.prepareCall("{listOfStudents()}");
            rs = callableStatement.executeQuery();
            while (rs.next()) {

                System.out.println("Id: " + rs.getString(1)
                        + "\tFirst Name: " + rs.getString(2)
                        + "\tLast Name: " + rs.getString(3));                           ////DONE
            }
            rs.close();
            callableStatement.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectQueries.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void callListOftrainers() {
        Connection conn = db.createConnection();
        ResultSet rs;
        try {
            CallableStatement callableStatement = conn.prepareCall("{listOfTrainers()}");
            rs = callableStatement.executeQuery();
            while (rs.next()) {

                System.out.println("Id: " + rs.getString(1) // DONE
                        + "\tFirst Name: " + rs.getString(2)
                        + "\tLast Name: " + rs.getString(3));
            }
            rs.close();
            callableStatement.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void callListOfAssignments() {
        Connection conn = db.createConnection();
        ResultSet rs;
        try {
            CallableStatement callableStatement = conn.prepareCall("{listOfAssignments()}");
            rs = callableStatement.executeQuery();
            while (rs.next()) {

                System.out.println("Id: " + rs.getString(1) /// DONE
                        + "\tFirst Name: " + rs.getString(2)
                        + "\tLast Name: " + rs.getString(3));
            }
            rs.close();
            callableStatement.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void callListOfCourses() {
        Connection conn = db.createConnection();
        ResultSet rs;
        try {
            CallableStatement callableStatement = conn.prepareCall("{listOfCourses()}");
            rs = callableStatement.executeQuery();
            while (rs.next()) {

                System.out.println("Id: " + rs.getString(1) // DONE
                        + "\tFirst Name: " + rs.getString(2)
                        + "\tLast Name: " + rs.getString(3));
            }
            rs.close();
            callableStatement.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void callListStudentsPerCourse(int number) {
        Connection conn = db.createConnection();
        ResultSet rs;
        try {
            CallableStatement callableStatement = conn.prepareCall("{listOfStudentsPerCourse(?)}");
            callableStatement.setInt(1, number);
            //callableStatement.execute();
            rs = callableStatement.executeQuery();
            /// DONE
            while (rs.next()) {

                System.out.println("Id: " + rs.getString(1)
                        + "\tFirst Name: " + rs.getString(2)
                        + "\tLast Name: " + rs.getString(3));
            }
            rs.close();
            callableStatement.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void callListTrainersPerCourse(int number) {
        Connection conn = db.createConnection();
        ResultSet rs;
        try {
            CallableStatement callableStatement = conn.prepareCall("{listOfTrainersPerCourse(?)}");
            callableStatement.setInt(1, number);
            //callableStatement.execute();
            rs = callableStatement.executeQuery();
            /// DONE
            while (rs.next()) {

                System.out.println("Id: " + rs.getString(1)
                        + "\tFirst Name: " + rs.getString(2)
                        + "\tLast Name: " + rs.getString(3));
            }
            rs.close();
            callableStatement.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void callListAssignmentsPerCourse(int number) {
        Connection conn = db.createConnection();
        ResultSet rs;
        try {
            CallableStatement callableStatement = conn.prepareCall("{listOfAssignmentsPerCourse(?)}");
            callableStatement.setInt(1, number);
            //callableStatement.execute();
            rs = callableStatement.executeQuery();

            while (rs.next()) {                                                          /// DONE

                System.out.println("Id: " + rs.getString(1)
                        + "\tFirst Name: " + rs.getString(2)
                        + "\tLast Name: " + rs.getString(3));
            }
            rs.close();
            callableStatement.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void callListAssignmentsPerStudentPerCourse(int number) {
        Connection conn = db.createConnection();
        ResultSet rs;
        try {
            CallableStatement callableStatement = conn.prepareCall("{listOfAssignmentsPerStudentPerCourse(?)}");
            callableStatement.setInt(1, number);
            //callableStatement.execute();
            rs = callableStatement.executeQuery();

            while (rs.next()) {                                                 ////Done 

                System.out.println("Id: " + rs.getString(1)
                        + "\tFirst Name: " + rs.getString(2)
                        + "\tLast Name: " + rs.getString(3));
            }
            rs.close();
            callableStatement.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void callListAssignmentsPerStudentsWithMoreThanOneCourse() {
        Connection conn = db.createConnection();
        ResultSet rs;
        try {
            CallableStatement callableStatement = conn.prepareCall("{listOfStudentsMultiEnrolled()}");
            rs = callableStatement.executeQuery();
            while (rs.next()) {

                System.out.println("Id: " + rs.getString(1)
                        + "\tFirst Name: " + rs.getString(2) ///////DONE
                        + "\tLast Name: " + rs.getString(3));
            }
            rs.close();
            callableStatement.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ProjectQueries.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void createStoredProcedureForPrintingLists(String procedureName, String procedureQuery, String... pars) {
        StringBuilder sb = new StringBuilder();
        String stringpars = Arrays.toString(pars);
        if (pars.length == 0) {
            sb.append("CREATE PROCEDURE ").append(procedureName).append("(").append(")\n").append("BEGIN\n").append(procedureQuery).append("\n").append("END");

        } else {
            sb.append("CREATE PROCEDURE ").append(procedureName).append("(");

            for (String par : pars) {
                sb.append(par);
            }
            sb.append(")\n").append("BEGIN\n").append(procedureQuery).append("\n").append("END");
        }
        String procedure = sb.toString();

        db.createProcedureToDatabase(procedure);

    }

    public void createQuerieForListOfStudents() {
        String procedureName = "listOfStudents";
        String procedureQuery = "SELECT * FROM `zavibootcamp`.`students`;";
        createStoredProcedureForPrintingLists(procedureName, procedureQuery);

    }

    public void createQuerieForListOfTrainers() {
        String procedureName = "listOfTrainers";
        String procedureQuery = "SELECT * FROM `zavibootcamp`.`trainers`;";
        createStoredProcedureForPrintingLists(procedureName, procedureQuery);

    }

    public void createQuerieForListOfCourses() {
        String procedureName = "listOfCourses";
        String procedureQuery = "SELECT * FROM `zavibootcamp`.`courses`;";
        createStoredProcedureForPrintingLists(procedureName, procedureQuery);

    }

    public void createQuerieForListOfAssignments() {
        String procedureName = "listOfAssignments";
        String procedureQuery = "SELECT * FROM `zavibootcamp`.`assignments`;";
        createStoredProcedureForPrintingLists(procedureName, procedureQuery);

    }

    public void createQuerieForListOfAssignmentsPerCourse() {
        String procedureName = "listOfAssignmentsPerCourse";
        String parametre = "IN inputCourseId VARCHAR(40)";
        String procedureQuery = "SELECT `assignments`.`id` AS ID ,`assignments`.`title` AS TITLE, `assignments`.`subdate` AS SUBDATE,`courses`.`title` AS COURSE \n"
                + "FROM `zavibootcamp`.`students`\n"
                + "INNER JOIN `zavibootcamp`.`studentenrollment` ON `students`.`id` = `studentenrollment`.`sid`\n"
                + "INNER JOIN `zavibootcamp`.`enrollment` ON `studentenrollment`.`enid` = `enrollment`.`id`\n"
                + "INNER JOIN `zavibootcamp`.`courses`  ON `enrollment`.`cid` = `courses`.`id`\n"
                + "INNER JOIN `zavibootcamp`.`enrollmentassignment` ON `studentenrollment`.`id` = `enrollmentassignment`.`seid`\n"
                + "INNER JOIN `zavibootcamp`.`assignments` ON `enrollmentassignment`.`asid` = `assignments`.`id`\n"
                + "WHERE `courses`.`id` =`inputCourseId`;";

        createStoredProcedureForPrintingLists(procedureName, procedureQuery, parametre);

    }

    public void createQuerieForListOfStudentsPerCourse() {
        String procedureName = "listOfStudentsPerCourse";
        String parametre = "IN inputCourseId VARCHAR(40)";
        String procedureQuery = "SELECT `students`.`id` AS ID ,`students`.`fname` AS FIRSTNAME, `students`.`lname` AS LASTNAME,`courses`.`title` AS COURSE \n"
                + "FROM `zavibootcamp`.`students`\n"
                + "INNER JOIN `zavibootcamp`.`studentenrollment` ON `students`.`id` = `studentenrollment`.`sid`\n"
                + "INNER JOIN `zavibootcamp`.`enrollment` ON `studentenrollment`.`enid` = `enrollment`.`id`\n"
                + "INNER JOIN `zavibootcamp`.`courses`  ON `enrollment`.`cid` = `courses`.`id`\n"
                + "WHERE `courses`.`id` = `inputCourseId`;";

        createStoredProcedureForPrintingLists(procedureName, procedureQuery, parametre);

    }

    public void createQuerieForListOfTrainersPerCourse() {
        String procedureName = "listOfTrainersPerCourse";
        String parametre = "IN inputCourseId VARCHAR(40)";
        String procedureQuery = "SELECT `trainers`.`id` AS ID ,`trainers`.`fname` AS FIRSTNAME, `trainers`.`lname` AS LASTNAME,`courses`.`title` AS COURSE \n"
                + "FROM `zavibootcamp`.`trainers`\n"
                + "INNER JOIN `zavibootcamp`.`trainerenrollment` ON `trainers`.`id` = `trainerenrollment`.`sid`\n"
                + "INNER JOIN `zavibootcamp`.`enrollment` ON `trainerenrollment`.`enid` = `enrollment`.`id`\n"
                + "INNER JOIN `zavibootcamp`.`courses`  ON `enrollment`.`cid` = `courses`.`id`\n"
                + "WHERE `courses`.`id` = `inputCourseId`;";

        createStoredProcedureForPrintingLists(procedureName, procedureQuery, parametre);

    }

    public void createQuerieForListOfAssignmentsPerStudentPerCourse() {
        String procedureName = "listOfAssignmentsPerStudentPerCourse";
        String parametre = "IN inputCourseId VARCHAR(40)";
        String procedureQuery = "SELECT `students`.`id` AS ID ,`students`.`fname` AS FIRSTNAME, `students`.`lname` AS LASTNAME,`courses`.`title` AS COURSE ,`assignments`.`title` AS ASSIGNMENTS\n"
                + "FROM `zavibootcamp`.`students`\n"
                + "INNER JOIN `zavibootcamp`.`studentenrollment` ON `students`.`id` = `studentenrollment`.`sid`\n"
                + "INNER JOIN `zavibootcamp`.`enrollment` ON `studentenrollment`.`enid` = `enrollment`.`id`\n"
                + "INNER JOIN `zavibootcamp`.`courses`  ON `enrollment`.`cid` = `courses`.`id`\n"
                + "INNER JOIN `zavibootcamp`.`enrollmentassignment` ON `studentenrollment`.`id` = `enrollmentassignment`.`seid`\n"
                + "INNER JOIN `zavibootcamp`.`assignments` ON `enrollmentassignment`.`asid` = `assignments`.`id`\n"
                + "WHERE `courses`.`id` =`inputCourseId`;";

        createStoredProcedureForPrintingLists(procedureName, procedureQuery, parametre);

    }

    public void createQuerieForStudentsMultiEnrolled() {
        String procedureName = "listOfStudentsMultiEnrolled";
        String procedureQuery = "SELECT `students`.`id` AS ID ,`students`.`fname` AS FIRSTNAME, `students`.`lname` AS LASTNAME,`courses`.`title` AS COURSE\n"
                + "FROM `zavibootcamp`.`students`\n"
                + "INNER JOIN `zavibootcamp`.`studentenrollment` ON `students`.`id` = `studentenrollment`.`sid`\n"
                + "INNER JOIN `zavibootcamp`.`enrollment` ON `studentenrollment`.`enid` = `enrollment`.`id`\n"
                + "INNER JOIN `zavibootcamp`.`courses`  ON `enrollment`.`cid` = `courses`.`id`\n"
                + "HAVING COUNT(`courses`.`id`) > 1;";
        createStoredProcedureForPrintingLists(procedureName, procedureQuery);

    }

    public void deleteAllProcedures() {

        db.clearProceduresFromDatabase("listOfStudents");
        db.clearProceduresFromDatabase("listOfTrainers");
        db.clearProceduresFromDatabase("listOfCourses");
        db.clearProceduresFromDatabase("listOfAssignments");
        db.clearProceduresFromDatabase("listOfAssignmentsPerCourse");
        db.clearProceduresFromDatabase("listOfStudentsPerCourse");
        db.clearProceduresFromDatabase("listOfTrainersPerCourse");
        db.clearProceduresFromDatabase("listOfAssignmentsPerStudentPerCourse");
        db.clearProceduresFromDatabase("listOfStudentsMultiEnrolled");

    }
}
