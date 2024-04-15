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

import com.agency.realestate.model.Sale;
import com.agency.realestate.service.SaleService;

@RestController
@RequestMapping("sales/")
public class SaleController {

    @Autowired
    private SaleService saleService;

    // create a sale
    @PostMapping
    public ResponseEntity<?> createSale(@RequestBody Sale sale) {
        try {
            return new ResponseEntity<Sale>(saleService.createSale(sale), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // get a sale by id
    @GetMapping("/{saleId}")
    public ResponseEntity<?> getSaleById(@PathVariable String saleId) {
        try {
            return new ResponseEntity<Sale>(saleService.getSaleById(saleId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // get a sale by ownerId
    @GetMapping("/owner/{ownerId}")
    public ResponseEntity<?> getSaleByOwnerId(@PathVariable String ownerId) {
        try {
            return new ResponseEntity<List<Sale>>(saleService.getSalesByOwnerId(ownerId), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // get All Sales
    @GetMapping
    public ResponseEntity<?> getAllSales(){
        try {
            return new ResponseEntity<List<Sale>>(saleService.getAllSales(),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // update a sale
    @PutMapping
    public ResponseEntity<?> updateSale(@RequestBody Sale sale){
        try {
            return new ResponseEntity<Sale>(saleService.updateSale(sale),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    // delete a sale
    @DeleteMapping("/{saleId}")
    public ResponseEntity<?> deletdSaleById(@PathVariable String saleId){
        try {
            return new ResponseEntity<String>(saleService.deleteSaleById(saleId),HttpStatus.OK);            
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

}
