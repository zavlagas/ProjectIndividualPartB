/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelsconnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import objects.Course;
import projectindividualpartb.ProjectIndividualPartB;
import tools.Tools;

/**
 *
 * @author User
 */
public final class Enrollment {

    Course course;
    Tools x = new Tools();
    Database db = x.getDb();

    public Enrollment() {

    }

    public Enrollment(Course course) {

        this.course = course;
        createProcedureForCourseInsideToEnrollment();
        callProcedureForCourseInsideToEnrollment(course);

    }

    public void setCourse(Course course) {
        this.course = course;
      
    }

    public Course getCourse() {

        return (this.course);

    }

    //////////////Database Connection Enrollment with course/////////////////////
    public void createProcedureForCourseInsideToEnrollment() {
        ///        Drop Procedure First          ///////
        String procedureName = "findCourseIdFromTitle";
        
        db.clearProceduresFromDatabase(procedureName);

        /////Create The Procedure To String ////////
        String procedure = "CREATE PROCEDURE "+procedureName+" (in `inputtitle` VARCHAR(40))\n"
                + "    BEGIN"
                + "    INSERT INTO `zavibootcamp`.`enrollment` (`cid`) \n"
                + "    VALUES ((SELECT `id` from `zavibootcamp`.`courses`\n"
                + "    where `title` = `inputtitle`));\n"
                + "    END ";

        ///   Create Procedure to database  //////////
        db.createProcedureToDatabase(procedure);
    }

    public void callProcedureForCourseInsideToEnrollment(Course course) {

        try {
            Connection conn = db.createConnection();
            CallableStatement callableStatement = conn.prepareCall("{CALL `findCourseIdFromTitle` (?)}");
            //// Setting values ////
            callableStatement.setString(1, course.getTitle());

            callableStatement.execute();
            callableStatement.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Enrollment.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String toString() {
        return "Enrollment{" + "course=" + course + '}';
    }

}
