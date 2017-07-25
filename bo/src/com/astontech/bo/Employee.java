package com.astontech.bo;

import java.util.Date;

/**
 * Created by Logan.Moen on 5/30/2017.
 */
public class Employee extends Person{

    //Parameters

    private int EmployeeId;
    private Date HireDate;
    private Date TermDate;
    private Date CreateDate;
    private int PersonId;
    private EmployeeProject Project;
    private Review Review;
    private Training Training;

    //Constructors

    public Employee() {
        this.setProject(new EmployeeProject());
        this.setReview(new Review());
        this.setTraining(new Training());
    }

    public Employee(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public Employee(int employeeId, String firstName) {
        this.setFirstName (firstName);
    }

    public Employee(String lastName) {
        this.setLastName (lastName);
    }

    //Getters Setters
    public void setEmployeeId(int employeeId) {this.EmployeeId = employeeId;}

    public int getEmployeeId() {return this.EmployeeId;}

    public void setHireDate(Date hireDate) {this.HireDate = hireDate;}

    public Date getHireDate() {return this.HireDate;}

    public void setTermDate(Date termDate) {this.TermDate = termDate;}

    public Date getTermDate() {return this.TermDate;}

    public EmployeeProject getProject() {
        return Project;
    }

    public void setProject(EmployeeProject project) {
        Project = project;
    }

    public Review getReview() {
        return Review;
    }

    public void setReview(Review review) {
        Review = review;
    }

    public Training getTraining() {
        return Training;
    }

    public void setTraining(Training training) {
        Training = training;
    }
    @Override
    public Date getCreateDate() {
        return CreateDate;
    }
    @Override
    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }


    @Override
    public int getPersonId() {
        return PersonId;
    }

    @Override
    public void setPersonId(int personId) {
        PersonId = personId;
    }
}
