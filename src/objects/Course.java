/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.time.LocalDate;

/**
 *
 * @author User
 */
public class Course {
     private String title;
    private String stream;
    private String type;
    private LocalDate start_Date;
    private LocalDate end_Date;

    ///////////////////////////// [ GETTERS / SETTERS ] /////////////////////////////

    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getStart_Date() {
        return start_Date;
    }

    public void setStart_Date(LocalDate start_Date) {
        this.start_Date = start_Date;
    }

    public LocalDate getEnd_Date() {
        return end_Date;
    }

    public void setEnd_Date(LocalDate end_Date) {
        this.end_Date = end_Date;
    }

///////////////////////////// [ CONSTRUCTORS ] /////////////////////////////
    
    public Course(String title, String stream, String type, LocalDate start_Date, LocalDate end_Date) {
        this.title = title;
        this.stream = stream;
        this.type = type;
        this.start_Date = start_Date;
        this.end_Date = end_Date;
    }

    public Course() {
    }
    
    ///////////////////////////// [ TOSTRING ] /////////////////////////////


    @Override
    public String toString() {
        return "Course{" + "title=" + title + ", stream=" + stream + ", type=" + type + ", start_Date=" + start_Date + ", end_Date=" + end_Date + '}';
    }
    
    
    
}

