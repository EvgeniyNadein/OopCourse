package ru.academits.nadein.square;

import ru.academits.nadein.shapes.Shape;

public class Square implements Shape {
    private double sideLength;
    private String name;

    public Square(double sideLength, String name) {
        this.sideLength = sideLength;
        this.name = name;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public String toString() {
        return "(" + getArea() + ", " + name + ")";
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

    @Override
    public String getName() {
        return name;
    }
}