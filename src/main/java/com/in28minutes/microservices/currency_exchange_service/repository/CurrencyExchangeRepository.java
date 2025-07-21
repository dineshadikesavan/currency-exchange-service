package com.in28minutes.microservices.currency_exchange_service.repository;

import com.in28minutes.microservices.currency_exchange_service.entity.CurrencyExchangeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchangeEntity, Long> {

    public CurrencyExchangeEntity findByFromCurrAndToCurr (String fromCurr, String toCurr);
}
