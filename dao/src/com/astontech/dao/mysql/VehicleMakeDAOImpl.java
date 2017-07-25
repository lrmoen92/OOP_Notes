package com.astontech.dao.mysql;

import com.astontech.bo.VehicleMake;
import com.astontech.dao.VehicleMakeDAO;
import common.helpers.DateHelper;
import jdk.nashorn.internal.codegen.CompilerConstants;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Logan.Moen on 6/7/2017.
 */
public class VehicleMakeDAOImpl extends MySQL implements VehicleMakeDAO{

    @Override
    public VehicleMake getVehicleMakeById(int vehicleMakeId) {
        Connect();
        VehicleMake vehicleMake = null;
         try{
             String sp = "{call GetVehicleMake(?,?)}";
             CallableStatement cStmt = connection.prepareCall(sp);
             cStmt.setInt(1, GET_BY_ID);
             cStmt.setInt(2, vehicleMakeId);
             ResultSet rs = cStmt.executeQuery();

             if(rs.next()){
                 vehicleMake = HydrateObject(rs);
             }
         } catch(SQLException sqlEx){
             logger.error(sqlEx);
         }

        return vehicleMake;
    }

    @Override
    public List<VehicleMake> getVehicleMakeList() {

        Connect();
        List<VehicleMake> vehicleMakeList = new ArrayList<>();
        try{
            String sp = "{call GetVehicleMake(?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1, GET_COLLECTION);
            cStmt.setInt(2, 0);
            ResultSet rs = cStmt.executeQuery();

            while(rs.next()){
                vehicleMakeList.add(HydrateObject(rs));
            }
        } catch(SQLException sqlEx){
            logger.error(sqlEx);
        }

        return vehicleMakeList;

    }

    @Override
    public int insertVehicleMake(VehicleMake vehicleMake) {
        Connect();
        int id = 0;

        try{
            String sp = "{Call ExecVehicleMake(?,?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1, INSERT);
            cStmt.setInt(2, 0);
            cStmt.setString(3, vehicleMake.getVehicleName());
            cStmt.setDate(4, DateHelper.utilDateToSqlDate(vehicleMake.getCreateDate()));

            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException sqlEx){
            logger.error(sqlEx);
        }
        return id;
    }

    @Override
    public boolean updateVehicleMake(VehicleMake vehicleMake) {
        Connect();
        int id = 0;

        try{
            String sp = "{Call ExecVehicleMake(?,?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1, UPDATE);
            cStmt.setInt(2, vehicleMake.getVehicleMakeId());
            cStmt.setString(3, vehicleMake.getVehicleName());
            cStmt.setDate(4, DateHelper.utilDateToSqlDate(vehicleMake.getCreateDate()));

            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException sqlEx){
            logger.error(sqlEx);
        }
        return id > 0;
    }

    @Override
    public boolean deleteVehicleMake(int vehicleMakeId) {
        Connect();
        int id = 0;

        try{
            String sp = "{Call ExecVehicleMake(?,?,?,?)}";
            CallableStatement cStmt = connection.prepareCall(sp);
            cStmt.setInt(1, DELETE);
            cStmt.setInt(2, vehicleMakeId);
            cStmt.setString(3, null);
            cStmt.setDate(4, null);

            ResultSet rs = cStmt.executeQuery();

            if(rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException sqlEx){
            logger.error(sqlEx);
        }
        return id > 0;
    }

    private static VehicleMake HydrateObject(ResultSet rs) throws SQLException {
        VehicleMake vehicleMake = new VehicleMake();

        vehicleMake.setVehicleMakeId(rs.getInt(1));
        vehicleMake.setVehicleName(rs.getString(2));
        vehicleMake.setCreateDate(rs.getDate(3));


        return vehicleMake;
    }

}
