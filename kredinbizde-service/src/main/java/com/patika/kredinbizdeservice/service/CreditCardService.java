package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.exceptions.KredinbizdeException;
import com.patika.kredinbizdeservice.model.CreditCard;
import com.patika.kredinbizdeservice.repository.CreditCardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
@RequiredArgsConstructor
public class CreditCardService implements ICreditCardService {

    private final CreditCardRepository creditCardRepository;


    @Override
    @Transactional(value = Transactional.TxType.REQUIRES_NEW, rollbackOn = KredinbizdeException.class)
    public CreditCard save(CreditCard creditCard) {
        System.out.println("creditCardRepository: " + creditCardRepository.hashCode());

        creditCardRepository.save(creditCard);

        return creditCard;
    }

    @Override
    public List<CreditCard> getAll() {
        System.out.println("creditCardRepository: " + creditCardRepository.hashCode());
        return creditCardRepository.findAll();
    }

    @Override
    public List<CreditCard> getByBankName(String bankName) {
        List<CreditCard> foundCreditCardList = creditCardRepository.findByBankName(bankName);

        if(foundCreditCardList != null){
            return foundCreditCardList;

        }
        return null;
    }
}
