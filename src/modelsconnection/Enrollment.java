/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelsconnection;

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
public class Enrollment {

    Course course;
    Tools x = new Tools();
    Database db = x.getDb();

    public Enrollment() {

    }

    public Enrollment(Course course) {
        this.course = course;

    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Course getCourse() {

        return (this.course);

    }

    //////////////Database Connection Enrollment with course/////////////////////
    public void createProcedureForCourseInsideToEnrollment() {
        String procedure = "DELIMITER //\n"
                + "    CREATE PROCEDURE `findCourseIdFromTitle`(in `inputtitle` VARCHAR(40))\n"
                + "    BEGIN\n"
                + "    INSERT INTO `zavibootcamp`.`enrollment` (`cid`) \n"
                + "    VALUES ((SELECT `id` from `zavibootcamp`.`courses`\n"
                + "    where `title` = `inputtitle`));\n"
                + "    \n"
                + "    END //\n"
                + "    DELIMITER ;";
        db.createProcedureToDatabase(procedure);
    }

    public void setCourseToEnrollmentToDatabase() {

    }

    @Override
    public String toString() {
        return "Enrollment{" + "course=" + course + '}';
    }

}
