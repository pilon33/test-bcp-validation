package com.coralogix.calculator.controller;

import com.coralogix.calculator.model.ExchangeRate;
import com.coralogix.calculator.services.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("exchange-rate")
public class ExchangeController {
    @Autowired
    private AddService exchangeService;



    @GetMapping
    public ResponseEntity <List <ExchangeRate>> getAllExchangeRate(){

        return ResponseEntity.ok(exchangeService.getAllExchangeRate());
    }

    @GetMapping("/exchange")
    public ResponseEntity<ExchangeRate> getExchange(@RequestParam String originCurrency ,@RequestParam String finalCurrency){

        return ResponseEntity.ok(exchangeService.getEchangeRateApiCrrency(originCurrency,finalCurrency));
    }


}
