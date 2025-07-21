package com.in28minutes.microservices.currency_exchange_service.service;

import com.in28minutes.microservices.currency_exchange_service.entity.CurrencyExchangeEntity;
import com.in28minutes.microservices.currency_exchange_service.model.CurrencyExchange;
import com.in28minutes.microservices.currency_exchange_service.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("currencyExchangeService")
public class CurrencyExchangeService {

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;


    public List<CurrencyExchangeEntity> findAllCurrencyExchangeRates() {

        return currencyExchangeRepository.findAll();
    }

    public CurrencyExchange findByFromAndTo(String fromCurr, String toCurr) {
        CurrencyExchangeEntity currencyExchangeEntity = currencyExchangeRepository.findByFromCurrAndToCurr(fromCurr, toCurr);
        CurrencyExchange currencyExchange = CurrencyExchange.builder()
                .id(currencyExchangeEntity.getId())
                .conversionMultiple(currencyExchangeEntity.getConversionMultiple())
                .environment(currencyExchangeEntity.getEnvironment())
                .fromCurr(currencyExchangeEntity.getFromCurr())
                .toCurr(currencyExchangeEntity.getToCurr())
                .build();
        return currencyExchange;
    }
}
