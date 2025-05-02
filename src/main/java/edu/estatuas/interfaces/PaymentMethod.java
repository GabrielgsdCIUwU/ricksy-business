package edu.estatuas.interfaces;

public interface PaymentMethod {
    String number();
    double credit();
    boolean pay(double amount);
}
