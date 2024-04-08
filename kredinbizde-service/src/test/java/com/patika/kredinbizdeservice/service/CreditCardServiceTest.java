package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.model.CreditCard;
import com.patika.kredinbizdeservice.repository.CreditCardRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CreditCardServiceTest {
    @Mock
    private CreditCardRepository creditCardRepository;

    @InjectMocks
    private CreditCardService creditCardService;


    @Test
    public void testSaveCreditCard() {
        CreditCard creditCard = prepareCreditCard();

        when(creditCardRepository.save(creditCard)).thenReturn(creditCard);

        CreditCard savedCreditCard = creditCardService.save(creditCard);

        assertNotNull(savedCreditCard);
        assertEquals(creditCard, savedCreditCard);

        verify(creditCardRepository, times(1)).save(creditCard);
    }

    @Test
    public void testGetAllCreditCards() {
        List<CreditCard> creditCardList = new ArrayList<>();

        when(creditCardRepository.findAll()).thenReturn(creditCardList);

        List<CreditCard> allCreditCards = creditCardService.getAll();

        assertNotNull(allCreditCards);
        assertEquals(creditCardList.size(), allCreditCards.size());

        verify(creditCardRepository, times(1)).findAll();
    }

    @Test
    public void testGetCreditCardsByBankName() {

        List<CreditCard> creditCardList = new ArrayList<>();

        when(creditCardRepository.findByBankName(prepareBank().getName())).thenReturn(creditCardList);

        List<CreditCard> creditCardsByBankName = creditCardService.getByBankName(prepareBank().getName());

        assertNotNull(creditCardsByBankName);
        assertEquals(creditCardList.size(), creditCardsByBankName.size());

        verify(creditCardRepository, times(1)).findByBankName(prepareBank().getName());
    }

    @Test
    public void testGetCreditCardsByNonExistentBankName() {


        when(creditCardRepository.findByBankName(prepareBank().getName())).thenReturn(null);

        List<CreditCard> creditCardsByNonExistentBankName = creditCardService.getByBankName(prepareBank().getName());

        assertNull(creditCardsByNonExistentBankName);

        verify(creditCardRepository, times(1)).findByBankName(prepareBank().getName());
    }

    private CreditCard prepareCreditCard(){
        CreditCard creditCard = new CreditCard();
        creditCard.setId(1L);
        creditCard.setFee(new BigDecimal(100));
        creditCard.setBank(prepareBank());

        return creditCard;
    }

    private Bank prepareBank(){
        Bank bank = new Bank();
        bank.setBankId(1L);
        bank.setName("test name");

        return bank;
    }
}
