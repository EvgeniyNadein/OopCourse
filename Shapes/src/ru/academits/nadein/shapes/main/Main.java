package ru.academits.nadein.shapes.main;

import ru.academits.nadein.shapes.areaComparator.MaxShapesAreaComparator;
import ru.academits.nadein.shapes.circle.Circle;
import ru.academits.nadein.shapes.perimeterComparator.MaxShapesPerimeterComparator;
import ru.academits.nadein.shapes.rectangle.Rectangle;
import ru.academits.nadein.shapes.shape.Shape;
import ru.academits.nadein.shapes.triangle.Triangle;
import ru.academits.nadein.shapes.square.Square;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Square square1 = new Square(2);

        System.out.println("������� �������� = " + square1.getArea());
        System.out.println("�������� �������� = " + square1.getPerimeter());
        System.out.println("������ �������� = " + square1.getHeight());
        System.out.println("������ �������� = " + square1.getWidth());

        System.out.println();

        Rectangle rectangle = new Rectangle(2, 4);

        System.out.println("������� �������������� = " + rectangle.getArea());
        System.out.println("�������� �������������� = " + rectangle.getPerimeter());
        System.out.println("������ �������������� = " + rectangle.getHeight());
        System.out.println("������ �������������� = " + rectangle.getWidth());

        System.out.println();

        Circle circle = new Circle(4);

        System.out.println("������� ���������� = " + circle.getArea());
        System.out.println("�������� ���������� = " + circle.getPerimeter());
        System.out.println("������ ���������� = " + circle.getHeight());
        System.out.println("������ ���������� = " + circle.getWidth());

        System.out.println();

        Triangle triangle = new Triangle(2, 1, 2, 8, 8, 1);

        System.out.println("������� ������������ = " + triangle.getArea());
        System.out.println("�������� ������������ = " + triangle.getPerimeter());
        System.out.println("������ ������������ = " + triangle.getHeight());
        System.out.println("������ ������������ = " + triangle.getWidth());

        System.out.println();

        Square square2 = new Square(3.5);

        System.out.println("������� �������� 2 = " + square2.getArea());
        System.out.println("�������� �������� 2 = " + square2.getPerimeter());
        System.out.println("������ �������� 2 = " + square2.getHeight());
        System.out.println("������ �������� 2 = " + square2.getWidth());

        System.out.println();

        Shape[] array = {square1, rectangle, circle, triangle, square2};

        Arrays.sort(array, new MaxShapesAreaComparator());
        System.out.println("���������� ������� �����: " + array[0].toString());

        Arrays.sort(array, new MaxShapesPerimeterComparator());
        System.out.println("������ ������� ������ �� �������� ��������: " + array[1].toString());
    }
}