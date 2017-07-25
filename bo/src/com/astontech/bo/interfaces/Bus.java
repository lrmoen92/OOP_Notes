package com.astontech.bo.interfaces;

/**
 * Created by Logan.Moen on 6/2/2017.
 */
public class Bus implements IVehicle {

    private int Wheels;
    private int Passengers;
    private String Name;
    private int Mileage;

    public Bus(){}
    public Bus(int wheels, int passengers, int mileage, String name){
        this.setWheels(wheels);
        this.setPassengers(passengers);
        this.setMileage(mileage);
        this.setName(name);
    }


    public int getWheels() {
        return Wheels;
    }

    public void setWheels(int wheels) {
        Wheels = wheels;
    }

    public int getPassengers() {
        return Passengers;
    }

    public void setPassengers(int passengers) {
        Passengers = passengers;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getMileage() {
        return Mileage;
    }

    public void setMileage(int mileage) {
        Mileage = mileage;
    }

    @Override
    public boolean getsGoodGasMileage(){
        if (Mileage > 20){
            return true;
        }
        else
            return false;
    }

    @Override
    public int numberOfWheels(){
        return getWheels();

    }
    @Override
    public int maxPassengers(){
        return getPassengers();

    }
    @Override
    public String vehicleName(){
        return getName();

    }
}
