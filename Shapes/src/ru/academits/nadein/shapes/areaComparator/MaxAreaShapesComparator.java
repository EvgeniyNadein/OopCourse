package ru.academits.nadein.shapes.areaComparator;

import ru.academits.nadein.shapes.shape.Shape;

import java.util.Comparator;

public class MaxAreaShapesComparator  implements Comparator<Shape> {
    @Override
    public int compare(Shape shape1, Shape shape2) {
        double d2 = shape2.getArea();
        double d1 = shape1.getArea();
        return Double.compare(d2, d1);
    }
}
