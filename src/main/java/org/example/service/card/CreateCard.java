package org.example.service.card;
import org.example.models.Bank;
import org.example.models.Card;
import java.util.*;

public class CreateCard {
    private final Bank bank=Bank.getInstance();
    private final StringBuilder numberCard=new StringBuilder();

    public CreateCard() {
        createCard();
    }

    private void createCard() {
        boolean flag = false;
        while (!flag) {
            generateNumberCardWithPin();
            flag=checkOnRepeat(numberCard.substring(0,19));
        }
        Card card=new Card(numberCard.substring(0,19),numberCard.substring(20,24));
        List<Card> cards=bank.getCards();
        cards.add(card);
        bank.setCards(cards);
        System.out.println("Карта успешно создана:"+card);
    }

    private void generateNumberCardWithPin() {
        Random random = new Random();
        numberCard.setLength(0);
        int num;
        for (int i = 0; i <= 4; i++) {
            num = 10000 + random.nextInt(9999);
            numberCard.append(String.valueOf(num), 1, 5);
            numberCard.append(" ");
        }
    }

    private boolean checkOnRepeat(String numberCard) {
        return bank.getCards()
                .stream()
                .filter(card -> numberCard.equals(card.getNumberCards()))
                .findAny()
                .orElse(null) == null;
    }
}
