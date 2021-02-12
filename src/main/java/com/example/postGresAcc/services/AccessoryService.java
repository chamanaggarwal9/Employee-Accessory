package com.example.postGresAcc.services;

import com.example.postGresAcc.entity.Accessory;

public interface AccessoryService {

    void save(Accessory accessory);

    Accessory findByAccessoryId(int accessoryId);

    boolean existsByAccessoryId(int accessoryId);

    void deleteAccessory(int accessoryId);

    void assignAccessory(int userId, int accessoryId);

    void takeAccessory(int userId, int accessoryId);

    void replaceAccessory(int userId1, int userId2, int accessoryId);

}
