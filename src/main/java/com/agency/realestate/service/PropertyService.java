package com.agency.realestate.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agency.realestate.model.Property;
import com.agency.realestate.repository.PropertyRepository;

@Service
public class PropertyService {
    @Autowired
    private PropertyRepository propertyRepo;

    // add new property
    public Property addProperty(Property property) {
        property.setPropertyId(UUID.randomUUID().toString().split("-")[0]);
        return propertyRepo.save(property);
    }

    // get all properties
    public List<Property> getAllProperties() {
        return propertyRepo.findAll();
    }

    // get property by Id
    public Property getPropertyById(String propertyId) {
        return propertyRepo.findById(propertyId).get();
    }

    // get all properties by avilability
    public List<Property> getPropertyByAvailabilty(Boolean propertyAvailability) {
        return propertyRepo.findByPropertyAvailablility(propertyAvailability);
    }

    // update a property
    public Property updateProperty(Property newProperty) {
        Property existingProperty = propertyRepo.findById(newProperty.getPropertyId()).get();
        existingProperty.setPropertyAddress(newProperty.getPropertyAddress());
        existingProperty.setPropertyAvailablility(newProperty.getPropertyAvailablility());
        existingProperty.setPropertyName(newProperty.getPropertyName());
        existingProperty.setPropertyDescription(newProperty.getPropertyDescription());
        existingProperty.setPropertyImage(newProperty.getPropertyImage());
        return propertyRepo.save(existingProperty);
    }

    // delete property by Id
    public String deleteProperty(String propertyId) {
        propertyRepo.deleteById(propertyId);
        return "property with the id " + propertyId + "deleted with success";
    }

    
}
