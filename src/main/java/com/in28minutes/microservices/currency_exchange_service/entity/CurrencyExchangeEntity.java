package com.in28minutes.microservices.currency_exchange_service.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table(name = "currency_exchange")
public class CurrencyExchangeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fromCurr;

    private String toCurr;

    private BigDecimal conversionMultiple;

    private String environment;

}
