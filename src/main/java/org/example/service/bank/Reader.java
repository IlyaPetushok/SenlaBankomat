package org.example.service.bank;

import org.example.models.Card;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    public static List<Card> getCards(String idBank) {
        List<Card> cards = new ArrayList<>();
        String line;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/cards.txt"));
            while ((line = bufferedReader.readLine()) != null) {
                if (line.substring(18,22).equals(idBank)) {
                    cards.add(createObject(line));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Невозможно найти файл!");
            e.printStackTrace();
        } catch (IOException exception) {
            System.out.println("Ошибка чтения/записи файла");
            exception.printStackTrace();
        }
        return cards;
    }

    private static Card createObject(String line) {
        Card card = new Card();
        card.setNumberCards(line.substring(18, 37));
        card.setPinCode(line.substring(49, 53));
        card.setCash(Integer.parseInt(line.substring(line.indexOf("cash=") + 5, line.indexOf(",", line.indexOf("cash=")))));
        card.setBlock(Boolean.parseBoolean(line.substring(line.indexOf("block=") + 6, line.indexOf("}", line.indexOf("block=")))));
        return card;
    }
}
