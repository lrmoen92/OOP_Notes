package com.astontech.bo;

import java.util.Date;

/**
 * Created by Logan.Moen on 5/30/2017.
 */
public class VehicleMake extends BaseBO {

    //region PROPERTIES
    private int VehicleMakeId;
    private String VehicleName;
    private Date CreateDate;
    //endregion

    //region CONSTRUCTORS

    public VehicleMake(){


    }
    public VehicleMake(int vehicleMakeId, String vehicleName){
        this.setVehicleMakeId(vehicleMakeId);
        this.setVehicleName(vehicleName);
    }
    public VehicleMake(String vehicleName){
        this.setVehicleName(vehicleName);
    }

    //endregion

    //region SETTERS/GETTERS

    public int getVehicleMakeId() {
        return VehicleMakeId;
    }

    public void setVehicleMakeId(int vehicleMakeId) {
        VehicleMakeId = vehicleMakeId;
    }

    public String getVehicleName() {
        return VehicleName;
    }

    public void setVehicleName(String vehicleName) {
        VehicleName = vehicleName;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }

    //endregion
}
