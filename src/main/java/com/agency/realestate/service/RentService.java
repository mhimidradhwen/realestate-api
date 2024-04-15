package com.agency.realestate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agency.realestate.model.Property;
import com.agency.realestate.model.Rent;
import com.agency.realestate.repository.PropertyRepository;
import com.agency.realestate.repository.RentRepository;

@Service
public class RentService {

    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    // create a rent
    public Rent createRent(Rent rent) throws Exception {
        Optional<Property> propertyOptional = propertyRepository.findById(rent.getPropertyId());
        if (propertyOptional.isPresent()) {
            if ((propertyOptional.get().getPropertyAvailablility() == false)| (propertyOptional.get().getIsArchived())) {
                throw new Exception("Property not avialbale");
            } else {
                if (propertyOptional.get().getIsForSale()) {
                    throw new Exception("Property is for sale not for rent");
                }
                propertyOptional.get().setPropertyAvailablility(false);
                propertyRepository.save(propertyOptional.get());
                return rentRepository.save(rent);
            }
        }
        throw new Exception("Property Not Exist");
    }

    // get All rents
    public List<Rent> getAllRents(){
        return rentRepository.findAll();
    }

    // get Rent by Id
    public Rent getRentById(String rentId){
        return rentRepository.findById(rentId).get();
    }

    // get Rents by renterId
    public List<Rent> getRentsByRenterId(String renterId) throws Exception{
        List<Rent> rents = rentRepository.findAllByRenterId(renterId);
        if(rents.size()!=0){
            return rents;
        }
        throw new Exception("No Rents Exists");
    }

    // update a rent
    public Rent updateRent(Rent newRent) throws Exception{
        Optional<Rent> existingRent = rentRepository.findById(newRent.getRentId());
        if (existingRent.isPresent()) {
            existingRent.get().setEndDate(newRent.getEndDate());
            existingRent.get().setMonthlyPrice(newRent.getMonthlyPrice());
            existingRent.get().setRenterId(newRent.getRenterId());
            return rentRepository.save(existingRent.get());
        }
        throw new Exception("Rent not exist");
    }


    //delete a rent
    public String deleteRentById(String rentId) throws Exception{
        Optional<Rent> rent = rentRepository.findById(rentId);
        if (rent.isPresent()) {
            Optional<Property> property = propertyRepository.findById(rent.get().getPropertyId());
            property.get().setPropertyAvailablility(true);
            propertyRepository.save(property.get());
            rentRepository.deleteById(rentId);
            return "Rent with ID = "+"deleted with success";
        }
        throw new Exception("Rent Not Exist");
    }

}
