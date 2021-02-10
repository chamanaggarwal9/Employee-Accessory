package com.example.postGresAcc.services.impl;

import com.example.postGresAcc.entity.Accessory;
import com.example.postGresAcc.entity.Employee;
import com.example.postGresAcc.entity.Mapping;
import com.example.postGresAcc.repository.AccessoryRepository;
import com.example.postGresAcc.repository.EmployeeRepository;
import com.example.postGresAcc.repository.MappingRepository;
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

    @Autowired
    MappingRepository mappingRepository;

    @Override
    public Employee save(Employee employee)
    {
        return employeeRepository.save(employee);
    }

    @Override
    public Accessory save(Accessory accessory)
    {
        return accessoryRepository.save(accessory);
    }

    @Override
    public Employee findById(int userId) {
        return employeeRepository.findById(userId).get();
    }

    @Override
    public Accessory findByAId(int accessoryId) {
        return accessoryRepository.findById(accessoryId).get();
    }

    @Override
    public void deleteById(int userId) {
        employeeRepository.deleteById(userId);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Mapping> findAll() {

        Iterable<Mapping> mappingIterable = mappingRepository.findAll();
        List<Mapping> mappingList = new ArrayList<>();
        mappingIterable.forEach(mappingList::add);
        return mappingList;
    }

    @Override
    public boolean addAccessory(Mapping mapping) {

        Accessory accessory = null;
        Employee employee = null;

        try {
            employee = employeeRepository.findById(mapping.getUserId()).get();
            accessory = accessoryRepository.findById(mapping.getAccessoryId()).get();
        }
        catch (Exception e) {
            System.out.println("");
        }

        if(accessory==null || employee==null)
        {
            return false;
        }
        else
        {
            mappingRepository.save(mapping);
            return true;
        }

    }

    @Override
    public void deleteAccessory(int accessoryId) {

        accessoryRepository.deleteById(accessoryId);
        Iterable<Mapping> mappingList = mappingRepository.findAll();
        for(Mapping m: mappingList)
        {
            if(m.getAccessoryId()==accessoryId)
            {
                mappingRepository.deleteById(m.getMappingId());
            }
        }

    }

    @Override
    public void replaceAccessory(int userId1, int userId2, int accessoryId) {

        Iterable<Mapping> mappingList = mappingRepository.findAll();
        for(Mapping m: mappingList)
        {
            if(m.getUserId()==userId1)
            {
                m.setUserId(userId2);
                mappingRepository.save(m);
                break;
            }
        }

    }

    @Override
    public List<Integer> findByUserId(int userId) {
        Iterable<Mapping> mappingIterable = mappingRepository.findAll();
        List<Integer> array = new ArrayList<>();
        for (Mapping m: mappingIterable) {
            if(m.getUserId()==userId)
            {
                array.add(m.getAccessoryId());
            }
        }
        return array;
    }

    @Override
    public List<String> findByAccessoryId(int userId) {
        List<Integer> ids = new ArrayList<>();
        ids=findByUserId(userId);
        ArrayList<String> strings = new ArrayList<>();
        for (int id:ids) {
            strings.add(findByAId(id).getAccessoryName());
        }
        return strings;
    }
}
