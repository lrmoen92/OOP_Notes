package com.astontech.bo;

/**
 * Created by Logan.Moen on 5/30/2017.
 */
public class ClientContact extends BaseBO {
    private int ClientId;
    private int EntityTypeId;
    private int PersonId;
    private int ClientContactId;

    public ClientContact(){}
    public ClientContact(int clientId, int personId, int clientContactId){
        this.setClientId(clientId);
        this.setPersonId(personId);
        this.setClientContactId(clientContactId);
    }

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int clientId) {
        ClientId = clientId;
    }

    public int getEntityTypeId() {
        return EntityTypeId;
    }

    public void setEntityTypeId(int entityTypeId) {
        EntityTypeId = entityTypeId;
    }

    public int getPersonId() {
        return PersonId;
    }

    public void setPersonId(int personId) {
        PersonId = personId;
    }

    public int getClientContactId() {
        return ClientContactId;
    }

    public void setClientContactId(int clientContactId) {
        ClientContactId = clientContactId;
    }
}
