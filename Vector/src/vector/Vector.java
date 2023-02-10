package vector;

import java.util.Arrays;

public class Vector {
    private int n;
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
        if (n < inputVector.n) {
            n = inputVector.n;
            array = Arrays.copyOf(array, n);
        }

        for (int i = 0; i < inputVector.array.length; i++) {
            array[i] += inputVector.array[i];
        }
    }

    public void vectorSubtraction (Vector inputVector) {
        if (n < inputVector.n) {
            n = inputVector.n;
            array = Arrays.copyOf(array, n);
        }

        for (int i = 0; i < inputVector.array.length; i++) {
            array[i] -= inputVector.array[i];
        }
    }
}