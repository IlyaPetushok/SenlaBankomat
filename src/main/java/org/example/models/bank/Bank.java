package org.example.models.bank;

import org.example.models.Card;
import org.example.service.bank.Reader;

import java.util.List;

public abstract class Bank {
//    public static Bank instance=new Bank();
//    public static Bank getInstance(){
//        return instance;
//    }

//    {
//        cards= Reader.getCards();
//    }
//
//    private List<Card> cards;
    public abstract String getIdBank();

    public abstract List<Card> getCards();

    public abstract void setCards(List<Card> cards);
}
