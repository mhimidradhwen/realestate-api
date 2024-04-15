package com.agency.realestate.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Document(collection = "properties")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property {

    @Id
    private String propertyId;
    private String propertyName;
    private String propertyDescription;
    private String propertyAddress;
    private Boolean propertyAvailablility;
    private Date createdAt;
    private String propertyImage;
    private Double surface;
    private int nbRooms;
    private Boolean isArchived;
    private Boolean isForSale;
    
}
