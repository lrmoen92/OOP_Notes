package com.astontech.dao;

import com.astontech.bo.Person;

import java.util.List;

/**
 * Created by Logan.Moen on 6/6/2017.
 */
public interface PersonDAO {

    //notes: GET METHODS
    public Person getPersonById(int personId);
    public List<Person> getPersonList();


    //notes: EXECUTE METHODS
    public int insertPerson(Person person);
    public boolean updatePerson(Person person);
    public boolean deletePerson(int personId);
}
