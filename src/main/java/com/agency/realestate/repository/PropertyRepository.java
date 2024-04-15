package com.agency.realestate.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.agency.realestate.model.Property;

public interface PropertyRepository extends MongoRepository<Property,String> {

    List<Property> findByPropertyAvailablility(Boolean propertyAvailability);
    
}
