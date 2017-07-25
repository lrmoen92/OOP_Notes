package com.astontech.dao;

import com.astontech.bo.Email;

import java.util.List;

/**
 * Created by Logan.Moen on 6/7/2017.
 */
public interface EmailDAO {

    //get 1 and all
    public Email getEmailById(int emailId);
    public List<Email> getEmailList();

    //insert update delete
    public int insertEmail(Email email);
    public boolean updateEmail(Email email);
    public boolean deleteEmail(int emailId);

}
