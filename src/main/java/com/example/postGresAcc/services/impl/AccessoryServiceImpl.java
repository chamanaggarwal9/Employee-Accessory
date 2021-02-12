package com.example.postGresAcc.services.impl;

import com.example.postGresAcc.entity.Accessory;
import com.example.postGresAcc.entity.Employee;
import com.example.postGresAcc.repository.AccessoryRepository;
import com.example.postGresAcc.repository.EmployeeRepository;
import com.example.postGresAcc.services.AccessoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccessoryServiceImpl implements AccessoryService {

    @Autowired
    private AccessoryRepository accessoryRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void save(Accessory accessory)
    {
        accessoryRepository.save(accessory);
    }

    @Override
    public Accessory findByAccessoryId(int accessoryId) {
        return accessoryRepository.findById(accessoryId).get();
    }

    @Override
    public boolean existsByAccessoryId(int accessoryId) {
        return accessoryRepository.existsById(accessoryId);
    }

    @Override
    public void deleteAccessory(int accessoryId) {

        Accessory accessory = accessoryRepository.findById(accessoryId).get();
        int userId = accessory.getUserId();

        accessoryRepository.deleteById(accessoryId);

        if(employeeRepository.existsById(userId))
        {
            Employee employee = employeeRepository.findById(userId).get();

            employee.getAccessories().removeIf(name -> name.equals(accessoryId));

            employeeRepository.save(employee);
        }

    }

    @Override
    public void assignAccessory(int userId, int accessoryId) {

        Accessory accessory = accessoryRepository.findById(accessoryId).get();
        accessory.setUserId(userId);
        accessoryRepository.save(accessory);

        Employee employee = employeeRepository.findById(userId).get();
        if(!employee.getAccessories().contains(accessoryId))
        {
            employee.getAccessories().add(accessoryId);
            employeeRepository.save(employee);
        }

    }

    @Override
    public void takeAccessory(int userId, int accessoryId) {

        Employee employee = employeeRepository.findById(userId).get();
        employee.getAccessories().removeIf(name -> name.equals(accessoryId));
        employeeRepository.save(employee);

        Accessory accessory = accessoryRepository.findById(accessoryId).get();
        accessory.setUserId(0);
        accessoryRepository.save(accessory);

    }

    @Override
    public void replaceAccessory(int userId1, int userId2, int accessoryId) {

        Accessory accessory = accessoryRepository.findById(accessoryId).get();

        accessory.setUserId(userId2);
        accessoryRepository.save(accessory);

        Employee employee1 = employeeRepository.findById(userId1).get();
        Employee employee2 = employeeRepository.findById(userId2).get();

        employee1.getAccessories().removeIf(name -> name.equals(accessoryId));
        employeeRepository.save(employee1);

        employee2.getAccessories().add(accessoryId);
        employeeRepository.save(employee2);

    }

}
