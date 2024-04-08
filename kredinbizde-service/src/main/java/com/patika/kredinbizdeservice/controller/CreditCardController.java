package com.patika.kredinbizdeservice.controller;

import com.patika.kredinbizdeservice.model.CreditCard;
import com.patika.kredinbizdeservice.service.ICreditCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/creditcards")
public class CreditCardController {


    private final ICreditCardService creditCardService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreditCard create(@RequestBody CreditCard creditCard) {
        System.out.println("creditCardService: " + creditCardService.hashCode());
        return creditCardService.save(creditCard);
    }

    @GetMapping
    public List<CreditCard> getAll() {

        return creditCardService.getAll();
    }


    @GetMapping("/{bankname}")
    public List<CreditCard> getByBankName(@PathVariable String bankname) {

        return creditCardService.getByBankName(bankname);
    }

}
