package com.astontech.bo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Logan.Moen on 5/30/2017.
 */
public class Project extends BaseBO{
    private int ProjectId;
    private int ClientId;
    private int EntityTypeId;
    private String Rate;
    private Date StartDate;
    private Date EndDate;
    private ProjectStatus Status;
    private List<Employee> Employees;

    public Project(){
        this.setStatus(new ProjectStatus());
        this.setEmployees(new ArrayList<>());
    }
    public Project(int projectId, String rate){
        this.setProjectId(projectId);
        this.setRate(rate);
    }

    public int getProjectId() {
        return ProjectId;
    }

    public void setProjectId(int projectId) {
        ProjectId = projectId;
    }

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int clientId) {
        ClientId = clientId;
    }

    public int getEntityTypeId() {
        return EntityTypeId;
    }

    public void setEntityTypeId(int entityTypeId) {
        EntityTypeId = entityTypeId;
    }

    public String getRate() {
        return Rate;
    }

    public void setRate(String rate) {
        Rate = rate;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date startDate) {
        StartDate = startDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date endDate) {
        EndDate = endDate;
    }

    public ProjectStatus getStatus() {
        return Status;
    }

    public void setStatus(ProjectStatus status) {
        Status = status;
    }

    public List<Employee> getEmployees() {
        return Employees;
    }

    public void setEmployees(List<Employee> employees) {
        Employees = employees;
    }
}
