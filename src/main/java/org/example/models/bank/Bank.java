package org.example.models.bank;

import org.example.models.Card;
import java.util.List;

public abstract class Bank {
    public abstract String getIdBank();

    public abstract List<Card> getCards();

    public abstract void setCards(List<Card> cards);
}
