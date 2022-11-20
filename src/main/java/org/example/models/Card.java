package org.example.models;

public class Card {
    private String numberCards;
    private String pinCode;
    private int cash;
    private boolean block;

    public Card() {
    }

    public Card(String numberCards, String pinCode) {
        this.numberCards = numberCards;
        this.block=false;
        this.pinCode=pinCode;
        this.cash=0;
    }

    public String getNumberCards() {
        return numberCards;
    }

    public void setNumberCards(String numberCards) {
        this.numberCards = numberCards;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public boolean isBlock() {
        return block;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    @Override
    public String toString() {
        return "Card{" +
                "numberCards='" + numberCards + '\'' +
                ", pinCode='" + pinCode + '\'' +
                ", cash=" + cash +
                ", block=" + block +
                '}';
    }
}
