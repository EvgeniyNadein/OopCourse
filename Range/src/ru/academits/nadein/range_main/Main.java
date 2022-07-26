package ru.academits.nadein.range_main;

import ru.academits.nadein.range.Range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Range range1 = new Range(1, 100);
        Range range2 = new Range(100, 200);

        if (range1.getRangeCrossover(range1, range2) != null) {
            System.out.println("Начало диапазона пересечения = " + range1.getRangeCrossover(range1, range2).getFrom());
            System.out.println("Конец диапазона пересечения = " + range1.getRangeCrossover(range1, range2).getTo());
        } else {
            System.out.println("Интервал пересечения = " + range1.getRangeCrossover(range1, range2));
        }

        System.out.println();

        if (range1.getRangeUnion(range1, range2)[1] != null) {
            System.out.println("Начало объединенного интервала1 = " + range1.getRangeUnion(range1, range2)[0].getFrom());
            System.out.println("Конец объединенного интервала1 = " + range1.getRangeUnion(range1, range2)[0].getTo());

            System.out.println("Начало объединенного интервала2 = " + range1.getRangeUnion(range1, range2)[1].getFrom());
            System.out.println("Конец объединенного интервала2 = " + range1.getRangeUnion(range1, range2)[1].getTo());
        } else {
            System.out.println("Начало объединенного интервала = " + range1.getRangeUnion(range1, range2)[0].getFrom());
            System.out.println("Конец объединенного интервала = " + range1.getRangeUnion(range1, range2)[0].getTo());
        }

        System.out.println();

        if (range1.getRangeDifference(range1, range2)[1] != null) {
            System.out.println("Начало 1 разности интервалов = " + range1.getRangeDifference(range1, range2)[0].getFrom());
            System.out.println("Конец 1 разности интервалов = " + range1.getRangeDifference(range1, range2)[0].getTo());

            System.out.println("Начало 2 разности интервалов = " + range1.getRangeDifference(range1, range2)[1].getFrom());
            System.out.println("Конец 2 разности интервалов = " + range1.getRangeDifference(range1, range2)[1].getTo());
        } else if (range1.getRangeDifference(range1, range2)[0] != null){
            System.out.println("Начало разности интервалов = " + range1.getRangeDifference(range1, range2)[0].getFrom());
            System.out.println("Конец разности интервалов = " + range1.getRangeDifference(range1, range2)[0].getTo());
        } else {
            System.out.println("Разность интервалов = " + range1.getRangeDifference(range1, range2)[0]);
        }

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