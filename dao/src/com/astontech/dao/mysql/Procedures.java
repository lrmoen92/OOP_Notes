package com.astontech.dao.mysql;

/**
 * Created by Logan.Moen on 6/12/2017.
 */
public abstract class Procedures {

    final static String getPerson() {
        return "{call GetPerson(?,?)}";
    }
    final static String getPhone() {
        return "{call GetPhone(?,?)}";
    }
    final static String getVehicle() {
        return "{call GetVehicle(?,?)}";
    }
    final static String getVehicleMake() {
        return "{call GetVehicleMake(?,?)}";
    }
    final static String getVehicleModel() {
        return "{call GetVehicleModel(?,?)}";
    }
    final static String getEmployee() {
        return "{call GetEmployee(?,?)}";
    }
    final static String getEmail() {
        return "{call GetEmail(?,?)}";
    }
    final static String execPerson() {
        return "{call ExecPerson(?,?,?,?,?,?,?,?,?,?,?,?)}";
    }
    final static String execPhone() {
        return "{call ExecPhone(?,?,?,?,?,?,?,?)}";
    }
    final static String execVehicle() {
        return "{Call ExecVehicle(?,?,?,?,?,?,?,?,?,?)}";
    }
    final static String execVehicleMake() {
        return "{Call ExecVehicleMake(?,?,?,?)}";
    }
    final static String execVehicleModel() {
        return "{Call ExecVehicleModel(?,?,?,?)}";
    }
    final static String execEmployee() {
        return "{Call ExecEmployee(?,?,?,?,?,?,?)}";
    }
    final static String execEmail() {
        return "{Call ExecEmail(?,?,?,?,?)}";
    }

}
