package com.astontech.bo;

/**
 * Created by Logan.Moen on 5/30/2017.
 */
public class Email extends BaseBO{

    //region PROPERTIES
    private int EmailId;
    private String EmailAddress;
    private int EmployeeId;
    private int EntityTypeId;
    private EntityType EmailType;
    //endregion

    //region CONSTRUCTORS

    public Email(){
        this.setEmailType(new EntityType());
    }
    public Email(int emailId, String emailAddress, int employeeId){
        this.setEmailId(emailId);
        this.setEmailAddress(emailAddress);
        this.setEmployeeId(employeeId);
    }

    public Email(String emailAddress) {
        this.setEmailType(new EntityType());
        this.setEmailAddress(emailAddress);
    }
    //endregion

    //region GETTERS/SETTERS
    public int getEmailId() {
        return EmailId;
    }

    public void setEmailId(int emailId) {
        EmailId = emailId;
    }

    public String getEmailAddress() {
        return EmailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        EmailAddress = emailAddress;
    }

    public int getEmployeeId() {
        return EmployeeId;
    }

    public void setEmployeeId(int employeeId) {
        EmployeeId = employeeId;
    }

    public int getEntityTypeId() {
        return EntityTypeId;
    }

    public void setEntityTypeId(int entityTypeId) {
        EntityTypeId = entityTypeId;
    }

    public EntityType getEmailType() {
        return EmailType;
    }

    public void setEmailType(EntityType emailType) {
        EmailType = emailType;
    }
    //endregion

}
