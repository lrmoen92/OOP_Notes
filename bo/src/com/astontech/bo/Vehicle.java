package com.astontech.bo;

import java.util.Date;

/**
 * Created by Logan.Moen on 5/30/2017.
 */
    //region PROPERTIES
public class Vehicle extends BaseBO implements Comparable<Vehicle>{
    private int VehicleId;
    private int VehicleModelId;
    private int Year;
    private String LicensePlate;
    private String Vin;
    private String Color;
    private boolean IsPurchase;
    private int PurchasePrice;
    private Date PurchaseDate;
    private VehicleMake Make;
    private VehicleStatus Status;
    private VehicleModel Model;
    //endregion

    //region CONSTRUCTORS
    public Vehicle() {
        this.setMake(new VehicleMake());
        this.setStatus(new VehicleStatus());
        this.setModel(new VehicleModel());
    }
    public Vehicle(int vehicleId, int year, String vin){
        this.setVehicleId(vehicleId);
        this.setYear(year);
        this.setVin(vin);
    }
    //endregion

    //region SETTERS/GETTERS
    public int getVehicleId(){
        return VehicleId;
    }

    public void setVehicleId(int vehicleId){
        VehicleId = vehicleId;
    }

    public int getVehicleModelId(){
        return VehicleModelId;
    }

    public void setVehicleModelId(int vehicleModelId){
        VehicleModelId = vehicleModelId;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public String getLicensePlate() {
        return LicensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        LicensePlate = licensePlate;
    }

    public String getVin() {
        return Vin;
    }

    public void setVin(String vin) {
        Vin = vin;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public boolean getIsPurchase() {
        return IsPurchase;
    }

    public void setIsPurchase(boolean isPurchase) {
        IsPurchase = isPurchase;
    }

    public int getPurchasePrice() {
        return PurchasePrice;
    }

    public void setPurchasePrice(int purchasePrice) {
        PurchasePrice = purchasePrice;
    }

    public Date getPurchaseDate() {
        return PurchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        PurchaseDate = purchaseDate;
    }

    public VehicleMake getMake() {
        return Make;
    }

    public void setMake(VehicleMake make) {
        Make = make;
    }

    public VehicleStatus getStatus() {
        return Status;
    }

    public void setStatus(VehicleStatus status) {
        Status = status;
    }

    public VehicleModel getModel() {
        return Model;
    }

    public void setModel(VehicleModel model) {
        Model = model;
    }

    //endregion

    public String getYearAndVin(){
        return "Year: " + this.Year + " Vin: " + this.Vin;
    }

    @Override
    public int compareTo(Vehicle o) {
        if (getYear() > o.getYear()) {
            return 1;
        } else if (getYear() < o.getYear()) {
            return -1;
        } else
            return 0;
    }


}
