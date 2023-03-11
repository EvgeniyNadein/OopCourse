package ru.academist.nadein.vector;

import java.util.Arrays;

public class Vector {
    private double[] components;

    public Vector(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("������ ������� ������ ���� ������ " + size);
        }

        components = new double[size];
    }

    public Vector(double[] components) {
        if (components.length <= 0) {
            throw new IllegalArgumentException("������ �� �������� ���������");
        }

        this.components = Arrays.copyOf(components, components.length);
    }

    public Vector(int vectorSize, double[] components) {
        if (vectorSize <= 0) {
            throw new IllegalArgumentException("������ ������� ������ ���� ������ " + vectorSize);
        }

        if (components.length <= 0) {
            throw new IllegalArgumentException("������ �� �������� ���������");
        }

        this.components = Arrays.copyOf(components, vectorSize);
    }

    public Vector(Vector vector) {
        components = Arrays.copyOf(vector.components, vector.components.length);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");

        for (int i = 0; i < components.length; i++) {
            stringBuilder.append(getComponentByIndex(i));
            stringBuilder.append(", ");
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
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
        Vector resultingVector = new Vector(Math.max(vector1.getSize(), vector2.getSize()));

        for (int i = 0; i < resultingVector.components.length; i++) {
            resultingVector.components[i] = vector1.components[i] + vector2.components[i];
        }

        return resultingVector;
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        Vector resultingVector = new Vector(Math.max(vector1.components.length, vector2.components.length));

        for (int i = 0; i < resultingVector.getSize(); i++) {
            resultingVector.components[i] = vector1.components[i] + vector2.components[i];
        }

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
        hash = prime * hash + components.length;
        hash = prime * hash + Arrays.hashCode(components);
        return hash;
    }

    //����������� ����� ���������� ����� ������� (����� ������� � ������������)
    public double getLength() {
        double length = 0;

        for (double component : components) {
            length += Math.abs(component * component);
        }

        return length;
    }
}