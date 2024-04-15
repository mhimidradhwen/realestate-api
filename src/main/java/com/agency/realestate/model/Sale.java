package com.agency.realestate.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "sales")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sale {
    
    @Id
    private String saleId;
    private String newOwnerId;
    private String newOwnerName;
    private String propertyId;
    private Date saledAt;
    private Double price;

}
