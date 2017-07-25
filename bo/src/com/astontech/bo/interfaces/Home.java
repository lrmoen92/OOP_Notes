package com.astontech.bo.interfaces;

import com.astontech.bo.Employee;

/**
 * Created by Logan.Moen on 6/1/2017.
 */
public class Home implements ILocation {

    private String Address;
    private Employee Owner;

    public Home(){}

    public Home(String address, Employee owner){
        this.setAddress(address);
        this.setOwner(owner);
    }


    //region GETTERS/SETTERS
    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Employee getOwner() {
        return Owner;
    }

    public void setOwner(Employee owner) {
        Owner = owner;
    }
    //endregion


    @Override
    public int numberOfWorkspaces() {
        return 1;
    }

    @Override
    public boolean canHaveMeetings() {
        return false;
    }

    @Override
    public String getLocationName() {
        return this.Owner.getFirstName() + "'s Home";
    }

    @Override
    public boolean hasCoffee() {
        return true;
    }
}
