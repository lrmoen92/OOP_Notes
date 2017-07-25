package com.astontech.bo;

/**
 * Created by Logan.Moen on 5/30/2017.
 */
public class VehicleModel extends BaseBO {
    //region PROPERTIES
    private int VehicleModelId;
    private int VehicleMakeId;
    private String VehicleModelName;
    //endregion

    //region CONSTRUCTORS
    public VehicleModel(){}
    public VehicleModel(String vehicleModelName){
        this.setVehicleModelName(vehicleModelName);
    }
    public VehicleModel(int vehicleModelId, int vehicleMakeId, String vehicleModelName){
        this.setVehicleModelId(vehicleModelId);
        this.setVehicleMakeId(vehicleMakeId);
        this.setVehicleModelName(vehicleModelName);
    }
    //endregion

    //region SETTERS/GETTERS

    public int getVehicleModelId() {
        return VehicleModelId;
    }

    public void setVehicleModelId(int vehicleModelId) {
        VehicleModelId = vehicleModelId;
    }

    public int getVehicleMakeId() {
        return VehicleMakeId;
    }

    public void setVehicleMakeId(int vehicleMakeId) {
        VehicleMakeId = vehicleMakeId;
    }

    public String getVehicleModelName() {
        return VehicleModelName;
    }

    public void setVehicleModelName(String vehicleModelName) {
        VehicleModelName = vehicleModelName;
    }

    //endregion
}
