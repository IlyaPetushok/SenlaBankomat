package org.example.service.card;

import org.example.models.Bank;
import org.example.models.Card;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputCard {
    Bank bank = Bank.getInstance();
    Scanner in = new Scanner(System.in);

    public Card inputCard() {
        Card card = null;
        boolean flag = false;
        while (!flag) {
            System.out.println("Введите номер карты XXXX:XXXX:XXXX:XXXX(без пробела):");
            StringBuilder numberCard = new StringBuilder(in.nextLine());
            if (checkValidNumberCard(numberCard) != null) {
                card = bank.getCards()
                        .stream()
                        .filter(o -> numberCard.toString().equals(o.getNumberCards()))
                        .findAny()
                        .orElse(null);
                if (card != null) {
                    flag = true;
                }
            }
        }
        System.out.println(card);
        if (!card.isBlock()) {
            if (tryInputCard(card)) {
                System.out.println("Успешный вход");
                return card;
            }
        } else {
            System.out.println("Карта была заблокирована");
        }
        return null;
    }

    private boolean tryInputCard(Card card) {
        StringBuilder password;
        System.out.println("Введите PIN-CODE(XXXX):");
        for (int i = 3; i >= 0; i--) {
            if (i != 0) {
                password = new StringBuilder(in.next());
                while (!validPassword(password)) {
                    System.out.println("Был введеён не валидный номер!!!");
                    password = new StringBuilder(in.next());
                }
                if (card.getPinCode().equals(password.toString())) {
                    break;
                } else {
                    System.out.println("Был введен неверно пароль!!!\nОсталось " + (i - 1) + " попытки до блокировки");
                }
            } else {
                card.setBlock(true);
                System.out.println("Карта была заблокирована");
                return false;
            }
        }
        return true;
    }

    private String checkValidNumberCard(StringBuilder numberCard) {
        if (numberCard.length() == 16) {
            for (int i = 1; i <= 3; i++) {
                numberCard.insert(4 * i + i - 1, " ");
            }
            Pattern pattern = Pattern.compile("(\\d{4} ){3}\\d{4}");
            Matcher matcher = pattern.matcher(numberCard);
            if (matcher.matches()) {
                return numberCard.toString();
            }
        }
        return null;
    }

    private boolean validPassword(StringBuilder password) {
        Pattern pattern = Pattern.compile("\\d{4}");
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
