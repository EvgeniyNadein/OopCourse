package ru.academits.nadein.shapes.perimeterComparator;

import ru.academits.nadein.shapes.shape.Shape;

import java.util.Comparator;

public final class MaxShapesPerimeterComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape shape1, Shape shape2) {
        double d2 = shape2.getPerimeter();
        double d1 = shape1.getPerimeter();
        return Double.compare(d2, d1);
    }
}
