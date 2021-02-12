package com.example.postGresAcc.controller;

import com.example.postGresAcc.dto.EmployeeDto;
import com.example.postGresAcc.entity.Employee;
import com.example.postGresAcc.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/employeeSave")
    public void savee(@RequestBody EmployeeDto employeeDto) {
        employeeService.save(employeeDto);
    }

    @GetMapping(value = "{userId}")
    public ResponseEntity<Employee> findbyId(@PathVariable("userId") int userId)
    {
        try {

            return ResponseEntity.status(HttpStatus.OK).body(employeeService.findById(userId));
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(
                    (Employee) null, HttpStatus.OK);
        }
    }

    @PutMapping(value = "/update")
    public void updateUser(@RequestBody EmployeeDto employeeDto)
    {
        employeeService.updateEmployee(employeeDto);
    }

    @DeleteMapping(value = "{userId}")
    public void deletebyUserId(@PathVariable("userId") int userId)
    {
        if (employeeService.existsById(userId))
        {
            employeeService.deleteById(userId);
        }
        else
        {
            new ResponseEntity<>(
                    (Employee) null, HttpStatus.OK);
        }
    }

}

