package com.patika.kredinbizdeservice.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        // Maps "type": "consumer" to the ConsumerLoan class
        @JsonSubTypes.Type(name = "consumer", value = ConsumerLoan.class),
        // Maps "type": "house" to the HouseLoan class
        @JsonSubTypes.Type(name = "house", value = HouseLoan.class),
        // Maps "type": "vehicle" to the VehicleLoan class
        @JsonSubTypes.Type(name = "vehicle", value = VechileLoan.class)
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "loan")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Loan implements Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "installment")
    private Integer installment;

    @Column(name = "interest_rate")
    private Double interestRate;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "bank_id")
    private Bank bank;


    public Loan(BigDecimal amount, Integer installment, Double interestRate) {
        this.amount = amount;
        this.installment = installment;
        this.interestRate = interestRate;
    }

    abstract void calculate(BigDecimal amount, int installment);



}
