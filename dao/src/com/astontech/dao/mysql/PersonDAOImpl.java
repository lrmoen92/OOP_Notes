package com.astontech.dao.mysql;

import com.astontech.bo.Person;
import com.astontech.dao.PersonDAO;
import common.helpers.DateHelper;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Logan.Moen on 6/6/2017.
 */
public class PersonDAOImpl extends MySQL implements PersonDAO {
    @Override
    public Person getPersonById(int personId) {
        Connect();
        Person person = null;  //not instantiating, if no records returned, don't use memory
        try{
            String sp = "{call GetPerson(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1, GET_BY_ID);
            cStmt.setInt(2, personId);
            ResultSet rs = cStmt.executeQuery();

            if(rs.next()){
                person = HydrateObject(rs);
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return person;
    }

    @Override
    public List<Person> getPersonList() {
        Connect();
        List<Person> personList = new ArrayList<>();
        try{
            String sp = "{call GetPerson(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()){
                personList.add(HydrateObject(rs));
            }

        } catch (SQLException sqlEx) {
            logger.error(sqlEx);
        }

        return personList;
    }

    @Override
    public int insertPerson(Person person) {
        Connect();
        int id = 0;
        try {
            // call ExecPerson(10, null, 'Mr.', 'Blake', 'Eric', 'Wittlebe', '333-99-8888', '1985-09-13', '2000-01-01', 'B-rad', 0, 'F')
            //                (QueryId, PersonId, Title, FirstName, MiddleName, LastName, SSN, Birthdate, CreateDate, DisplayName, IsDeleted, Gender)
            String sp = "{call ExecPerson(?,?,?,?,?,?,?,?,?,?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1, INSERT);
            cStmt.setInt(2, 0);
            cStmt.setString(3, person.getTitle());
            cStmt.setString(4, person.getFirstName());
            cStmt.setString(5, person.getMiddleName());
            cStmt.setString(6, person.getLastName());
            cStmt.setString(7, person.getSSN());
            cStmt.setDate(8, DateHelper.utilDateToSqlDate(person.getBirthDate()));
            cStmt.setDate(9, DateHelper.utilDateToSqlDate(person.getCreateDate()));
            cStmt.setString(10, person.getDisplayFirstName());
            cStmt.setBoolean(11, person.getIsDeleted());
            cStmt.setString(12, person.getGender());

            ResultSet rs = cStmt.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }

        } catch(SQLException sqlEx){
            logger.error(sqlEx);
        }

        return id;
    }

    @Override
    public boolean updatePerson(Person person) {

        Connect();
        int id = 0;
        try {
            // call ExecPerson(10, null, 'Mr.', 'Blake', 'Eric', 'Wittlebe', '333-99-8888', '1985-09-13', '2000-01-01', 'B-rad', 0, 'F')
            //                (QueryId, PersonId, Title, FirstName, MiddleName, LastName, SSN, Birthdate, CreateDate, DisplayName, IsDeleted, Gender)
            String sp = "{call ExecPerson(?,?,?,?,?,?,?,?,?,?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1, UPDATE);
            cStmt.setInt(2, person.getPersonId());
            cStmt.setString(3, person.getTitle());
            cStmt.setString(4, person.getFirstName());
            cStmt.setString(5, person.getMiddleName());
            cStmt.setString(6, person.getLastName());
            cStmt.setString(7, person.getSSN());
            cStmt.setDate(8, DateHelper.utilDateToSqlDate(person.getBirthDate()));
            cStmt.setDate(9, DateHelper.utilDateToSqlDate(person.getCreateDate()));
            cStmt.setString(10, person.getDisplayFirstName());
            cStmt.setBoolean(11, person.getIsDeleted());
            cStmt.setString(12, person.getGender());

            ResultSet rs = cStmt.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }

        } catch(SQLException sqlEx){
            logger.error(sqlEx);
        }

        return id > 0;
    }

    @Override
    public boolean deletePerson(int personId) {

        Connect();
        int id = 0;
        try {
            // call ExecPerson(10, null, 'Mr.', 'Blake', 'Eric', 'Wittlebe', '333-99-8888', '1985-09-13', '2000-01-01', 'B-rad', 0, 'F')
            //                (QueryId, PersonId, Title, FirstName, MiddleName, LastName, SSN, Birthdate, CreateDate, DisplayName, IsDeleted, Gender)
            String sp = "{call ExecPerson(?,?,?,?,?,?,?,?,?,?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1, DELETE);
            cStmt.setInt(2, personId);
            cStmt.setString(3, "");
            cStmt.setString(4, "");
            cStmt.setString(5, "");
            cStmt.setString(6, "");
            cStmt.setString(7, "");
            cStmt.setDate(8, null);
            cStmt.setDate(9, null);
            cStmt.setString(10, "");
            cStmt.setBoolean(11, false);
            cStmt.setString(12, "");

            ResultSet rs = cStmt.executeQuery();
            if(rs.next()){
                id = rs.getInt(1);
            }

        } catch(SQLException sqlEx){
            logger.error(sqlEx);
        }

        return id > 0;
    }

    private static Person HydrateObject(ResultSet rs) throws SQLException {
        //notes:  Hydrating an object via table col index
        Person person = new Person();

        person.setPersonId(rs.getInt(1));
        person.setTitle(rs.getString(2));
        person.setFirstName(rs.getString(3));
        person.setMiddleName(rs.getString(4));
        person.setLastName(rs.getString(5));
        person.setSSN(rs.getString(6));
        person.setBirthDate(rs.getDate(7));
        person.setCreateDate(rs.getDate(8));
        person.setDisplayFirstName(rs.getString(9));
        person.setIsDeleted(rs.getBoolean(10));
        person.setGender(rs.getString(11));


        return person;
    }
}
