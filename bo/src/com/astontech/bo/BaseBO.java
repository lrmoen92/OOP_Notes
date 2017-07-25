package com.astontech.bo;

/**
 * Created by Logan.Moen on 5/26/2017.
 */
public class BaseBO {

    private int Id;


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }


    public String  test_method() {
        return "super method";
    }
}
