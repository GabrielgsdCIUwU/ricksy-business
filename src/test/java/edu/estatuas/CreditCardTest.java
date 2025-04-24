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
}
