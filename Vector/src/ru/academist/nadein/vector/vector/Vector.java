package ru.academist.nadein.vector.vector;

import java.util.Arrays;

public class Vector {
    private final int n;
    private double[] array;
    private Vector vector;

    public Vector(int n) {
        this.n = n;

        if (n <= 0) {
            throw new IllegalArgumentException("Размер вектора не может быть равен 0");
        }

        this.array = new double[n];
        Arrays.fill(array, 0);
    }

    public Vector(double[] inputArray) {
        this.n = inputArray.length;
        this.array = new double[n];
        System.arraycopy(inputArray, 0, array, 0, n);
    }

    public Vector(int n, double[] inputArray) {
        this.n = n;
        this.array = Arrays.copyOf(inputArray, this.n);
    }

    public Vector(Vector inputVector) {
        this.n = inputVector.n;
        this.array = new double[n];
        this.vector = inputVector.vector;
        System.arraycopy(inputVector.array, 0, array, 0, n);
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }

    public int getSize() {
        return array.length;
    }

    public double getComponentByIndex(int i) {
        return array[i];
    }

    public void setComponentByIndex(int i, double value) {
        array[i] = value;
    }

    public void vectorReversal() {
        for (int i = 0; i < array.length; i++) {
            array[i] *= -1;
        }
    }

    public void vectorsAdding(Vector inputVector) {
        array = Arrays.copyOf(array, Math.max(array.length, inputVector.array.length));

        for (int i = 0; i < inputVector.array.length; i++) {
            array[i] += inputVector.array[i];
        }
    }

    public void vectorSubtraction(Vector inputVector) {
        array = Arrays.copyOf(array, Math.max(array.length, inputVector.array.length));

        for (int i = 0; i < inputVector.array.length; i++) {
            array[i] -= inputVector.array[i];
        }
    }

    public static Vector twoVectorsAdding(Vector vector1, Vector vector2) {
        Vector vector = new Vector(Math.max(vector1.getSize(), vector2.getSize()));

        for (int i = 0; i < Math.min(vector1.array.length, vector2.array.length); i++) {
            vector.array[i] = vector1.array[i] + vector2.array[i];
        }

        if (vector1.array.length < vector2.array.length) {
            System.arraycopy(vector2.array, vector1.array.length,
                    vector.array, vector1.array.length, vector2.array.length - vector1.array.length);
        }

        if (vector2.array.length < vector1.array.length) {
            System.arraycopy(vector1.array, vector2.array.length,
                    vector.array, vector2.array.length, vector1.array.length - vector2.array.length);
        }

        return vector;
    }

    public static Vector twoVectorsSubtraction(Vector vector1, Vector vector2) {
        Vector vector = new Vector(Math.max(vector1.getSize(), vector2.getSize()));

        for (int i = 0; i < Math.min(vector1.array.length, vector2.array.length); i++) {
            vector.array[i] = vector1.array[i] - vector2.array[i];
        }

        if (vector1.array.length < vector2.array.length) {
            System.arraycopy(vector2.array, vector1.array.length,
                    vector.array, vector1.array.length, vector2.array.length - vector1.array.length);
        }

        if (vector2.array.length < vector1.array.length) {
            System.arraycopy(vector1.array, vector2.array.length,
                    vector.array, vector2.array.length, vector1.array.length - vector2.array.length);
        }

        return vector;
    }

    public void multiplyVectorByScalar(double scalar) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= scalar;
        }
    }

    public static double vectorsProductScalar(Vector vector1, Vector vector2) {
        double vectorsProductScalar = 0;

        for (int i = 0; i < Math.min(vector1.array.length, vector2.array.length); i++) {
            vectorsProductScalar += vector1.array[i] * vector2.array[i];
        }

        if (vector1.array.length < vector2.array.length) {
            for (int i = vector1.array.length; i < vector2.array.length; i++) {
                vectorsProductScalar += vector2.array[i];
            }
        }

        if (vector1.array.length > vector2.array.length) {
            for (int i = vector2.array.length; i < vector1.array.length; i++) {
                vectorsProductScalar += vector1.array[i];
            }
        }

        return vectorsProductScalar;
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

        boolean a = false;
        boolean b = true;

        if (n == vector.n) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] != vector.array[i]) {
                    b = false;
                    break;
                }
            }

            a = true;
        }

        return a && b;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + n;
        hash = prime * hash + Arrays.hashCode(array);
        return hash;
    }
}