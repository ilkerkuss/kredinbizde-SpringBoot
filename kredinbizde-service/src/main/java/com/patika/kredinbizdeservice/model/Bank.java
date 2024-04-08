package com.patika.kredinbizdeservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "bank")
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bankId;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
    private List<Loan> loanList;

    @JsonIgnore
    @OneToMany(mappedBy = "bank",cascade = CascadeType.ALL)
    private List<CreditCard> creditCards;


}
