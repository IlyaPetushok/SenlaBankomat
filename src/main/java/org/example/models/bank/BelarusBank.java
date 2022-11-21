package org.example.models.bank;

import org.example.models.Card;
import org.example.service.bank.Reader;

import java.util.List;

public class BelarusBank extends Bank{
    private static final BelarusBank instance=new BelarusBank();
    public static BelarusBank getInstance(){
        return instance;
    }
    {
        cards= Reader.getCards(idBank);
    }

    private static final String idBank="8293";
    private List<Card> cards;

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
