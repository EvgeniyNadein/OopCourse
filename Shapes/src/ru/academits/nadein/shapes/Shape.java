package ru.academits.nadein.shapes;

import java.util.Comparator;

public interface Shape {
    double getWidth();

    double getHeight();

    double getArea();

    double getPerimeter();

    Comparator<Shape> areaComparator = new Comparator<>() {
        @Override
        public int compare(Shape o1, Shape o2) {
            return (int) (o1.getArea() - o2.getArea());
        }
    };
}