package org.example.service.card;

import org.example.models.CashMachine;
import org.example.models.Card;
import org.example.service.bank.Writer;
import java.util.Scanner;

public class FunctionalCard {
    public static void workWithCard(Card card) {
        CashMachine cashMachine = CashMachine.getInstance();
        Scanner in=new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("Выбеоте функцию:\n1)Просмотр суммы\n2)Пополнение баланса\n3)Cнятие денег\n4)Выход");
            int n = in.nextInt();
            switch (n) {
                case 1 -> System.out.println("Ваша сумма:" + card.getCash());
                case 2 -> {
                    System.out.println("Введите сумму для пополнения:");
                    int addMoneyForCard = in.nextInt();
                    card.setCash(card.getCash() + addMoneyForCard);
                    cashMachine.setMoneyInCashMachine(cashMachine.getMoneyInCashMachine() + addMoneyForCard);
                    Writer.writeCardsInFile();
                }
                case 3 -> {
                    System.out.println("Введите сумму которую хотите снять");
                    int minMoneyWithCard = in.nextInt();
                    if (card.getCash() >= minMoneyWithCard && cashMachine.getMoneyInCashMachine() >= minMoneyWithCard) {
                        card.setCash(card.getCash() - minMoneyWithCard);
                        cashMachine.setMoneyInCashMachine(cashMachine.getMoneyInCashMachine() - minMoneyWithCard);
                        Writer.writeCardsInFile();
                    } else {
                        System.out.println("Недостаточно средст");
                    }
                }
                case 4 -> flag = false;
                default -> System.out.println("Данной операции нету.\nВыберите из списка!!!");
            }
        }
    }
}
