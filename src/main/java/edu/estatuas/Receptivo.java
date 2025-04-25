package edu.estatuas;

import java.util.ArrayList;
import java.util.List;

import edu.estatuas.interfaces.GuestDispatcher;

public class Receptivo {
    
    private final List<GuestDispatcher> guestDispatchers = new ArrayList<>();

    List<GuestDispatcher> getGuestDispatchers() {
        return guestDispatchers;
    }

    public void registra(GuestDispatcher guestDispatcher)  {
        getGuestDispatchers().add(guestDispatcher);
    }

    void dispatch(CreditCard creditCard) {
        getGuestDispatchers().stream().forEach(g -> g.dispatch(creditCard));
    }

}
