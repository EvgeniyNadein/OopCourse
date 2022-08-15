package ru.academits.nadein.circle;

import ru.academits.nadein.shapes.Shape;

public class Circle implements Shape {
    private double radius;
    private String name;

    public Circle(double radius, String name) {
        this.radius = radius;
        this.name = name;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "(" + getArea() + ", " + name + ")";
    }

    @Override
    public double getWidth() {
        return 2 * radius;
    }

    @Override
    public double getHeight() {
        return 2 * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String getName() {
        return name;
    }
}