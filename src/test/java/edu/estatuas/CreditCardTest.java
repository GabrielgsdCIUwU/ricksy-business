package edu.estatuas;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CreditCardTest {
    @Test
    public void testCardOwner() {
        CreditCard card = new CreditCard("Abradolph Lincler", "4916119711304546");
        assertEquals("Abradolph Lincler", card.cardOwner());
    }

    @Test
    public void testCredit() {
        CreditCard card = new CreditCard("Abradolph Lincler", "4916119711304546");
        assertEquals(3000.0, card.credit(), 0.01);
    }

    @Test
    public void testNumber() {
        CreditCard card = new CreditCard("Abradolph Lincler", "4916119711304546");
        assertEquals("4916119711304546", card.number());
    }

    @Test
    public void testSuccesfulPay() {
        CreditCard card = new CreditCard("Abradolph Lincler", "4916119711304546");
        assertEquals(true, card.pay(1000.0));
        assertEquals(2000.0, card.credit(), 0.01);
    }

    @Test
    public void testUnsuccesfulPay() {
        CreditCard card = new CreditCard("Abradolph Lincler", "4916119711304546");
        assertEquals(false, card.pay(4000.0));
        assertEquals(3000.0, card.credit(), 0.01);
    }

    @Test
    public void testSymbol() {
        CreditCard card = new CreditCard("Abradolph Lincler", "4916119711304546");

        assertEquals("EZI", card.symbol());
    }
}
