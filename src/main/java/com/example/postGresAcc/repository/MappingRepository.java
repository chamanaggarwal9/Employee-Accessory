package com.example.postGresAcc.repository;

import com.example.postGresAcc.entity.Mapping;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MappingRepository extends CrudRepository<Mapping, Integer> {
//    Iterable<Mapping> findByUserId(int userId);

}
