package com.agency.realestate.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.agency.realestate.model.Rent;

public interface RentRepository extends MongoRepository<Rent,String> {
    
}
