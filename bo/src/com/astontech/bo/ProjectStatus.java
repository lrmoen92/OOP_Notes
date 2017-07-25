package com.astontech.bo;

import java.util.Date;

/**
 * Created by Logan.Moen on 5/30/2017.
 */
public class ProjectStatus extends BaseBO{
    private int ProjectStatusId;
    private int ProjectId;
    private int EntityTypeId;
    private String Notes;
    private int PercentComplete;
    private Date StartDate;
    private Date EndDate;

    public ProjectStatus(){}
    public ProjectStatus(int projectStatusId, int percentComplete, String notes){
        this.setProjectStatusId(projectStatusId);
        this.setPercentComplete(percentComplete);
        this.setNotes(notes);
    }

    public int getProjectStatusId() {
        return ProjectStatusId;
    }

    public void setProjectStatusId(int projectStatusId) {
        ProjectStatusId = projectStatusId;
    }

    public int getProjectId() {
        return ProjectId;
    }

    public void setProjectId(int projectId) {
        ProjectId = projectId;
    }

    public int getEntityTypeId() {
        return EntityTypeId;
    }

    public void setEntityTypeId(int entityTypeId) {
        EntityTypeId = entityTypeId;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
    }

    public int getPercentComplete() {
        return PercentComplete;
    }

    public void setPercentComplete(int percentComplete) {
        PercentComplete = percentComplete;
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

    public String getProjectStatusWithPercent(){
        return "Percent Complete: " + this.PercentComplete + "% Project Status: " + this.Notes;
    }
}
