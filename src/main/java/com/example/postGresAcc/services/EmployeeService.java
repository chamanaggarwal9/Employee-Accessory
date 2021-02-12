package com.example.postGresAcc.services;

import com.example.postGresAcc.dto.EmployeeDto;
import com.example.postGresAcc.entity.Employee;

public interface EmployeeService {

    void save(EmployeeDto emloyeeDto);

    Employee findById(int employee);

    boolean existsById(int userId);

    void deleteById(int userId);

    void updateEmployee(EmployeeDto employeeDto);

}
