package ru.academist.nadein.vector.vector;

import java.util.Arrays;

public class Vector {
    private double[] vectorComponents;


    public Vector(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Неподходящий размер вектора");
        }

        vectorComponents = new double[size];
    }

    public Vector(double[] vectorComponents) {
        this.vectorComponents = Arrays.copyOf(vectorComponents, vectorComponents.length);
    }

    public Vector(int vectorSize, double[] vectorComponents) {
        if (vectorSize <= 0) {
            throw new IllegalArgumentException("Неподходящий размер вектора");
        }

        this.vectorComponents = Arrays.copyOf(vectorComponents, vectorSize);
    }

    public Vector(Vector vector) {
        vectorComponents = Arrays.copyOf(vector.vectorComponents, vector.vectorComponents.length);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");

        for (int i = 0; i < vectorComponents.length; i++) {
            stringBuilder.append(getComponentByIndex(i));
            stringBuilder.append(", ");
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("}");

        return stringBuilder.toString();
    }

    public int getSize() {
        return vectorComponents.length;
    }

    public double getComponentByIndex(int index) {
        return vectorComponents[index];
    }

    public void setComponentByIndex(int index, double value) {
        vectorComponents[index] = value;
    }

    public void deploy() {
        multiplyByScalar(-1);
    }

    public void add(Vector vector) {
        if (vectorComponents.length < vector.vectorComponents.length) {
            vectorComponents = Arrays.copyOf(vectorComponents, vector.vectorComponents.length);
        }

        for (int i = 0; i < vector.vectorComponents.length; i++) {
            vectorComponents[i] += vector.vectorComponents[i];
        }
    }

    public void subtract(Vector vector) {
        if (vectorComponents.length < vector.vectorComponents.length) {
            vectorComponents = Arrays.copyOf(vectorComponents, vector.vectorComponents.length);
        }

        for (int i = 0; i < vector.vectorComponents.length; i++) {
            vectorComponents[i] -= vector.vectorComponents[i];
        }
    }

    public static Vector getSum(Vector vector1, Vector vector2) {
        Vector vector = new Vector(Math.max(vector1.getSize(), vector2.getSize()));
        vector1.add(vector2);
        vector.vectorComponents = Arrays.copyOf(vector1.vectorComponents, vector1.vectorComponents.length);

        return vector;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector vector = new Vector(Math.max(vector1.getSize(), vector2.getSize()));
        vector1.subtract(vector2);
        vector.vectorComponents = Arrays.copyOf(vector1.vectorComponents, vector1.vectorComponents.length);

        return vector;
    }

    public void multiplyByScalar(double scalar) {
        for (int i = 0; i < vectorComponents.length; i++) {
            vectorComponents[i] *= scalar;
        }
    }

    public static double getScalarProduct(Vector vector1, Vector vector2) {
        double scalarProduct = 0;

        for (int i = 0; i < Math.min(vector1.vectorComponents.length, vector2.vectorComponents.length); i++) {
            scalarProduct += vector1.vectorComponents[i] * vector2.vectorComponents[i];
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

        if (vectorComponents.length != vector.vectorComponents.length) {
            return false;
        }

        for (int i = 0; i < vectorComponents.length; i++) {
            if (vectorComponents[i] != vector.vectorComponents[i]) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + vectorComponents.length;
        hash = prime * hash + Arrays.hashCode(vectorComponents);
        return hash;
    }

    //реализовать метод вычисления длины вектора (длины отрезка в пространстве)
    public static double getLength(Vector vector) {
        double length = 0;

        for (int i = 0; i < vector.vectorComponents.length; i++) {
            length += vector.vectorComponents[i] * vector.vectorComponents[i];
        }

        return length;
    }
}