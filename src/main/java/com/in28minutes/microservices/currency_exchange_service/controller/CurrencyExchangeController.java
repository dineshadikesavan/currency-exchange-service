package com.in28minutes.microservices.currency_exchange_service.controller;

import com.in28minutes.microservices.currency_exchange_service.model.CurrencyExchange;
import com.in28minutes.microservices.currency_exchange_service.service.CurrencyExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeService currencyExchangeService;

    @GetMapping("/currency-exchange/from/{fromCurr}/to/{toCurr}")
    public CurrencyExchange retreiveCurrencyExchangeValue(@PathVariable("fromCurr") String fromCurr, @PathVariable("toCurr") String toCurr) {
        String port = environment.getProperty("local.server.port");
        //return new CurrencyExchange(1L, "USD", "INR", BigDecimal.valueOf(86.5), port);
        return currencyExchangeService.findByFromAndTo(fromCurr, toCurr);
    }

}
