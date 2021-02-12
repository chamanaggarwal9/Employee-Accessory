package com.example.postGresAcc.services.impl;

import com.example.postGresAcc.dto.EmployeeDto;
import com.example.postGresAcc.entity.Accessory;
import com.example.postGresAcc.entity.Employee;
import com.example.postGresAcc.repository.AccessoryRepository;
import com.example.postGresAcc.repository.EmployeeRepository;
import com.example.postGresAcc.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AccessoryRepository accessoryRepository;

    @Override
    public void save(EmployeeDto employeeDto) {

        Employee employee = new Employee();

        employee.setUserId(employeeDto.getUserId());
        employee.setName(employeeDto.getName());
        employee.setAccessories(employeeDto.getAccessories());
        employee.setDesignation(employeeDto.getDesignation());
        employee.setEmail(employeeDto.getEmail());
        employee.setTeam(employeeDto.getTeam());
        employee.setPhoneNo(employeeDto.getPhoneNo());


        employeeRepository.save(employee);

        for (int id : employee.getAccessories()) {

            if(accessoryRepository.existsById(id))
            {
                Accessory accessory = accessoryRepository.findById(id).get();
                accessory.setUserId(employee.getUserId());
                accessoryRepository.save(accessory);
            }
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
    public void updateEmployee(EmployeeDto employeeDto) {

        Employee employee = new Employee();

        employee.setUserId(employeeDto.getUserId());
        employee.setName(employeeDto.getName());
        employee.setAccessories(employeeDto.getAccessories());
        employee.setDesignation(employeeDto.getDesignation());
        employee.setEmail(employeeDto.getEmail());
        employee.setTeam(employeeDto.getTeam());
        employee.setPhoneNo(employeeDto.getPhoneNo());

        employeeRepository.save(employee);

    }
}
