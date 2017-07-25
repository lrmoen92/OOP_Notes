package com.astontech.dao;

import com.astontech.bo.VehicleModel;

import java.util.List;

/**
 * Created by Logan.Moen on 6/7/2017.
 */
public interface VehicleModelDAO {

    public VehicleModel getVehicleModelById(int vehicleModelId);
    public List<VehicleModel> getVehicleModelList();

    public int insertVehicleModel(VehicleModel vehicleModel);
    public boolean updateVehicleModel(VehicleModel vehicleModel);
    public boolean deleteVehicleModel(int vehicleModelId);
}
