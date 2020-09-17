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
public class Student {
   private String firstName;
   private String lastName;
   private LocalDate dateOfBirth;
   private double tuitionFees;
   
   ///////////////////////////// [ GETTERS / SETTERS ] /////////////////////////////

       public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(double tuitionFees) {
        this.tuitionFees = tuitionFees;
    }

    
    
    ///////////////////////////// [ CONSTRUCTORS ] /////////////////////////////

  public Student() {
    }

    public Student(String firstName, String lastName, LocalDate dateOfBirth, double tuitionFees) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.tuitionFees = tuitionFees;
    }

 
  

    ///////////////////////////// [ TOSTRING ] /////////////////////////////

    @Override
    public String toString() {
        return "The Student{" + "firstName : " + firstName + ", lastName : " + lastName + ", dateOfBirth :" + dateOfBirth + '}';
    }

   

  
    
           
}
