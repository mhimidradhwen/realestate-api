package com.agency.realestate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agency.realestate.model.Rent;
import com.agency.realestate.service.RentService;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("rents/")
public class RentController {
   
    @Autowired
    private RentService rentService;

    // create a rent
    @PostMapping
    public ResponseEntity<?> createRent(@RequestBody Rent rent){
        try {
            return new ResponseEntity<Rent>(rentService.createRent(rent),HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }


    // get all rents
    @GetMapping
    public ResponseEntity<List<Rent>> getAllRents(){
        return new ResponseEntity<List<Rent>>(rentService.getAllRents(),HttpStatus.OK);
    }

    // get rent by id
    @GetMapping("/{rentId}")
    public ResponseEntity<?> getRentById(@PathVariable String rentId){
        try {
            return new ResponseEntity<Rent>(rentService.getRentById(rentId),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    // update a rent
    @PutMapping
    public ResponseEntity<?> updateRent(@RequestBody Rent newrent){
        try {
            return new ResponseEntity<Rent>(rentService.updateRent(newrent),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    //delete Rent
    @DeleteMapping("/{rentId}")
    public ResponseEntity<String> deleteRent(@PathVariable String rentId){
        try {
            return new ResponseEntity<String>(rentService.deleteRentById(rentId),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

}
