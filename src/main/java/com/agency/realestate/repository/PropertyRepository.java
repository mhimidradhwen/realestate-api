package com.agency.realestate.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.agency.realestate.model.Property;

public interface PropertyRepository extends MongoRepository<Property, String> {

    @Query("{propertyAvailablility : ?0}")
    List<Property> findByPropertyAvailablility(Boolean propertyAvailablility);

    @Query("{isArchived : ?0}")
    List<Property> findByIsArchived(boolean b);

    @Query("{isForSale :?0}")
    List<Property> findByIsForSale(boolean b);

    @Query("{isArchived : ?0,isForSale : ?1}")
    List<Property> findByIsArchivedAndIsForSale(boolean isArchived, boolean isForSale);

}
