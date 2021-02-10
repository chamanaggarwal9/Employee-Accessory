package com.example.postGresAcc.services;

import com.example.postGresAcc.entity.Accessory;
import com.example.postGresAcc.entity.Employee;
import com.example.postGresAcc.entity.Mapping;

import java.util.List;

public interface EmployeeService {

    Employee save(Employee employee);

    Accessory save(Accessory accessory);

    Employee findById(int employee);

    Accessory findByAId(int accessoryId);

    void deleteById(int userId);

    void updateEmployee(Employee employee);

    List<Mapping> findAll();

    boolean addAccessory(Mapping mapping);

    void deleteAccessory(int accessoryId);

    void replaceAccessory(int userId1, int userId2, int accessoryId);

    List<Integer> findByUserId(int userId);

    List<String> findByAccessoryId(int userId);

}
