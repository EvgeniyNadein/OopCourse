package ru.academits.nadein.range_main;

import ru.academits.nadein.range.Range;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Range range1 = new Range(1, 5);
        Range range2 = new Range(6, 8);

        System.out.println("Интервал пересечения = " + range1.getIntersection(range2));

        System.out.println();

        System.out.println("Объединение интервалов = " + Arrays.toString(range1.getUnion(range2)));

        System.out.println();

        System.out.println("Разность интервалов = " + Arrays.toString(range1.getDifference(range2)));

        System.out.println();

        System.out.println("Начало диапазона = " + range1.getFrom());
        System.out.println("Конец диапазона = " + range1.getTo());
        System.out.println("Длина диапазона = " + range1.getLength());

        System.out.println("Введите число для определения принадлежности к диапазону:");
        double number1 = scanner.nextDouble();

        System.out.println("Число " + number1 + " принадлежит диапазону: " + range1.isInside(number1));
        System.out.println();

        range1.setFrom(20);
        range1.setTo(80);

        System.out.println("Начало диапазона = " + range1.getFrom());
        System.out.println("Конец диапазона = " + range1.getTo());
        System.out.println("Длина диапазона = " + range1.getLength());

        System.out.println("Введите число для определения принадлежности к диапазону:");
        double number2 = scanner.nextDouble();

        System.out.println("Число " + number2 + " принадлежит диапазону: " + range1.isInside(number2));
    }
}