package com.agency.realestate.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.agency.realestate.model.Sale;

public interface SaleRepository extends MongoRepository<Sale, String> {

    @Query("{ownerId :?0}")
    List<Sale> findAllByOwnerId(String ownerId);

}
