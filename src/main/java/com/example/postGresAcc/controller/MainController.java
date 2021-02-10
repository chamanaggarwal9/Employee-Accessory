package com.example.postGresAcc.controller;

import com.example.postGresAcc.entity.Accessory;
import com.example.postGresAcc.entity.Employee;
import com.example.postGresAcc.entity.Mapping;
import com.example.postGresAcc.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class MainController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping(value = "/save")
    public Employee savee(@RequestBody Employee employee)
    {
        return employeeService.save(employee);
    }

    @PostMapping(value = "/asave")
    public Accessory savee(@RequestBody Accessory accessory)
    {
        return employeeService.save(accessory);
    }

    @GetMapping(value = "{userId}")
    public Employee findbyUserId(@PathVariable("userId") int userId)
    {
        return employeeService.findById(userId);
    }

    @GetMapping(value = "/a/{accessoryId}")
    public Accessory findbyAccessoryId(@PathVariable("accessoryId") int accessoryId)
    {
        return employeeService.findByAId(accessoryId);
    }

    @DeleteMapping(value = "{userId}")
    public void deletebyUserId(@PathVariable("userId") int userId)
    {
        employeeService.deleteById(userId);
    }

    @PutMapping(value = "/update")
    public void updateUser(@RequestBody Employee employee)
    {
        employeeService.updateEmployee(employee);
    }

    @GetMapping(value = "findAll")
    public List<Mapping> findAll()
    {
        return employeeService.findAll();
    }

    @PostMapping(value = "/addAccessory")
    public boolean addAccessory(@RequestBody Mapping mapping)
    {
        return employeeService.addAccessory(mapping);
    }

    @DeleteMapping(value = "delete/{accessoryId}")
    public void deleteAccessory(@PathVariable("accessoryId") int accessoryId)
    {
        employeeService.deleteAccessory(accessoryId);
    }

    @PutMapping(value = "/replaceAccessory/{userId1}/{userId2}/{accessoryId}")
    public void replace(@PathVariable("userId1") int userId1, @PathVariable("userId2") int userId2, @PathVariable("accessoryId") int accessoryId)
    {
        employeeService.replaceAccessory(userId1, userId2, accessoryId);
    }


    @GetMapping(value = "/id/{userId}")
    public List<Integer> findByUserId(@PathVariable("userId") int userId) {
        return employeeService.findByUserId(userId);

    }

    @GetMapping(value = "/getAccessoryName/{userId}")
    public List<String> findByAccessoryId(@PathVariable("userId") int userId) {
        return employeeService.findByAccessoryId(userId);
    }



}
