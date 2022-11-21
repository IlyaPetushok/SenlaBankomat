package org.example.models.bank;

import org.example.models.Card;
import org.example.service.bank.Reader;

import java.util.List;

public class BTBBank extends Bank {
    private static final BTBBank instance=new BTBBank();
    public static BTBBank getInstance(){
        return instance;
    }

    {
        cards= Reader.getCards(idBank);
    }

    private List<Card> cards;
    private static final String idBank="4356";

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
