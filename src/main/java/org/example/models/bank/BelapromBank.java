package org.example.models.bank;

import org.example.models.Card;
import org.example.service.bank.Reader;

import java.util.List;

public class BelapromBank extends Bank{
    private static final BelapromBank instance=new BelapromBank();
    public static BelapromBank getInstance(){
        return instance;
    }

    {
        cards= Reader.getCards(idBank);
    }

    private List<Card> cards;
    private static final String idBank="6546";

    @Override
    public String getIdBank() {
        return idBank;
    }

    @Override
    public List<Card> getCards() {
        return cards;
    }

    @Override
    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
