package ru.academits.nadein.shapes.rectangle;

import ru.academits.nadein.shapes.areaComparator.MaxAreaShapesComparator;
import ru.academits.nadein.shapes.shape.Shape;

public class Rectangle extends MaxAreaShapesComparator implements Shape {
    private double height;
    private double width;

    public Rectangle(double height, double width) {
        this.height = height;
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    @Override
    public String toString() {
        return "(" + getArea() + ")";
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return height * width;
    }

    @Override
    public double getPerimeter() {
        return 2 * (height + width);
    }
}
