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

        System.out.println("Площадь квадрата = " + square1.getArea());
        System.out.println("Периметр квадрата = " + square1.getPerimeter());
        System.out.println("Высота квадрата = " + square1.getHeight());
        System.out.println("Ширина квадрата = " + square1.getWidth());
        System.out.println("Имя квадрата = " + square1.getName());

        System.out.println();

        Rectangle rectangle = new Rectangle(2, 4, "rectangle");

        System.out.println("Площадь прямоугольника = " + rectangle.getArea());
        System.out.println("Периметр прямоугольника = " + rectangle.getPerimeter());
        System.out.println("Высота прямоугольника = " + rectangle.getHeight());
        System.out.println("Ширина прямоугольника = " + rectangle.getWidth());
        System.out.println("Имя прямоугольника = " + rectangle.getName());

        System.out.println();

        Circle circle = new Circle(4, "circle");

        System.out.println("Площадь окружности = " + circle.getArea());
        System.out.println("Периметр окружности = " + circle.getPerimeter());
        System.out.println("Высота окружности = " + circle.getHeight());
        System.out.println("Ширина окружности = " + circle.getWidth());
        System.out.println("Имя окружности = " + circle.getName());

        System.out.println();

        Triangle triangle = new Triangle(2, 1, 2, 8, 8, 1, "triangle");

        System.out.println("Площадь треугольника = " + triangle.getArea());
        System.out.println("Периметр треугольника = " + triangle.getPerimeter());
        System.out.println("Высота треугольника = " + triangle.getHeight());
        System.out.println("Ширина треугольника = " + triangle.getWidth());
        System.out.println("Имя треугольника = " + triangle.getName());

        System.out.println();

        Square square2 = new Square(3, "square2");

        System.out.println("Площадь квадрата 2 = " + square2.getArea());
        System.out.println("Периметр квадрата 2 = " + square2.getPerimeter());
        System.out.println("Высота квадрата 2 = " + square2.getHeight());
        System.out.println("Ширина квадрата 2 = " + square2.getWidth());
        System.out.println("Имя квадрата 2 = " + square2.getName());

        System.out.println();

        Shape[] array = new Shape[5];
        array[0] = square1;
        array[1] = rectangle;
        array[2] = circle;
        array[3] = triangle;
        array[4] = square2;

        Arrays.sort(array, Shape.areaComparator);
        System.out.println("Отсортировано по площади" + Arrays.toString(array));
    }
}
