package com.example.postGresAcc.repository;

import com.example.postGresAcc.entity.Accessory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessoryRepository extends CrudRepository<Accessory, Integer> {
}
