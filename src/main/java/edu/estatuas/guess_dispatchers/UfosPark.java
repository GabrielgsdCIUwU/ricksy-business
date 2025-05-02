package edu.estatuas.guess_dispatchers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.estatuas.CreditCard;
import edu.estatuas.interfaces.GuestDispatcher;

public class UfosPark implements GuestDispatcher {
    private double fee = 500.0;
    private final Map<String, String> flota = new HashMap<>();
    private final List<String> creditCards = new ArrayList<>();

    public void add(String vehicle) {
        getFlota().put(vehicle, null);
    }

    Map<String, String> getFlota() {
        return flota;
    }

    private List<String> getCreditCards() {
        return creditCards;
    }

    private void addCreditCard(String creditCardNumber) {
        creditCards.add(creditCardNumber);
    }

    public String getUfoOf(String creditNumber) {
        for (Map.Entry<String, String> entry : getFlota().entrySet()) {
            String vehicle = entry.getKey();
            String entryCreditNumber = entry.getValue();
            if (creditNumber.equals(entryCreditNumber)) {
                return vehicle;
            }
        }
        return null;
    }

    @Override
    public void dispatch(CreditCard creditCard) {
        String creditCardNumber = creditCard.number();
        if (!getCreditCards().contains(creditCardNumber)) {
            for (String ovni : getFlota().keySet()) {
                if (getFlota().get(ovni) == null && creditCard.pay(fee)) {
                    getFlota().put(ovni, creditCardNumber);
                    addCreditCard(creditCardNumber);
                    break;
                }
            }

        }
    }

    @Override
    public String toString() {
        return getFlota().keySet().toString();
    }

}
