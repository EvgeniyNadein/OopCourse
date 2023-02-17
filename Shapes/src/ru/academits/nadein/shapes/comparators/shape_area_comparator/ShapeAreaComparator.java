package ru.academits.nadein.shapes.comparators.shape_area_comparator;

import ru.academits.nadein.shapes.shapes.shape.Shape;

import java.util.Comparator;

public final class ShapeAreaComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape shape1, Shape shape2) {
        return Double.compare(shape1.getArea(), shape2.getArea());
    }
}