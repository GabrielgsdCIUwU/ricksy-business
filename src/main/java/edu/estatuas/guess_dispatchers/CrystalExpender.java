package edu.estatuas.guess_dispatchers;

import edu.estatuas.interfaces.GuestDispatcher;
import edu.estatuas.interfaces.PaymentMethod;

public class CrystalExpender implements GuestDispatcher {

    private int stock;
    private double itemCost;

    public CrystalExpender(int stock, double itemCost) {
        this.stock = stock;
        this.itemCost = itemCost;
    }

    public int getStock() {
        return stock;
    }

    public double getItemCost() {
        return itemCost;
    }

    private void reduceStock() {
        stock -= 1;
    }

    @Override
    public void dispatch(PaymentMethod payment) {
        if (getStock() > 0 && payment.pay(getItemCost())) {
            reduceStock();
        }
    }

    @Override
    public String toString() {
        return "stock: " + getStock() + "\n" + "cost: " + getItemCost();
    }
}
