package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.CreditCard;

import java.util.List;

public interface ICreditCardService {
    CreditCard save(CreditCard creditCard);

    List<CreditCard> getAll();

    List<CreditCard> getByBankName(String bankName);
}
