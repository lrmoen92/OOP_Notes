package com.astontech.dao;

import com.astontech.bo.Employee;

import java.util.List;

/**
 * Created by Logan.Moen on 6/7/2017.
 */
public interface EmployeeDAO {

    public Employee getEmployeeById(int employeeId);
    public List<Employee> getEmployeeList();

    public int insertEmployee(Employee employee);
    public boolean updateEmployee(Employee employee);
    public boolean deleteEmployee(int employeeId);
}
