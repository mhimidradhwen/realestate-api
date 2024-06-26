package com.agency.realestate.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.agency.realestate.model.Rent;

public interface RentRepository extends MongoRepository<Rent, String> {

    @Query(" {renterId:?0}")
    List<Rent> findAllByRenterId(String renterId);

}
