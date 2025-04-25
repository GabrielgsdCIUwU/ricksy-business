package edu.estatuas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import edu.estatuas.guess_dispatchers.CrystalExpender;
import edu.estatuas.guess_dispatchers.UfosPark;

public class ReceptivoTest {
    
    @Test
    public void testRegistra() {
        Receptivo receptivo = new Receptivo();

        CrystalExpender crystalExpender = new CrystalExpender(10, 10);
        UfosPark ufosPark = new UfosPark();
        ufosPark.add("UFO-1");
        
        receptivo.registra(crystalExpender);
        receptivo.registra(ufosPark);

        assertTrue(receptivo.getGuestDispatchers().contains(crystalExpender));
        assertTrue(receptivo.getGuestDispatchers().contains(ufosPark));
    }
    
    @Test
    public void testDispatch() {
        Receptivo receptivo = new Receptivo();

        CrystalExpender crystalExpender = new CrystalExpender(10, 10);
        UfosPark ufosPark = new UfosPark();
        ufosPark.add("UFO-1");
        
        receptivo.registra(crystalExpender);
        receptivo.registra(ufosPark);

        CreditCard card = new CreditCard("Abradolph Lincler", "4916119711304546");
        receptivo.dispatch(card);

        assertEquals(2490.0, card.credit(), 0.01);
    }

}
