package ru.academits.nadein.shapes.areaComparator;

import ru.academits.nadein.shapes.shape.Shape;

import java.util.Comparator;

public class MaxAreaShapesComparator  implements Comparator<Shape> {
    @Override
    public int compare(Shape shape1, Shape shape2) {
        return (int)(shape2.getArea() - shape1.getArea());
    }
}
