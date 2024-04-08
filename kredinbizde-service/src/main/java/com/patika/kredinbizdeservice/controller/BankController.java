package com.patika.kredinbizdeservice.controller;

import com.patika.kredinbizdeservice.model.Bank;
import com.patika.kredinbizdeservice.service.IBankService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/banks")
@RequiredArgsConstructor
public class BankController {

    private final IBankService bankService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Bank create(@RequestBody Bank bank) {
        System.out.println("bankService: " + bankService.hashCode());
        return bankService.save(bank);
    }

    @GetMapping
    public List<Bank> getAll() {
        return bankService.getAll();
    }


    @GetMapping("/{name}")
    public List<Bank> getByName(@PathVariable String name) {

        return bankService.getByName(name);
    }

}
