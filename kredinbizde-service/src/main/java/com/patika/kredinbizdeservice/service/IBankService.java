package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Bank;

import java.util.List;

public interface IBankService {

    Bank save(Bank bank);

    List<Bank> getAll();

    List<Bank> getByName(String name);
}
