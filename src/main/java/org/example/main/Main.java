package org.example.main;

import org.example.models.Bank;
import org.example.models.Bankomat;
import org.example.models.Card;
import org.example.service.bank.WriteCards;
import org.example.service.card.CreateCard;
import org.example.service.card.FunctionalCard;
import org.example.service.card.InputCard;

import java.util.Scanner;

public class Main {
    public static Bankomat bankomat = Bankomat.getInstance();
    public static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        boolean flag = true;
        while (flag) {
            System.out.println("Выберите действие: \n1)Запрос на создание карты в банк;\n2)Работа с банкоматом;\n3)Выход");
            int n = in.nextInt();
            switch (n) {
                case 1:
                    CreateCard create = new CreateCard();
                    break;
                case 2:
                    if (!bankomat.isCard()) {
                        Card card;
                        bankomat.setCard(true);
                        InputCard inputCard = new InputCard();
                        if ((card=inputCard.inputCard())!=null) {
                            FunctionalCard functionalCard=new FunctionalCard();
                            functionalCard.workWithCard(card);
                        }
                        bankomat.setCard(false);
                    } else {
                        System.out.println("Банкомат занят!!!");
                    }
                    break;
                case 3:
                    System.out.println("Был осуществлён выход;");
                    WriteCards writeCards = new WriteCards();
                    Bank bank = Bank.getInstance();
                    writeCards.writeCardsInFile(bank.getCards());
                    flag = false;
                    break;
                default:
                    System.out.println("Данной операции нету.\nВыберите из списка!!!");
                    break;
            }
        }
    }
}
