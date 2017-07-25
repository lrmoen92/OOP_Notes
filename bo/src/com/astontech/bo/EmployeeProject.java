package com.astontech.bo;

import java.util.Date;

/**
 * Created by Logan.Moen on 5/30/2017.
 */
public class EmployeeProject extends BaseBO {
    private int EmployeeProjectId;
    private int ProjectId;
    private int EmployeeId;
    private int EntityTypeId;
    private int VehicleId;
    private Date StartDate;
    private Date EndDate;
    private String Notes;

    public EmployeeProject(){}
    public EmployeeProject(int employeeProjectId, int projectId, int employeeId, String notes){
        this.setEmployeeProjectId(employeeProjectId);
        this.setProjectId(projectId);
        this.setEmployeeId(employeeId);
        this.setNotes(notes);
    }

    public int getEmployeeProjectId() {
        return EmployeeProjectId;
    }

    public void setEmployeeProjectId(int employeeProjectId) {
        EmployeeProjectId = employeeProjectId;
    }

    public int getProjectId() {
        return ProjectId;
    }

    public void setProjectId(int projectId) {
        ProjectId = projectId;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public int getEntityTypeId() {
        return EntityTypeId;
    }

    public void setEntityTypeId(int entityTypeId) {
        EntityTypeId = entityTypeId;
    }

    public int getVehicleId() {
        return VehicleId;
    }

    public void setVehicleId(int vehicleId) {
        VehicleId = vehicleId;
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

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }
}
