package com.example.postGresAcc.services;

import com.example.postGresAcc.entity.Employee;

public interface EmployeeService {

    void save(Employee employee);

    Employee findById(int employee);

    boolean existsById(int userId);

    void deleteById(int userId);

    void updateEmployee(Employee employee);

}
