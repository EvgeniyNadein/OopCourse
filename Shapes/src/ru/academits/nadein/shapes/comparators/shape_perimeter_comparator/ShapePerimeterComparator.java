package ru.academits.nadein.shapes.comparators.shape_perimeter_comparator;

import ru.academits.nadein.shapes.shapes.shape.Shape;

import java.util.Comparator;

public final class ShapePerimeterComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape shape1, Shape shape2) {
        return Double.compare(shape1.getPerimeter(), shape2.getPerimeter());
    }
}
