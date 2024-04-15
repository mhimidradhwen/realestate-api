package com.agency.realestate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.agency.realestate.model.Property;
import com.agency.realestate.service.PropertyService;

@RestController
@RequestMapping("/properties")
public class PropertyController {
    
    @Autowired
    private PropertyService propertyService;

    // Create a property
    @PostMapping
    public ResponseEntity<Property> createProperty(@RequestBody Property property){
        return new ResponseEntity<Property>(propertyService.addProperty(property),HttpStatus.CREATED);
    }

    // Get all properties
    @GetMapping
    public ResponseEntity<List<Property>> getAllProperties(){
        return new ResponseEntity<List<Property>>(propertyService.getAllProperties(),HttpStatus.OK);
    }

    // Get property by id
    @GetMapping("/{propertyId}")
    public ResponseEntity<Property> getPropertyById(@PathVariable String propertyId){
        return new ResponseEntity<Property>(propertyService.getPropertyById(propertyId),HttpStatus.OK);
    }

    // Get property by availabilty 
    @GetMapping("/available/{propertyAvilability}")
    public ResponseEntity<List<Property>> getPropertyByAvailability(@PathVariable Boolean propertyAvailabilty){
        return new ResponseEntity<List<Property>>(propertyService.getPropertyByAvailabilty(propertyAvailabilty),HttpStatus.OK);
    }

    // update a property
    @PutMapping
    public ResponseEntity<Property> updateProperty(@RequestBody Property newProperty){
        return new ResponseEntity<Property>(propertyService.updateProperty(newProperty),HttpStatus.OK);
    }

    // delete property by id
    @DeleteMapping("/{propertyId}")
    public ResponseEntity<String> deletePropertyById(@PathVariable String propertyId){
        return new ResponseEntity<String>(propertyService.deleteProperty(propertyId),HttpStatus.OK);
    }
}
