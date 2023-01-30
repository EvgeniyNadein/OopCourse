package ru.academits.nadein.shapes.square;

import ru.academits.nadein.shapes.areaComparator.MaxAreaShapesComparator;
import ru.academits.nadein.shapes.shape.Shape;

public class Square extends MaxAreaShapesComparator implements Shape {
    private double sideLength;

    public Square(double sideLength) {
        this.sideLength = sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public String toString() {
        return "(" + getArea() + ")";
    }

    @Override
    public double getWidth() {
        return sideLength;
    }

    @Override
    public double getHeight() {
        return sideLength;
    }

    @Override
    public double getArea() {
        return sideLength * sideLength;
    }

    @Override
    public double getPerimeter() {
        return 4 * sideLength;
    }
}