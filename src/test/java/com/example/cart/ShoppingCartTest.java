package com.example.cart;

import com.example.adapter.CreditCardStrategy;
import com.example.adapter.PaypalStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class ShoppingCartTest {
    @Mock
    private List<Item> items;
    @InjectMocks
    private ShoppingCart shoppingCart;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("shouldReturnPaypalStrategy_WhenPayPalStrategyIsCalled")
    void testPaypalStrategy() {

        var itemsList = createItems();


        when(items.add(any())).thenReturn(true);

        ShoppingCart cart = new ShoppingCart();


        cart.addItem(itemsList.get(0));
        cart.addItem(itemsList.get(1));

        //pay by paypal
        PaypalStrategy paypalStrategy = new PaypalStrategy();
        paypalStrategy.setPassword("mypwd");
        paypalStrategy.setEmailId("myemail@example.com");
        cart.pay(paypalStrategy);

        //pay by credit card
        CreditCardStrategy card = new CreditCardStrategy();
        card.setCardNumber("1234567890123456");
        card.setCvv("786");
        card.setDateOfExpiry("12/15");
        card.setName("Pankaj Kumar");
        cart.pay(card);

    }

    @Test
    @DisplayName("shouldReturnCreditCardStrategy_WhenCreditCardStrategyIsCalled")
    void testCreditCardStrategy() {

        var itemsList = createItems();


        when(items.add(any())).thenReturn(true);

        ShoppingCart cart = new ShoppingCart();


        cart.addItem(itemsList.get(0));
        cart.addItem(itemsList.get(1));

        //pay by credit card
        CreditCardStrategy card = new CreditCardStrategy();
        card.setCardNumber("1234567890123456");
        card.setCvv("786");
        card.setDateOfExpiry("12/15");
        card.setName("Pankaj Kumar");
        cart.pay(card);

    }

    @Test
    void testAddItem() {
        shoppingCart.addItem(new Item());
    }

    @Test
    void testRemoveItem() {
        shoppingCart.removeItem(new Item());
    }

    public List<Item> createItems() {

        List<Item> items = new ArrayList<>();

        Item item1 = new Item();
        item1.setPrice(10);
        item1.setUpcCode("1234");


        Item item2 = new Item();

        item2.setPrice(40);
        item2.setUpcCode("5678");

        items.add(item1);
        items.add(item2);

        return items;

    }

}