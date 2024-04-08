package com.patika.kredinbizdeservice.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        // Maps "type": "standart" to the StandartCreditCard class
        @JsonSubTypes.Type(name = "standart", value = StandartCreditCard.class),
        // Maps "type": "gold" to the GoldCreditCard class
        @JsonSubTypes.Type(name = "gold", value = GoldCreditCard.class)
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "credit_card")
@Inheritance(strategy = InheritanceType.JOINED)
public class CreditCard implements Product{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fee")
    private BigDecimal fee;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "bank_id")
    private Bank bank;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Campaign> campaignList;


}
