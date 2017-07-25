package com.astontech.bo;

import java.util.Date;

/**
 * Created by Logan.Moen on 5/30/2017.
 */
public class Client extends BaseBO {
    private int ClientId;
    private String ClientName;
    private Date CreateDate;
    private ClientContact Contact;

    public Client(){
        this.setContact(new ClientContact());
    }
    public Client(int clientId, String clientName){
        this.setClientId(clientId);
        this.setClientName(clientName);
    }

    public int getClientId() {
        return ClientId;
    }

    public void setClientId(int clientId) {
        ClientId = clientId;
    }

    public String getClientName() {
        return ClientName;
    }

    public void setClientName(String clientName) {
        ClientName = clientName;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date createDate) {
        CreateDate = createDate;
    }

    public ClientContact getContact() {
        return Contact;
    }

    public void setContact(ClientContact contact) {
        Contact = contact;
    }

    public String getClientWithId(){
        return "Client ID: " + this.ClientId + " Client Name: " + this.ClientName;
    }

}
