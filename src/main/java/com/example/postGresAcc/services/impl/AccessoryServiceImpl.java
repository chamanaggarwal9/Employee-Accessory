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
    AccessoryRepository accessoryRepository;

    @Autowired
    EmployeeRepository employeeRepository;

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
        String accessoryName = accessory.getAccessoryName();
        int userId = accessory.getUserId();

        accessoryRepository.deleteById(accessoryId);

        Employee employee = employeeRepository.findById(userId).get();

        employee.getAccessories().removeIf(name -> name.equals(accessoryName));

        employeeRepository.save(employee);

    }

    @Override
    public void replaceAccessory(int userId1, int userId2, int accessoryId) {

        Accessory accessory = accessoryRepository.findById(accessoryId).get();
        String accessoryName = accessory.getAccessoryName();

        accessory.setUserId(userId2);
        accessoryRepository.save(accessory);

        Employee employee1 = employeeRepository.findById(userId1).get();
        Employee employee2 = employeeRepository.findById(userId2).get();

        employee1.getAccessories().removeIf(name -> name.equals(accessoryName));
        employeeRepository.save(employee1);

        employee2.getAccessories().add(accessoryName);
        employeeRepository.save(employee2);

    }

}
