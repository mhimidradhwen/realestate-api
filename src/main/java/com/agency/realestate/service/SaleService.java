package com.agency.realestate.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agency.realestate.model.Property;
import com.agency.realestate.model.Sale;
import com.agency.realestate.repository.PropertyRepository;
import com.agency.realestate.repository.SaleRepository;

@Service
public class SaleService {
    
    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private PropertyRepository propertyRepository;

    // get all sales
    public List<Sale> getAllSales(){
        return saleRepository.findAll();
    }

    // create a sale
    public Sale createSale(Sale sale) throws Exception{
        Optional<Property> property = propertyRepository.findById(sale.getPropertyId());
        if (property.isPresent()) {
            if (property.get().getIsArchived()) {
                throw new Exception("Property already saled");
            }
            else{
                if (property.get().getIsForSale()==false) {
                    throw new Exception("Property is not for sale");
                }
            }
        property.get().setIsArchived(true);
        propertyRepository.save(property.get());
        return saleRepository.save(sale);
        }
        throw new Exception("Property not exist");
    }

    // get sale by id
    public Sale getSaleById(String saleId) throws Exception{
        Optional<Sale> sale = saleRepository.findById(saleId);
        if (sale.isPresent()) {
            return sale.get();
        }
        throw new Exception("Sale not exist");
    }

    // get sales by ownerId
    public List<Sale> getSalesByOwnerId(String ownerId) throws Exception{
        List<Sale> sales = saleRepository.findAllByOwnerId(ownerId);
        if(sales.size()!=0){
            return sales;
        }
        throw new Exception("No Sales Exists");
    }

    //update sale
    public Sale updateSale(Sale newSale) throws Exception{
        Optional<Sale> existingSale = saleRepository.findById(newSale.getSaleId());
        if (existingSale.isPresent()) {
            existingSale.get().setNewOwnerId(newSale.getNewOwnerId());
            existingSale.get().setNewOwnerName(newSale.getNewOwnerName());
            existingSale.get().setPrice(newSale.getPrice());
            return saleRepository.save(existingSale.get());
        } 
        throw new Exception("Sale Not Exist");
    }

    // delete sale
    public String deleteSaleById(String saleId) throws Exception{
        Optional<Sale> sale = saleRepository.findById(saleId);
        if (sale.isPresent()) {
            saleRepository.deleteById(saleId);
            return "Sale with ID = "+saleId+"deleted with success";
        }
        throw new Exception("Sale Not Exist");
    }
}
