package ru.academist.nadein.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int size) {
        if (size == 0) {
            throw new IllegalArgumentException("Размер вектора должен быть больше 0: " + size);
        }

        components = new double[size];
    }

    public Vector(double[] components) {
        if (components.length == 0) {
            throw new IllegalArgumentException("Массив не содержит элементов");
        }

        this.components = Arrays.copyOf(components, components.length);
    }

    public Vector(int size, double[] components) {
        if (components.length == 0) {
            throw new IllegalArgumentException("Массив не содержит элементов");
        }

        this.components = Arrays.copyOf(components, size);
    }

    public Vector(Vector vector) {
        components = Arrays.copyOf(vector.components, vector.components.length);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");

        for (double component : components) {
            stringBuilder.append(component);
            stringBuilder.append(", ");
        }

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append("}");

        return stringBuilder.toString();
    }

    public int getSize() {
        return components.length;
    }

    public double getComponentByIndex(int index) {
        return components[index];
    }

    public void setComponentByIndex(int index, double value) {
        components[index] = value;
    }

    public void turn() {
        multiplyByScalar(-1);
    }

    public void add(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < vector.components.length; i++) {
            components[i] += vector.components[i];
        }
    }

    public void subtract(Vector vector) {
        if (components.length < vector.components.length) {
            components = Arrays.copyOf(components, vector.components.length);
        }

        for (int i = 0; i < vector.components.length; i++) {
            components[i] -= vector.components[i];
        }
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector resultingVector = new Vector(vector1);
        resultingVector.add(vector2);

        return resultingVector;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector resultingVector = new Vector(vector1);
        resultingVector.subtract(vector2);

        return resultingVector;
    }

    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < components.length; i++) {
            components[i] *= scalar;
        }
    }

    public static double getScalarProduct(Vector vector1, Vector vector2) {
        double scalarProduct = 0;
        int minVectorSize = Math.min(vector1.components.length, vector2.components.length);

        for (int i = 0; i < minVectorSize; i++) {
            scalarProduct += vector1.getComponentByIndex(i) * vector2.getComponentByIndex(i);
        }

        return scalarProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null || o.getClass() != getClass()) {
            return false;
        }

        Vector vector = (Vector) o;

        return Arrays.equals(components, vector.components);
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Arrays.hashCode(components);
        return hash;
    }

    // Реализовать метод вычисления длины вектора (длины отрезка в пространстве)
    public double getLength() {
        double length = 0;

        for (double component : components) {
            length += component * component;
        }

        return Math.sqrt(length);
    }
}