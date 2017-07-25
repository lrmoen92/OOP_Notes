package com.astontech.dao;

import com.astontech.bo.VehicleMake;

import java.util.List;

/**
 * Created by Logan.Moen on 6/7/2017.
 */
public interface VehicleMakeDAO {

    public VehicleMake getVehicleMakeById(int vehicleMakeId);
    public List<VehicleMake> getVehicleMakeList();

    public int insertVehicleMake(VehicleMake vehicleMake);
    public boolean updateVehicleMake(VehicleMake vehicleMake);
    public boolean deleteVehicleMake(int vehicleMakeId);
}
