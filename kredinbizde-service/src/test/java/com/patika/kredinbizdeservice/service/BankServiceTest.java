package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.repository.BankRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class BankServiceTest {
    @Mock
    private BankRepository bankRepository;

    @InjectMocks
    private BankService bankService;


    @Test
    public void testSaveBank() {
        Bank bank = new Bank();

        when(bankRepository.save(bank)).thenReturn(bank);

        Bank savedBank = bankService.save(bank);

        assertNotNull(savedBank);
        assertEquals(bank, savedBank);

        verify(bankRepository, times(1)).save(bank);
    }

    @Test
    public void testGetAllBanks() {
        List<Bank> bankList = new ArrayList<>();

        when(bankRepository.findAll()).thenReturn(bankList);

        List<Bank> allBanks = bankService.getAll();

        assertNotNull(allBanks);
        assertEquals(bankList.size(), allBanks.size());

        verify(bankRepository, times(1)).findAll();
    }

    @Test
    public void testGetBanksByName() {

        List<Bank> bankList = new ArrayList<>();

        when(bankRepository.findByName(prepareBank().getName())).thenReturn(bankList);

        List<Bank> banksByName = bankService.getByName(prepareBank().getName());

        assertNotNull(banksByName);
        assertEquals(bankList.size(), banksByName.size());

        verify(bankRepository, times(1)).findByName(prepareBank().getName());
    }

    private Bank prepareBank(){
        Bank bank = new Bank();
        bank.setBankId(1L);
        bank.setName("test name");

        return bank;
    }
}
