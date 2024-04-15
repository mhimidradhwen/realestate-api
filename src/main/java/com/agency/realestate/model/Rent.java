package com.agency.realestate.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Document(collection = "rents")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Rent {
    
    @Id
    private String rentId;
    
    private String propertyId; // Reference to Property document
    
    private Date startDate;
    
    private Date endDate;
    
    private double monthlyPrice;
    
    private String renterName;

}


