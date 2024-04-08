package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.exceptions.KredinbizdeException;
import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.repository.BankRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@RequiredArgsConstructor
public class BankService implements IBankService{

    private final BankRepository bankRepository;


    @Override
    @Transactional(value = Transactional.TxType.REQUIRES_NEW, rollbackOn = KredinbizdeException.class)
    public Bank save(Bank bank) {
        System.out.println("bankRepository: " + bankRepository.hashCode());

        bankRepository.save(bank);

        return bank;
    }

    @Override
    public List<Bank> getAll() {

        System.out.println("bankRepository: " + bankRepository.hashCode());
        return bankRepository.findAll();
    }

    @Override
    public List<Bank> getByName(String name) {

        return bankRepository.findByName(name);
    }
}
