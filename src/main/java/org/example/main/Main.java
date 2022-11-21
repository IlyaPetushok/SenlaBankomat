package org.example.main;

import org.example.models.bank.BTBBank;
import org.example.models.bank.Bank;
import org.example.models.CashMachine;
import org.example.models.Card;
import org.example.service.bank.Writer;
import org.example.service.card.CreateCard;
import org.example.service.card.FunctionalCard;
import org.example.service.card.InputCard;

import java.util.Scanner;

public class Main {
    public static CashMachine cashMachine = CashMachine.getInstance();
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
                    if (!cashMachine.isCard()) {
                        Card card;
                        cashMachine.setCard(true);
                        InputCard inputCard = new InputCard();
                        if ((card=inputCard.inputCard())!=null) {
                            FunctionalCard functionalCard=new FunctionalCard();
                            functionalCard.workWithCard(card);
                        }
                        cashMachine.setCard(false);
                    } else {
                        System.out.println("Банкомат занят!!!");
                    }
                    break;
                case 3:
                    System.out.println("Был осуществлён выход;");
                    flag = false;
                    break;
                default:
                    System.out.println("Данной операции нету.\nВыберите из списка!!!");
                    break;
            }
        }
    }
}
