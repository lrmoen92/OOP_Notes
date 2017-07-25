package com.astontech.bo;

/**
 * Created by Logan.Moen on 5/30/2017.
 */
public class Phone extends BaseBO {
    private int PhoneId;
    private int EntityTypeId;
    private int ClientId;
    private int PersonId;
    private int AreaCode;
    private int PhoneNumber;
    private int PhoneNumberPost;

    public Phone(){}
    public Phone(int personId, int areaCode, int phoneNumber, int phoneNumberPost){
        this.setPersonId(personId);
        this.setAreaCode(areaCode);
        this.setPhoneNumber(phoneNumber);
        this.setPhoneNumberPost(phoneNumberPost);
    }

    public int getPhoneId() {
        return PhoneId;
    }

    public void setPhoneId(int phoneId) {
        PhoneId = phoneId;
    }

    public int getEntityTypeId() {
        return EntityTypeId;
    }

    public void setEntityTypeId(int entityTypeId) {
        EntityTypeId = entityTypeId;
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

    public int getAreaCode() {
        return AreaCode;
    }

    public void setAreaCode(int areaCode) {
        AreaCode = areaCode;
    }

    public int getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public int getPhoneNumberPost() {
        return PhoneNumberPost;
    }

    public void setPhoneNumberPost(int phoneNumberPost) {
        PhoneNumberPost = phoneNumberPost;
    }

    public String getFullPhoneNumber(){
        return this.AreaCode + "-" + this.PhoneNumber + "-" + this.PhoneNumberPost;
    }
}
