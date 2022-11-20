package org.example.service.bank;

import org.example.models.Card;

import java.io.*;
import java.util.List;

public class WriteCards {
    public boolean writeCardsInFile(List<Card> cards) {
        File file = new File("src/main/resources", "cards.txt");
        try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file, false));) {
            file.createNewFile();
            for (Card card : cards) {
                outputStreamWriter.write(card.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при записи карты в файл," + e);
            return false;
        }
        return true;

    }
}
