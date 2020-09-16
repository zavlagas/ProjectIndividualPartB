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
import objects.Trainer;
import projectindividualpartb.ProjectIndividualPartB;
import tools.Tools;

/**
 *
 * @author User
 */
public final class TrainerEnrollment {

    private int numberId;
    private Trainer trainer;
    private Tools x = new Tools();
    private Database db = x.getDb();

    public TrainerEnrollment() {

    }

    public TrainerEnrollment(Trainer trainer, int numberId) {
        this.trainer = trainer;
        this.numberId = numberId;
        createProcedureForCourseAndTrainerInsideToTrainerEnrollment();
        callProcedureEnrollmentStudentInsert(trainer, numberId);

    }

    //////////////Database Connection Student with StudentEnrollment Which Host One Enrollment Id And Student Id/////////////////////
    public void createProcedureForCourseAndTrainerInsideToTrainerEnrollment() {
        String procedureName = "enrollmentTrainerInsert";

        db.clearProceduresFromDatabase(procedureName);
        /////Create The Procedure To String ////////
        String procedure = "CREATE PROCEDURE " + procedureName + " (IN `inputfname` VARCHAR(40),IN `inputlname` VARCHAR(40),IN `inputsubject`  VARCHAR(40) ,IN `inputcourseid` INT)\n"
                + "    BEGIN\n"
                + "    INSERT INTO `zavibootcamp`.`trainerenrollment` (`enid`,`tid`) \n"
                + "    VALUES ((SELECT `enrollment`.`id` FROM `zavibootcamp`.`enrollment`\n"
                + "    INNER JOIN `zavibootcamp`.`courses` ON `enrollment`.`cid` = `courses`.`id`\n"
                + "    WHERE `courses`.`id` = `inputcourseid`),(SELECT `trainers`.`id` FROM `zavibootcamp`.`trainers` where `fname` = `inputfname`AND `lname` =`inputlname`AND `subject` = `inputsubject`));\n"
                + "    END";

        ///   Create Procedure to database  //////////
        db.createProcedureToDatabase(procedure);
    }

    public void callProcedureEnrollmentStudentInsert(Trainer trainer, int number) {

        try {
            Connection conn = db.createConnection();
            CallableStatement callableStatement = conn.prepareCall("{CALL `enrollmentTrainerInsert` (?,?,?,?)}");
            //// Setting values ////
            callableStatement.setString(1, trainer.getFirstName());
            callableStatement.setString(2, trainer.getLastName());
            callableStatement.setString(3, trainer.getSubject());
            callableStatement.setInt(4, number);

            callableStatement.execute();
            callableStatement.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(TrainerEnrollment.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Trainer getTrainer() {
        return (trainer);
    }

    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public int getNumberId() {
        return numberId;
    }

    public void setNumberId(int numberId) {
        this.numberId = numberId;
    }

    @Override
    public String toString() {
        return "TrainerEnrollment{" + "numberId=" + numberId + ", trainer=" + trainer + '}';
    }

}
