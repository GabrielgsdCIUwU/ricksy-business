package edu.estatuas.guess_dispatchers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import edu.estatuas.CreditCard;

public class RickMenuTest {
    @Test
    public void testGetItemCost() {
        double itemCost = 50.0;

        RickMenu expender = new RickMenu(10, itemCost);

        assertEquals(itemCost, expender.getItemCost(), 0.01);
    }

    @Test
    public void testGetStock() {
        int stock = 10;

        RickMenu expender = new RickMenu(stock, 50.0);

        assertEquals(stock, expender.getStock());

        CreditCard creditCard = new CreditCard("Rick", "123456789");
        expender.dispatch(creditCard);

        stock -= 1;

        assertEquals(stock, expender.getStock());
        assertEquals(2950.0, creditCard.credit(), 0.01);

        creditCard.pay(2950.0);

        assertEquals(stock, expender.getStock());
        assertEquals(0.0, creditCard.credit(), 0.01);
    }

    @Test
    public void testNoStock() {
        int stock = 0;

        RickMenu expender = new RickMenu(stock, 50.0);

        CreditCard creditCard = new CreditCard("Rick", "123456789");
        expender.dispatch(creditCard);

        assertEquals(stock, expender.getStock());
    }

    @Test
    public void testPaying() {
        RickMenu expender = new RickMenu(2, 50.0);

        CreditCard rickCreditCard = new CreditCard("Rick", "123456789");
        CreditCard mortyCreditCard = new CreditCard("Morty", "1234567890123456");
        
        expender.dispatch(rickCreditCard);

        assertEquals(1, expender.getStock());

        mortyCreditCard.pay(3000);

        expender.dispatch(mortyCreditCard);
        assertEquals(1, expender.getStock());
    }

    @Test
    public void testToString() {
        int stock = 2;
        double itemCost = 50.0;

        RickMenu expender = new RickMenu(stock, itemCost);

        String expectedMessage = "stock: 2\ncost: 50.0";

        assertEquals(expectedMessage, expender.toString());
    }
}
