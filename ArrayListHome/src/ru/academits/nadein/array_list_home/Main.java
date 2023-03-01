package ru.academits.nadein.array_list_home;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            Path path = Paths.get("ArrayListHome\\src\\textFile.txt");
            FileReader fileReader = new FileReader(String.valueOf(path));
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            ArrayList<String> stringsFromFile = new ArrayList<>();
            String currentLine = bufferedReader.readLine();

            while (currentLine != null) {
                stringsFromFile.add(currentLine);
                currentLine = bufferedReader.readLine();
            }

            System.out.println("Количество элементов в списке (строк): " + stringsFromFile.size());
            System.out.println();
            System.out.println("Список: " + stringsFromFile);
            System.out.println();
            boolean isEmpty = stringsFromFile.isEmpty();
            System.out.println("Список не содержит элементов: " + isEmpty);
            System.out.println();
            System.out.println("Построчный вывод списка: ");

            for (String s : stringsFromFile) {
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();

        ArrayList<Integer> integers1 = new ArrayList<>(Arrays.asList(1, 2, 4, 5, 7, 8, 9));

        for (int i = 0; i < integers1.size(); i++) {
            if (integers1.get(i) % 2 == 0) {
                integers1.remove(i);
                --i;
            }
        }

        System.out.println("Список без четных чисел: " + integers1);
        System.out.println();

        ArrayList<Integer> integers2 = new ArrayList<>(Arrays.asList(1, 2, 4, 1, 1, 5, 2, 7, 8, 5, 9));
        ArrayList<Integer> integers2WithoutRepeat = new ArrayList<>();

        for (int i = 0; i < integers2.size(); i++) {
            int currentElement = integers2.get(i);
            if (integers2.indexOf(currentElement) == i) {
                integers2WithoutRepeat.add(currentElement);
            }
        }

        System.out.println("Список без повторений: " + integers2WithoutRepeat);
    }
}