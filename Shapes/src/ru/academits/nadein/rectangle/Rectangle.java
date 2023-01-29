package ru.academits.nadein.rectangle;

import ru.academits.nadein.shapes.Shape;

public class Rectangle implements Shape {
    private double side1Length;
    private double side2Length;

    public Rectangle(double side1Length, double side2Length) {
        this.side1Length = side1Length;
        this.side2Length = side2Length;
    }

    public void setSide1Length(double side1Length) {
        this.side1Length = side1Length;
    }

    public void setSide2Length(double side2Length) {
        this.side2Length = side2Length;
    }

   @Override
    public String toString() {
       return "(" + getArea() + ")";
    }

    @Override
    public double getWidth() {
        return side2Length;
    }

    @Override
    public double getHeight() {
        return side1Length;
    }

    @Override
    public double getArea() {
        return side1Length * side2Length;
    }

    @Override
    public double getPerimeter() {
        return 2 * (side1Length + side2Length);
    }
}
