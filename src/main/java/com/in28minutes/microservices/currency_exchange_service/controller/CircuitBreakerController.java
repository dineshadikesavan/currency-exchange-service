package com.in28minutes.microservices.currency_exchange_service.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import org.slf4j.Logger;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/retry-api")
    @Retry(name = "retry-api", fallbackMethod = "fallbackForRetryMethod")
    public String retryApi() {
        logger.info("Retry API call received.");
        ResponseEntity forEntity =  new RestTemplate().getForEntity("http://localhost:8080/dummyurl", String.class);
        return forEntity.getBody().toString();
    }

    public String fallbackForRetryMethod(Exception e) {
        return "Fallback Response: "+ e.getMessage();
    }

    @GetMapping("/circuit-breaker")
    @CircuitBreaker(name = "default", fallbackMethod = "fallbackForCircuitBreakerMethod")
    public String circuitBreaker() {
        logger.info("Circuit breaker API call received.");
        ResponseEntity forEntity =  new RestTemplate().getForEntity("http://localhost:8080/dummyurl", String.class);
        return forEntity.getBody().toString();
    }

    public String fallbackForCircuitBreakerMethod(Exception e) {
        return "Fallback for Circuit breaker Response: "+ e.getMessage();
    }

    @GetMapping("/rate-limiter")
    @RateLimiter(name = "default")
    public String rateLimiter() {
        logger.info("Rate limiter API call received.");
        ResponseEntity forEntity =  new RestTemplate().getForEntity("http://localhost:8080/dummyurl", String.class);
        return forEntity.getBody().toString();
    }

    @GetMapping("/bulk-head")
    @Bulkhead(name = "bulk-head")
    public String bulkHead() {
        logger.info("Bulk Head API call received.");
        ResponseEntity forEntity =  new RestTemplate().getForEntity("http://localhost:8080/dummyurl", String.class);
        return forEntity.getBody().toString();
    }

}
