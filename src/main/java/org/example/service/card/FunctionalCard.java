package org.example.service.card;

import org.example.models.Bankomat;
import org.example.models.Card;

import java.util.Scanner;

public class FunctionalCard {
    Bankomat bankomat = Bankomat.getInstance();
    Scanner in=new Scanner(System.in);

    public void workWithCard(Card card) {
        boolean flag = true;
        while (flag) {
            System.out.println("Выбеоте функцию:\n1)Просмотр суммы\n2)Пополнение баланса\n3)Cнятие денег\n4)Выход");
            int n = in.nextInt();
            switch (n) {
                case 1:
                    System.out.println("Ваша сумма:" + card.getCash());
                    break;
                case 2:
                    System.out.println("Введите сумму для пополнения:");
                    int addMoneyForCard = in.nextInt();
                    card.setCash(card.getCash() + addMoneyForCard);
                    bankomat.setMoneyInBankomat(bankomat.getMoneyInBankomat() + addMoneyForCard);
                    break;
                case 3:
                    System.out.println("Введите сумму которую хотите снять");
                    int minMoneyWithCard = in.nextInt();
                    if (card.getCash() >= minMoneyWithCard) {
                        if (bankomat.getMoneyInBankomat() >= minMoneyWithCard) {
                            card.setCash(card.getCash() - minMoneyWithCard);
                            bankomat.setMoneyInBankomat(bankomat.getMoneyInBankomat() - minMoneyWithCard);
                        } else {
                            System.out.println("Недостаточно средст в банкомате!");
                        }
                    } else {
                        System.out.println("Недостаточно средст на карте!");
                    }
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("Данной операции нету.\nВыберите из списка!!!");
                    break;
            }
        }
    }
}
