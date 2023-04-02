package ru.academits.nadein.array_list_home;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("ArrayListHome/src/textFile.txt"))) {
            ArrayList<String> linesFromFile = new ArrayList<>();
            String currentLine = bufferedReader.readLine();

            while (currentLine != null) {
                linesFromFile.add(currentLine);
                currentLine = bufferedReader.readLine();
            }

            System.out.println("���������� ��������� � ������ (�����): " + linesFromFile.size());
            System.out.println();
            System.out.println("������: " + linesFromFile);
            System.out.println();
            boolean isEmpty = linesFromFile.isEmpty();
            System.out.println("������ �� �������� ���������: " + isEmpty);
            System.out.println();
            System.out.println("���������� ����� ������:");

            for (String s : linesFromFile) {
                System.out.println(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println("���� �� ������");
        } catch (IOException e) {
            System.out.println("��� �� ����� �� ���, ��������� ����.");
        }

        System.out.println();

        ArrayList<Integer> integers1 = new ArrayList<>(Arrays.asList(1, 2, 4, 5, 7, 8, 9));

        for (int i = 0; i < integers1.size(); i++) {
            if (integers1.get(i) % 2 == 0) {
                integers1.remove(i);
                --i;
            }
        }

        System.out.println("������ ��� ������ �����: " + integers1);
        System.out.println();

        ArrayList<Integer> integers2 = new ArrayList<>(Arrays.asList(1, 2, 4, 1, 1, 5, 2, 7, 8, 5, 9));
        ArrayList<Integer> integers2WithoutRepeats = new ArrayList<>(integers2.size());

        for (Integer currentElement : integers2) {
            if (!integers2WithoutRepeats.contains(currentElement)) {
                integers2WithoutRepeats.add(currentElement);
            }
        }

        System.out.println("������ ��� ����������: " + integers2WithoutRepeats);
    }
}