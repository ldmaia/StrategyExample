package com.example.adapter;

import com.example.adapter.gateway.PaymentStrategy;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class CreditCardStrategy implements PaymentStrategy {

    private String name;
    private String cardNumber;
    private String cvv;
    private String dateOfExpiry;


    @Override
    public void pay(int amount) {
        log.info(amount + " paid with credit/debit card");
    }
}
