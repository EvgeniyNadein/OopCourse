package ru.academits.nadein.main;

import ru.academits.nadein.circle.Circle;
import ru.academits.nadein.rectangle.Rectangle;
import ru.academits.nadein.shapes.Shape;
import ru.academits.nadein.square.Square;
import ru.academits.nadein.triangle.Triangle;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Square square1 = new Square(2, "square1");

        System.out.println("������� �������� = " + square1.getArea());
        System.out.println("�������� �������� = " + square1.getPerimeter());
        System.out.println("������ �������� = " + square1.getHeight());
        System.out.println("������ �������� = " + square1.getWidth());
        System.out.println("��� �������� = " + square1.getName());

        System.out.println();

        Rectangle rectangle = new Rectangle(2, 4, "rectangle");

        System.out.println("������� �������������� = " + rectangle.getArea());
        System.out.println("�������� �������������� = " + rectangle.getPerimeter());
        System.out.println("������ �������������� = " + rectangle.getHeight());
        System.out.println("������ �������������� = " + rectangle.getWidth());
        System.out.println("��� �������������� = " + rectangle.getName());

        System.out.println();

        Circle circle = new Circle(4, "circle");

        System.out.println("������� ���������� = " + circle.getArea());
        System.out.println("�������� ���������� = " + circle.getPerimeter());
        System.out.println("������ ���������� = " + circle.getHeight());
        System.out.println("������ ���������� = " + circle.getWidth());
        System.out.println("��� ���������� = " + circle.getName());

        System.out.println();

        Triangle triangle = new Triangle(2, 1, 2, 8, 8, 1, "triangle");

        System.out.println("������� ������������ = " + triangle.getArea());
        System.out.println("�������� ������������ = " + triangle.getPerimeter());
        System.out.println("������ ������������ = " + triangle.getHeight());
        System.out.println("������ ������������ = " + triangle.getWidth());
        System.out.println("��� ������������ = " + triangle.getName());

        System.out.println();

        Square square2 = new Square(3, "square2");

        System.out.println("������� �������� 2 = " + square2.getArea());
        System.out.println("�������� �������� 2 = " + square2.getPerimeter());
        System.out.println("������ �������� 2 = " + square2.getHeight());
        System.out.println("������ �������� 2 = " + square2.getWidth());
        System.out.println("��� �������� 2 = " + square2.getName());

        System.out.println();

        Shape[] array = new Shape[5];
        array[0] = square1;
        array[1] = rectangle;
        array[2] = circle;
        array[3] = triangle;
        array[4] = square2;

        Arrays.sort(array, Shape.areaComparator);
        System.out.println("������������� �� �������" + Arrays.toString(array));
    }
}
