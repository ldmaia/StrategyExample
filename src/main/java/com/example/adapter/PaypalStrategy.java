package com.example.adapter;

import com.example.adapter.gateway.PaymentStrategy;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaypalStrategy implements PaymentStrategy {

    private String emailId;
    private String password;

    @Override
    public void pay(int amount) {
        log.info(amount + " paid using Paypal.");
    }
}
