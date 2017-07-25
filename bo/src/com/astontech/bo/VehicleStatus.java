package com.astontech.bo;

import java.util.Date;

/**
 * Created by Logan.Moen on 5/30/2017.
 */
public class VehicleStatus extends BaseBO {
    //region PROPERTIES
    private int VehicleStatusId;
    private int VehicleId;
    private int EntityTypeId;
    private String Notes;
    private Date CreateDate;
    //endregion

    //region CONSTRUCTORS

    public VehicleStatus() {}
    public VehicleStatus(int vehicleStatusId, String notes){
        this.setVehicleStatusId(vehicleStatusId);
        this.setNotes(notes);
    }

    //endregion

    //region GETTERS/SETTERS
    public int getVehicleStatusId() {
        return VehicleStatusId;
    }

    public void setVehicleStatusId(int vehicleStatusId) {
        VehicleStatusId = vehicleStatusId;
    }

    public int getVehicleId() {
        return VehicleId;
    }

    public void setVehicleId(int vehicleId) {
        VehicleId = vehicleId;
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

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }
    //endregion
}
