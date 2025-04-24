package edu.estatuas.guess_dispatchers;

import static org.junit.Assert.assertEquals;
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
}
