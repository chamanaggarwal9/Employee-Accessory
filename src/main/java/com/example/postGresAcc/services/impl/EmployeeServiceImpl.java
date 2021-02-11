package com.example.postGresAcc.services.impl;

import com.example.postGresAcc.entity.Accessory;
import com.example.postGresAcc.entity.Employee;
import com.example.postGresAcc.repository.AccessoryRepository;
import com.example.postGresAcc.repository.EmployeeRepository;
import com.example.postGresAcc.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    AccessoryRepository accessoryRepository;

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);

        for (String Name : employee.getAccessories()) {
            Accessory accessory = accessoryRepository.findByAccessoryName(Name);
            accessory.setUserId(employee.getUserId());
            accessoryRepository.save(accessory);
        }
    }

    @Override
    public Employee findById(int userId) {
        return employeeRepository.findById(userId).get();
    }

    @Override
    public boolean existsById(int userId) {
        return employeeRepository.existsById(userId);
    }

    @Override
    public void deleteById(int userId) {
        employeeRepository.deleteById(userId);

        Iterable<Accessory> iterable = accessoryRepository.findAll();

        for (Accessory a : iterable) {
            if (a.getUserId() == userId) {
                a.setUserId(0);
                accessoryRepository.save(a);
            }
        }

    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
