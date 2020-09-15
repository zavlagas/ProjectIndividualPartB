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

    private Assignment assignment;
    private StudentEnrollment student;
    private Tools x = new Tools();
    private Database db = x.getDb();

    public EnrollmentAssignment() {

    }

    public EnrollmentAssignment(Assignment assignment, StudentEnrollment student) {
        this.assignment = assignment;
        this.student = student;
        createProcedureForCourseAndTrainerInsideToTrainerEnrollment();
        callProcedureEnrollmentStudentInsert(assignment, student);

    }

    //////////////Database Connection Student with StudentEnrollment Which Host One Enrollment Id And Student Id/////////////////////
    public void createProcedureForCourseAndTrainerInsideToTrainerEnrollment() {
        String procedureName = "enrollmentTrainerInsert";
        
        db.clearProceduresFromDatabase(procedureName);
        /////Create The Procedure To String ////////
        String procedure = "CREATE PROCEDURE "+procedureName+" (IN `inputfname` VARCHAR(40),IN `inputlname` VARCHAR(40),IN `inputsubject`  VARCHAR(40) ,IN `inputtitle`  VARCHAR(40))\n"
                + "    BEGIN\n"
                + "    INSERT INTO `zavibootcamp`.`trainerenrollment` (`enid`,`tid`) \n"
                + "    VALUES ((SELECT `enrollment`.`id` FROM `zavibootcamp`.`enrollment`\n"
                + "    INNER JOIN `zavibootcamp`.`courses` ON `enrollment`.`cid` = `courses`.`id`\n"
                + "    WHERE `courses`.`title` = `inputtitle`),(SELECT `trainers`.`id` FROM `zavibootcamp`.`trainers` where `fname` = `inputfname`AND `lname` =`inputlname`AND `subject` = `inputsubject`));\n"
                + "    END";

        ///   Create Procedure to database  //////////
        db.createProcedureToDatabase(procedure);
    }

    public void callProcedureEnrollmentStudentInsert(Assignment assignment, StudentEnrollment student) {

        try {
            Connection conn = db.createConnection();
            CallableStatement callableStatement = conn.prepareCall("{CALL `enrollmentTrainerInsert` (?,?,?,?)}");
            //// Setting values ////
            callableStatement.setString(1, trainer.getFirstName());
            callableStatement.setString(2, trainer.getLastName());
            callableStatement.setString(3,trainer.getSubject());
            callableStatement.setString(4, course.getTitle());

            callableStatement.execute();
            callableStatement.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(EnrollmentAssignment.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Trainer getTrainer() {
        return (trainer);
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    @Override
    public String toString() {
        return "TrainerEnrollment{" + "course=" + course + ", trainer=" + trainer + '}';
    }

}
