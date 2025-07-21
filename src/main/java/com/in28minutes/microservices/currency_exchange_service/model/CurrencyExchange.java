package com.in28minutes.microservices.currency_exchange_service.model;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CurrencyExchange {

    private Long id;

    private String fromCurr;

    private String toCurr;

    private BigDecimal conversionMultiple;

    private String environment;

}
