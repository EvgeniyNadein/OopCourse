package ru.academits.nadein.main;

import ru.academits.nadein.circle.Circle;
import ru.academits.nadein.rectangle.Rectangle;
import ru.academits.nadein.square.Square;
import triangle.Triangle;

public class Main {
    public static void main(String[] args) {
        Square square = new Square(2);

        System.out.println("������� �������� = " + square.getArea());
        System.out.println("�������� �������� = " + square.getPerimeter());
        System.out.println("������ �������� = " + square.getHeight());
        System.out.println("������ �������� = " + square.getWidth());

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

        Triangle triangle = new Triangle(2,1,2,8,8,1);

        System.out.println("������� ������������ = " + triangle.getArea());
        System.out.println("�������� ������������ = " + triangle.getPerimeter());
        System.out.println("������ ������������ = " + triangle.getHeight());
        System.out.println("������ ������������ = " + triangle.getWidth());
    }
}
