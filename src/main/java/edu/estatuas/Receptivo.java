package edu.estatuas;

import java.util.ArrayList;
import java.util.List;

import edu.estatuas.interfaces.GuestDispatcher;
import edu.estatuas.interfaces.PaymentMethod;

public class Receptivo {
    
    private final List<GuestDispatcher> guestDispatchers = new ArrayList<>();
    private static Receptivo instance = null;

    private Receptivo() {}

    public static Receptivo getInstance() {
        if (instance == null) {
            instance = new Receptivo();
        }
        return instance;
    } 

    List<GuestDispatcher> getGuestDispatchers() {
        return guestDispatchers;
    }

    public void registra(GuestDispatcher guestDispatcher)  {
        getGuestDispatchers().add(guestDispatcher);
    }

    public void dispatch(PaymentMethod payment) {
        getGuestDispatchers().stream().forEach(g -> g.dispatch(payment));
    }

}
