package ru.academits.nadein.square;

import ru.academits.nadein.shapes.Shape;

public class Square implements Shape {
    private double sideLength;

    public Square (double sideLength) {
        this.sideLength = sideLength;
    }

    public void setSideLength (double sideLength) {
        this.sideLength = sideLength;
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