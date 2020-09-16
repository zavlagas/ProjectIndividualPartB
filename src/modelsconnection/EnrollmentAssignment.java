/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelsconnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import objects.Assignment;
import objects.Course;
import objects.Student;
import objects.Trainer;
import projectindividualpartb.ProjectIndividualPartB;
import tools.Tools;

/**
 *
 * @author User
 */
public final class EnrollmentAssignment {

    private Student student;
    private int assignmentId;
    private double omark;
    private double tmark;
    private Tools x = new Tools();
    private Database db = x.getDb();

    public EnrollmentAssignment() {

    }

    public EnrollmentAssignment(Student student, int assignmentId, double omark, double tmark) {

        this.student = student;
        this.assignmentId = assignmentId;
        this.omark = omark;
        this.tmark = tmark;
        createProcedureForEnrollStudentAndAndAssignmentToEnrollAssignment();
        callProcedureEnrollmentAssignementInsert(student, assignmentId, omark, tmark);
    }

    //////////////Database Connection Student with StudentEnrollment Which Host One Enrollment Id And Student Id/////////////////////
    public void createProcedureForEnrollStudentAndAndAssignmentToEnrollAssignment() {
        String procedureName = "enrollmentAssignmentInsert";

        db.clearProceduresFromDatabase(procedureName);
        /////Create The Procedure To String ////////
        String procedure = "CREATE PROCEDURE " + procedureName + " (IN `inputfname`  VARCHAR(40) , IN `inputlname` VARCHAR(40) , IN `inputdob` DATE ,IN `inputassignmentsId` INT , IN `inputStudentomark` DECIMAL(4,2) ,IN `inputStudenttmark` DECIMAL(4,2))"
                + "    BEGIN\n"
                + "    INSERT INTO `zavibootcamp`.`enrollmentassignment` (`seid`,`asid`,`omark`,`tmark`)\n"
                + "    VALUES ((SELECT `studentenrollment`.`id` FROM `zavibootcamp`.`studentenrollment`\n"
                + "    INNER JOIN `zavibootcamp`.`students` ON `studentenrollment`.`sid` = `students`.`id`\n"
                + "    WHERE `students`.`fname` = `inputfname` AND `students`.`lname` = `inputlname` AND `students`.`dob` = `inputdob`),(SELECT `assignments`.`id` FROM `zavibootcamp`.`assignments` WHERE `assignments`.`id` = `inputassignmentsId`),inputStudentomark ,inputStudenttmark);\n"
                + "    END";

        ///   Create Procedure to database  //////////
        db.createProcedureToDatabase(procedure);
    }

    public void callProcedureEnrollmentAssignementInsert(Student student, int assignmentId, double omark, double tmark) {

        try {
            Connection conn = db.createConnection();
            CallableStatement callableStatement = conn.prepareCall("{CALL `enrollmentAssignmentInsert` (?,?,?,?,?,?)}");
            //// Setting values ////
            callableStatement.setString(1,student.getFirstName());
            callableStatement.setString(2,student.getLastName());
            callableStatement.setDate(3,Date.valueOf(student.getDateOfBirth()));
            callableStatement.setInt(4,assignmentId);
            callableStatement.setDouble(5,omark);
            callableStatement.setDouble(6,tmark);
            callableStatement.execute();
            callableStatement.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(EnrollmentAssignment.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public double getOmark() {
        return omark;
    }

    public void setOmark(double omark) {
        this.omark = omark;
    }

    public double getTmark() {
        return tmark;
    }

    public void setTmark(double tmark) {
        this.tmark = tmark;
    }

    @Override
    public String toString() {
        return "EnrollmentAssignment{" + "student=" + student + ", assignmentId=" + assignmentId + ", omark=" + omark + ", tmark=" + tmark + '}';
    }

}
