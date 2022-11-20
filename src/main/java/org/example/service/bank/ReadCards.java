package org.example.service.bank;

import org.example.models.Card;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCards {
    public static List<Card> getCards() {
        List<Card> cards=new ArrayList<>();
        String line = null;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/cards.txt"));
            while ((line = bufferedReader.readLine()) != null) {
                cards.add(createObject(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
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
