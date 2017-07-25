package com.astontech.dao;

import com.astontech.bo.Vehicle;

import java.util.List;

/**
 * Created by Logan.Moen on 6/7/2017.
 */
public interface VehicleDAO {

    public Vehicle getVehicleById(int vehicleId);
    public List<Vehicle> getVehicleList();

    public int insertVehicle(Vehicle vehicle);
    public boolean updateVehicle(Vehicle vehicle);
    public boolean deleteVehicle(int vehicleId);
}
