package edu.estatuas.guess_dispatchers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.estatuas.CreditCard;

public class UfosParkTest {
    @Test
    public void testAdd() {
        UfosPark ufosPark = new UfosPark();
        String vehicle = "UFO-1";
        ufosPark.add(vehicle);
        
        assertTrue(ufosPark.getFlota().containsKey(vehicle));
    }

    @Test
    public void testDispatch() {
        UfosPark ufosPark = new UfosPark();
        String vehicle = "UFO-1";
        ufosPark.add(vehicle);

        CreditCard creditCard = new CreditCard("Morty", "1234567890123456");

        ufosPark.dispatch(creditCard);

        assertEquals(creditCard.number(), ufosPark.getFlota().get(vehicle));
    }

    @Test
    public void testGetUfoOf() {
        UfosPark ufosPark = new UfosPark();
        String vehicle = "UFO-1";
        ufosPark.add(vehicle);

        CreditCard creditCard = new CreditCard("Morty", "1234567890123456");
        ufosPark.dispatch(creditCard);

        assertEquals(vehicle, ufosPark.getUfoOf(creditCard.number()));
    }

    @Test
    public void testOneUfoPerCard() {
        UfosPark ufosPark = new UfosPark();
        String vehicle1 = "UFO-1";
        String vehicle2 = "UFO-2";
        ufosPark.add(vehicle1);
        ufosPark.add(vehicle2);

        CreditCard creditCard = new CreditCard("Morty", "1234567890123456");
        
        ufosPark.dispatch(creditCard);
        ufosPark.dispatch(creditCard);

        assertEquals(2500.0, creditCard.credit(), 0.01);
        assertNull(ufosPark.getFlota().get(vehicle2));
        assertEquals(vehicle1, ufosPark.getUfoOf(creditCard.number()));
    }

    @Test
    public void testNullUfo() {
        UfosPark ufosPark = new UfosPark();
        String vehicle1 = "UFO-1";

        ufosPark.add(vehicle1);

        CreditCard creditCard = new CreditCard("Morty", "1234567890123456");

        assertNull(ufosPark.getUfoOf(creditCard.number())); 
    }

    @Test
    public void testDispatchNoCredit() {
        UfosPark ufosPark = new UfosPark();
        String vehicle1 = "UFO-1";

        ufosPark.add(vehicle1);

        CreditCard mortyCreditCard = new CreditCard("Morty", "1234567890123456");

        mortyCreditCard.pay(3000.0);

        ufosPark.dispatch(mortyCreditCard);

        assertNull(ufosPark.getUfoOf(mortyCreditCard.number()));
    }
}
