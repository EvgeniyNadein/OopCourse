package ru.academits.nadein.shapes.main;

import ru.academits.nadein.shapes.shapes.Circle;
import ru.academits.nadein.shapes.comparators.ShapeAreaComparator;
import ru.academits.nadein.shapes.comparators.ShapePerimeterComparator;
import ru.academits.nadein.shapes.shapes.Rectangle;
import ru.academits.nadein.shapes.shapes.Shape;
import ru.academits.nadein.shapes.shapes.Triangle;
import ru.academits.nadein.shapes.shapes.Square;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Square square1 = new Square(2);

        System.out.println("Площадь квадрата = " + square1.getArea());
        System.out.println("Периметр квадрата = " + square1.getPerimeter());
        System.out.println("Высота квадрата = " + square1.getHeight());
        System.out.println("Ширина квадрата = " + square1.getWidth());

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

        Triangle triangle = new Triangle(2, 1, 2, 8, 8, 1);

        System.out.println("Площадь треугольника = " + triangle.getArea());
        System.out.println("Периметр треугольника = " + triangle.getPerimeter());
        System.out.println("Высота треугольника = " + triangle.getHeight());
        System.out.println("Ширина треугольника = " + triangle.getWidth());

        System.out.println();

        Square square2 = new Square(3.5);

        System.out.println("Площадь квадрата 2 = " + square2.getArea());
        System.out.println("Периметр квадрата 2 = " + square2.getPerimeter());
        System.out.println("Высота квадрата 2 = " + square2.getHeight());
        System.out.println("Ширина квадрата 2 = " + square2.getWidth());

        System.out.println();

        Shape[] shapes = {square1, rectangle, circle, triangle, square2};

        Arrays.sort(shapes, new ShapeAreaComparator());
        System.out.println("Наибольшая площадь фигур: " + shapes[shapes.length - 1]);

        Arrays.sort(shapes, new ShapePerimeterComparator());
        System.out.println("Фигура имеющая второй по величине периметр: " + shapes[shapes.length - 2]);
    }
}