package com.astontech.bo;

import java.util.Date;

/**
 * Created by Logan.Moen on 5/30/2017.
 */
public class Address extends BaseBO{
    private int AddressId;
    private int ClientId;
    private int PersonId;
    private int EntityTypeId;
    private int AddressNumber;
    private String Street;
    private String Street02;
    private String City;
    private int StateId;
    private int CountryId;
    private Date DateCreate;

    public Address() {}

    public Address(int addressNumber, String street, String street02, String city){
        this.setAddressNumber(addressNumber);
        this.setStreet(street);
        this.setStreet02(street02);
        this.setCity(city);
    }

    public int getAddressId() {
        return AddressId;
    }

    public void setAddressId(int addressId) {
        AddressId = addressId;
    }

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int clientId) {
        ClientId = clientId;
    }

    public int getPersonId() {
        return PersonId;
    }

    public void setPersonId(int personId) {
        PersonId = personId;
    }

    public int getEntityTypeId() {
        return EntityTypeId;
    }

    public void setEntityTypeId(int entityTypeId) {
        EntityTypeId = entityTypeId;
    }

    public int getAddressNumber() {
        return AddressNumber;
    }

    public void setAddressNumber(int addressNumber) {
        AddressNumber = addressNumber;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getStreet02() {
        return Street02;
    }

    public void setStreet02(String street02) {
        Street02 = street02;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public int getStateId() {
        return StateId;
    }

    public void setStateId(int stateId) {
        StateId = stateId;
    }

    public int getCountryId() {
        return CountryId;
    }

    public void setCountryId(int countryId) {
        CountryId = countryId;
    }

    public Date getDateCreate() {
        return DateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        DateCreate = dateCreate;
    }


    public String getFullAddress(){
        return this.AddressNumber + " " + this.Street + ", " + this.Street02 + ", " + this.City;
    }
}
