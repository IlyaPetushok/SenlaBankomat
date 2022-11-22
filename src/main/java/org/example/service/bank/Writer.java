package org.example.service.bank;

import org.example.models.Card;
import org.example.models.bank.BTBBank;
import org.example.models.bank.Bank;
import org.example.models.bank.BelapromBank;
import org.example.models.bank.BelarusBank;

import java.io.*;
import java.util.List;

public class Writer {
    public static void writeCardsInFile() {
        Bank[] banks = {BelarusBank.getInstance(), BTBBank.getInstance(), BelapromBank.getInstance()};

        List<Card> cards;
        File file = new File("src/main/resources", "cards.txt");
        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file, false))) {
            file.createNewFile();
            for (Bank bank:banks) {
                cards=bank.getCards();
                for (Card card : cards) {
                    outputStreamWriter.write(card.toString() + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи карты в файл," + e);
        }
    }
}
