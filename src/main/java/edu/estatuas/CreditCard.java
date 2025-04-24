package edu.estatuas;

public class CreditCard {
    private final String owner;
    private final String number;
    private double credit;
    private final String SYMBOL;

    public CreditCard(String owner, String number) {
        this.owner = owner;
        this.number = number;
        this.credit = 3000.0;
        this.SYMBOL = "EZI";
    }

    public String number() {
        return number;
    }

    public String cardOwner() {
        return owner;
    }

    public double credit() {
        return credit;
    }

    private String symbol() {
        return SYMBOL;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("owner: " + cardOwner()).append("\n");
        sb.append("number: " + number()).append("\n");
        sb.append("credit: " + credit() + symbol()).append("\n");

        return sb.toString();
    }
}
