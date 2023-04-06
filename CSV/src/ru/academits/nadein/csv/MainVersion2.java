package ru.academits.nadein.csv;

import java.io.*;
import java.util.ArrayList;

public class MainVersion2 {
    public static void main(String[] args) throws FileNotFoundException {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("CSV/src/ZadachaCSV2.csv"));
             PrintWriter writer = new PrintWriter("FileInHtml.html")) {
            ArrayList<String> linesFromFile = new ArrayList<>();
            String currentLine = bufferedReader.readLine();

            while (currentLine != null) {
                linesFromFile.add(currentLine);
                currentLine = bufferedReader.readLine();
            }







        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            System.out.println("Что то пошло не так, проверьте файл.");
        }
    }
}