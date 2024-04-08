package com.patika.kredinbizdeservice.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        // Maps "type": "consumer" to the ConsumerLoan class
        @JsonSubTypes.Type(name = "consumer", value = ConsumerLoan.class),
        // Maps "type": "house" to the HouseLoan class
        @JsonSubTypes.Type(name = "house", value = HouseLoan.class),
        // Maps "type": "vehicle" to the VehicleLoan class
        @JsonSubTypes.Type(name = "vehicle", value = VechileLoan.class) ,
        // Maps "type": "vehicle" to the VehicleLoan class
        @JsonSubTypes.Type(name = "standart", value = StandartCreditCard.class) ,
        // Maps "type": "vehicle" to the VehicleLoan class
        @JsonSubTypes.Type(name = "gold", value = GoldCreditCard.class)
})
public interface Product {

}
