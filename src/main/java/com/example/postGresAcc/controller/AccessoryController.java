package com.example.postGresAcc.controller;

import com.example.postGresAcc.entity.Accessory;
import com.example.postGresAcc.services.AccessoryService;
import com.example.postGresAcc.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/accessory")
public class AccessoryController {

    @Autowired
    private AccessoryService accessoryService;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping(value = "/accessorySave")
    public void savee(@RequestBody Accessory accessory)
    {
        accessoryService.save(accessory);
    }

    @GetMapping(value = "/{accessoryId}")
    public ResponseEntity<Accessory> findbyAccessoryId(@PathVariable("accessoryId") int accessoryId)
    {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(accessoryService.findByAccessoryId(accessoryId));
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(
                    (Accessory) null, HttpStatus.OK);
        }

    }

    @DeleteMapping(value = "delete/{accessoryId}")
    public void deleteAccessory(@PathVariable("accessoryId") int accessoryId) {

        if (accessoryService.existsByAccessoryId(accessoryId))
        {
            accessoryService.deleteAccessory(accessoryId);
        }
        else
        {
            new ResponseEntity<>(
                    (Accessory) null, HttpStatus.OK);
        }

    }

    @PutMapping(value = "/replaceAccessory/{userId1}/{userId2}/{accessoryId}")
    public void replace(@PathVariable("userId1") int userId1, @PathVariable("userId2") int userId2, @PathVariable("accessoryId") int accessoryId)
    {
        if(accessoryService.existsByAccessoryId(accessoryId) && employeeService.existsById(userId1) && employeeService.existsById(userId2))
        {
            accessoryService.replaceAccessory(userId1, userId2, accessoryId);
        }
        else
        {
            new ResponseEntity<>(
                    (Accessory) null, HttpStatus.OK);
        }

    }

}
