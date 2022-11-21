package org.example.service.card;

import org.example.models.bank.Bank;
import org.example.models.Card;
import org.example.models.bank.TypeCardBank;
import org.example.service.bank.Writer;
import org.example.validation.Validator;
import org.example.validation.impl.ValidatorNumberCard;
import org.example.validation.impl.ValidatorPinCode;

import java.util.Scanner;

public class InputCard {
    Validator valid = null;
    Bank bank;
    Scanner in = new Scanner(System.in);

    public Card inputCard() {
        Card card = null;
        boolean flag = false;
        while (!flag) {
            System.out.println("Введите номер карты XXXX:XXXX:XXXX:XXXX(без пробела):");
            StringBuilder numberCard = new StringBuilder(in.nextLine());
            if (numberCard.length() == 16) {
                for (int i = 1; i <= 3; i++) {
                    numberCard.insert(4 * i + i - 1, " ");
                }
            }
            valid = new ValidatorNumberCard();
            if (valid.validator(numberCard)) {
                bank = TypeCardBank.getBankType(numberCard.substring(0, 4));
                card = bank.getCards()
                        .stream()
                        .filter(o -> numberCard.toString().equals(o.getNumberCards()))
                        .findAny()
                        .orElse(null);
                if (card != null) {
                    flag = true;
                }
            } else {
                System.out.println("Проверьте правильность данных!!!");
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
                valid = new ValidatorPinCode();
                while (!valid.validator(password)) {
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
                Writer.writeCardsInFile();
                System.out.println("Карта была заблокирована");
                return false;
            }
        }
        return true;
    }
}
