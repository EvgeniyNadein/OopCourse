package ru.academits.nadein.main;

import ru.academits.nadein.circle.Circle;
import ru.academits.nadein.rectangle.Rectangle;
import ru.academits.nadein.square.Square;
import triangle.Triangle;

public class Main {
    public static void main(String[] args) {
        Square square = new Square(2);

        System.out.println("Площадь квадрата = " + square.getArea());
        System.out.println("Периметр квадрата = " + square.getPerimeter());
        System.out.println("Высота квадрата = " + square.getHeight());
        System.out.println("Ширина квадрата = " + square.getWidth());

        System.out.println();

        Rectangle rectangle = new Rectangle(2, 4);

        System.out.println("Площадь прямоугольника = " + rectangle.getArea());
        System.out.println("Периметр прямоугольника = " + rectangle.getPerimeter());
        System.out.println("Высота прямоугольника = " + rectangle.getHeight());
        System.out.println("Ширина прямоугольника = " + rectangle.getWidth());

        System.out.println();

        Circle circle = new Circle(4);

        System.out.println("Площадь окружности = " + circle.getArea());
        System.out.println("Периметр окружности = " + circle.getPerimeter());
        System.out.println("Высота окружности = " + circle.getHeight());
        System.out.println("Ширина окружности = " + circle.getWidth());

        System.out.println();

        Triangle triangle = new Triangle(2,1,2,8,8,1);

        System.out.println("Площадь треугольника = " + triangle.getArea());
        System.out.println("Периметр треугольника = " + triangle.getPerimeter());
        System.out.println("Высота треугольника = " + triangle.getHeight());
        System.out.println("Ширина треугольника = " + triangle.getWidth());
    }
}
