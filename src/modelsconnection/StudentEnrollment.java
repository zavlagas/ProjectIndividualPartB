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
import objects.Course;
import objects.Student;
import projectindividualpartb.ProjectIndividualPartB;
import tools.Tools;

/**
 *
 * @author User
 */
public final class StudentEnrollment {

    private Student student;
    private int numberId;
    private Tools x = new Tools();
    private Database db = x.getDb();

    public StudentEnrollment() {

    }

    public StudentEnrollment(Student student, int numberId) {
        this.student = student;
        this.numberId = numberId;
        createProcedureForCourseAndStudentInsideToStudentEnrollment();
        callProcedureEnrollmentStudentInsert(student, numberId);

    }

    //////////////Database Connection Student with StudentEnrollment Which Host One Enrollment Id And Student Id/////////////////////
    public void createProcedureForCourseAndStudentInsideToStudentEnrollment() {
        String procedureName = "enrollmentStudentInsert";

        db.clearProceduresFromDatabase(procedureName);
        /////Create The Procedure To String ////////
        String procedure = "CREATE PROCEDURE " + procedureName + " (IN `inputfname` VARCHAR(40),IN `inputlname` VARCHAR(40),IN `inputdob` DATE ,IN `inputcourseid` INT)\n"
                + "    BEGIN\n"
                + "    INSERT INTO `zavibootcamp`.`studentenrollment` (`enid`,`sid`) \n"
                + "    VALUES ((SELECT `enrollment`.`id` FROM `zavibootcamp`.`enrollment`\n"
                + "    INNER JOIN `zavibootcamp`.`courses` ON `enrollment`.`cid` = `courses`.`id`\n"
                + "    WHERE `courses`.`id` = `inputcourseid`),(SELECT `students`.`id` FROM `zavibootcamp`.`students` where `fname` = `inputfname` AND `lname` =`inputlname` AND `dob` = `inputdob`));\n"
                + "    END";

        ///   Create Procedure to database  //////////
        db.createProcedureToDatabase(procedure);
    }

    public void callProcedureEnrollmentStudentInsert(Student student, int number) {

        try {
            Connection conn = db.createConnection();
            CallableStatement callableStatement = conn.prepareCall("{CALL `enrollmentStudentInsert` (?,?,?,?)}");
            //// Setting values ////
            callableStatement.setString(1, student.getFirstName());
            callableStatement.setString(2, student.getLastName());
            callableStatement.setDate(3, Date.valueOf(student.getDateOfBirth()));
            callableStatement.setInt(4, number);

            callableStatement.execute();
            callableStatement.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(StudentEnrollment.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getNumberId() {
        return numberId;
    }

    public void setNumberId(int numberId) {
        this.numberId = numberId;
    }

    @Override
    public String toString() {
        return "StudentEnrollment{" + "student=" + student + ", numberId=" + numberId + '}';
    }

}
