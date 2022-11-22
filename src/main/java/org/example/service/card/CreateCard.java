package org.example.service.card;
import org.example.models.*;
import org.example.models.bank.BTBBank;
import org.example.models.bank.Bank;
import org.example.models.bank.BelapromBank;
import org.example.models.bank.BelarusBank;
import org.example.service.bank.Writer;

import java.util.*;

public class CreateCard {
    private Bank bank;
    private final StringBuilder numberCard=new StringBuilder();
    Scanner in =new Scanner(System.in);

    public CreateCard() {
        createCard();
    }

    private void createCard() {
        boolean flag = false;
        choiceBank();
        while (!flag) {
            generateNumberCardWithPin(bank.getIdBank());
            flag=checkOnRepeat(numberCard.substring(0,19));
        }
        Card card=new Card(numberCard.substring(0,19),numberCard.substring(20,24));
        List<Card> cards=bank.getCards();
        cards.add(card);
        bank.setCards(cards);
        Writer.writeCardsInFile();
        System.out.println("Карта успешно создана:"+card);
    }

    private void choiceBank(){
        System.out.println("Выберите банк,карту которого хотите создать.\n1)BelarusBank\n2)BalapromBank\n3)BTBBank");
        int choiceBank=in.nextInt();
        switch (choiceBank) {
            case 1 -> bank = BelarusBank.getInstance();
            case 2 -> bank = BelapromBank.getInstance();
            case 3 -> bank = BTBBank.getInstance();
        }
    }

    private void generateNumberCardWithPin(String idBank) {
        Random random = new Random();
        numberCard.setLength(0);
        int num;
        numberCard.append(idBank).append(" ");
        for (int i = 0; i <= 3; i++) {
            num = 10000 + random.nextInt(9999);
            numberCard.append(String.valueOf(num), 1, 5);
            numberCard.append(" ");
        }
    }

    private boolean checkOnRepeat(String numberCard) {
        return Objects.isNull(bank.getCards()
                .stream()
                .filter(card -> numberCard.equals(card.getNumberCards()))
                .findAny()
                .orElse(null));
    }
}
