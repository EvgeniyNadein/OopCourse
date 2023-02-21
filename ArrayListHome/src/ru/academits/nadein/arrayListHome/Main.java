package ru.academits.nadein.arrayListHome;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new File("E:\\OopCourse\\ArrayListHome\\src\\textFile.txt"))) {
            ArrayList<String> stringsFromFile = new ArrayList<>();

            while (scanner.hasNextLine()) {
                String currentString = scanner.nextLine();
                stringsFromFile.add(currentString);
            }

            System.out.println(stringsFromFile.size());
            System.out.println(stringsFromFile);
            boolean isEmpty = stringsFromFile.isEmpty();
            System.out.println(isEmpty);

            for (String s : stringsFromFile) {
                System.out.println(s);
            }
        }

        System.out.println();

        ArrayList<Integer> integers1 = new ArrayList<>(Arrays.asList(1, 2, 4, 5, 7, 8, 9));
        int number1;

        for (int i = 0; i < integers1.size(); i++) {
            number1 = integers1.get(i);

            if (number1 % 2 == 0) {
                integers1.remove(i);
                i -= 1;
            }
        }

        System.out.println(integers1);
        System.out.println();

        ArrayList<Integer> integers2 = new ArrayList<>(Arrays.asList(1, 2, 4, 1, 1, 5, 2, 7, 8, 5, 9));
        ArrayList<Integer> integers2WithoutRepeat = new ArrayList<>(integers2);

        for (int i = 0; i < integers2WithoutRepeat.size(); i++) {

            if (integers2WithoutRepeat.lastIndexOf(integers2WithoutRepeat.get(i)) > i) {
                integers2WithoutRepeat.remove(integers2WithoutRepeat.lastIndexOf(integers2WithoutRepeat.get(i)));
                i -= 1;
            }
        }

        System.out.println(integers2WithoutRepeat);
    }
}