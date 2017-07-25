package com.astontech.bo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import common.helpers.*;

/**
 * Created by Logan.Moen on 5/26/2017.
 */
public class Person extends BaseBO implements Comparable<Person>, Serializable{

    //region PROPERTIES
    //PersonId
    private int PersonId;
    //Title
    private String Title;
    //First Name
    private String FirstName;
    private String MiddleName;
    //Last Name
    private String LastName;
    //DisplayFirstName
    private String DisplayFirstName;
    //Gender
    private String Gender;
    private Date BirthDate;
    private transient String SSN;
    private Date CreateDate;
    private Boolean IsDeleted;
    //List of Email objects
    private List<Email> Emails;
    //List of Phone objects
    private List<Phone> Phones;
    //List of Address objects
    private List<Address> Addresses;
    //List of Vehicle objects
    private List<Vehicle> Vehicles;
    //endregion

    //region CONSTRUCTORS
    public Person() {
        this.setEmails(new ArrayList<>());
        this.setPhones(new ArrayList<>());
        this.setAddresses(new ArrayList<>());
        this.setVehicles(new ArrayList<>());
    }

    public Person(String title, String firstName, String lastName) {
        this.setTitle(title);
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    public Person(String title, String firstName, String lastName, int personId) {
        this.setTitle(title);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setPersonId(personId);
    }
    //endregion

    //region SETTERS/GETTERS
    public void setPersonId(int personId) {
        this.PersonId = personId;
    }

    public int getPersonId() {
        return this.PersonId;
    }

    public void setTitle(String title) {
        this.Title = title;
    }

    public String getTitle() {
        return this.Title;
    }

    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public String getFirstName() {
        return this.FirstName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public String getLastName() {
        return this.LastName;
    }

    public void setDisplayFirstName(String displayFirstName) {
        this.DisplayFirstName = displayFirstName;
    }

    public String getDisplayFirstName() {
        return this.DisplayFirstName;
    }

    public void setGender(String gender) {
        this.Gender = gender;
    }

    public String getGender() { return this.Gender; }

    public List<Email> getEmails() {
        return Emails;
    }

    public void setEmails(List<Email> emails) {
        Emails = emails;
    }

    public List<Phone> getPhones() {
        return Phones;
    }

    public void setPhones(List<Phone> phones) {
        Phones = phones;
    }

    public List<Address> getAddresses() {
        return Addresses;
    }

    public void setAddresses(List<Address> addresses) {
        Addresses = addresses;
    }

    public List<Vehicle> getVehicles() {
        return Vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        Vehicles = vehicles;
    }

    public String getMiddleName() {
        return this.MiddleName;
    }

    public void setMiddleName(String middleName) {
        this.MiddleName = middleName;
    }

    public Date getBirthDate() {
        return this.BirthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.BirthDate = birthDate;
    }

    public String getSSN() {
        return this.SSN;
    }

    public void setSSN(String SSN) {
        this.SSN = SSN;
    }

    public Date getCreateDate() {
        return this.CreateDate;
    }

    public void setCreateDate(Date createDate) {
        this.CreateDate = createDate;
    }

    public Boolean getIsDeleted() {
        return this.IsDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.IsDeleted = isDeleted;
    }

    //endregion

    //region CUSTOM METHODS
    //notes:       this will become an extension method.


    public String getFullName() {
        if(StringHelper.isNullOrEmpty(this.FirstName) && StringHelper.isNullOrEmpty(this.LastName))
            return "No Name Set";
        else {
            if(StringHelper.isNullOrEmpty(this.FirstName))
                return this.LastName;
            else if(StringHelper.isNullOrEmpty(this.LastName))
                return this.FirstName;
            else return this.FirstName + " " + this.LastName;
        }



    }

    public String toString() {
        return "PersonId=" + this.PersonId + " Full Name=" + this.getFullName() + " DOB=" + this.BirthDate + " SSN=" + this.SSN;
    }


    //endregion

    @Override
    public int compareTo(Person o) {
        if (getPersonId() > o.getPersonId()) {
            return 1;
        } else if (getPersonId() < o.getPersonId()) {
            return -1;
        } else
            return 0;
    }


}
