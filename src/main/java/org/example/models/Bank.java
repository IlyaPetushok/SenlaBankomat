package org.example.models;

import org.example.service.bank.ReadCards;

import java.util.List;

public class Bank {
    public static Bank instance=new Bank();
    public static Bank getInstance(){
        return instance;
    }

    {
        cards= ReadCards.getCards();
    }

    private List<Card> cards;

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
