package com.patika.kredinbizdeservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@PrimaryKeyJoinColumn(name = "standart_creditcard_id")
public class StandartCreditCard extends CreditCard{

}
