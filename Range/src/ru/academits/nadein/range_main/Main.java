package ru.academits.nadein.range_main;

import ru.academits.nadein.range.Range;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Range range1 = new Range(1, 100);
        Range range2 = new Range(100, 200);

        if (range1.getRangeCrossover(range1, range2) != null) {
            System.out.println("������ ��������� ����������� = " + range1.getRangeCrossover(range1, range2).getFrom());
            System.out.println("����� ��������� ����������� = " + range1.getRangeCrossover(range1, range2).getTo());
        } else {
            System.out.println("�������� ����������� = " + range1.getRangeCrossover(range1, range2));
        }

        System.out.println();

        if (range1.getRangeUnion(range1, range2)[1] != null) {
            System.out.println("������ ������������� ���������1 = " + range1.getRangeUnion(range1, range2)[0].getFrom());
            System.out.println("����� ������������� ���������1 = " + range1.getRangeUnion(range1, range2)[0].getTo());

            System.out.println("������ ������������� ���������2 = " + range1.getRangeUnion(range1, range2)[1].getFrom());
            System.out.println("����� ������������� ���������2 = " + range1.getRangeUnion(range1, range2)[1].getTo());
        } else {
            System.out.println("������ ������������� ��������� = " + range1.getRangeUnion(range1, range2)[0].getFrom());
            System.out.println("����� ������������� ��������� = " + range1.getRangeUnion(range1, range2)[0].getTo());
        }

        System.out.println();

        if (range1.getRangeDifference(range1, range2)[1] != null) {
            System.out.println("������ 1 �������� ���������� = " + range1.getRangeDifference(range1, range2)[0].getFrom());
            System.out.println("����� 1 �������� ���������� = " + range1.getRangeDifference(range1, range2)[0].getTo());

            System.out.println("������ 2 �������� ���������� = " + range1.getRangeDifference(range1, range2)[1].getFrom());
            System.out.println("����� 2 �������� ���������� = " + range1.getRangeDifference(range1, range2)[1].getTo());
        } else if (range1.getRangeDifference(range1, range2)[0] != null){
            System.out.println("������ �������� ���������� = " + range1.getRangeDifference(range1, range2)[0].getFrom());
            System.out.println("����� �������� ���������� = " + range1.getRangeDifference(range1, range2)[0].getTo());
        } else {
            System.out.println("�������� ���������� = " + range1.getRangeDifference(range1, range2)[0]);
        }

        System.out.println();

        System.out.println("������ ��������� = " + range1.getFrom());
        System.out.println("����� ��������� = " + range1.getTo());
        System.out.println("����� ��������� = " + range1.getLength());

        System.out.println("������� ����� ��� ����������� �������������� � ���������:");
        double number1 = scanner.nextDouble();

        System.out.println("����� " + number1 + " ����������� ���������: " + range1.isInside(number1));
        System.out.println();

        range1.setFrom(20);
        range1.setTo(80);

        System.out.println("������ ��������� = " + range1.getFrom());
        System.out.println("����� ��������� = " + range1.getTo());
        System.out.println("����� ��������� = " + range1.getLength());

        System.out.println("������� ����� ��� ����������� �������������� � ���������:");
        double number2 = scanner.nextDouble();

        System.out.println("����� " + number2 + " ����������� ���������: " + range1.isInside(number2));
    }
}