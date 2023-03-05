package ru.academist.nadein.matrix;

import java.util.Arrays;

public class Matrix {
    private double[][] matrix;

    public Matrix(int rows, int columns) {
        if (rows <= 0 || columns <= 0) {
            throw new IllegalArgumentException("Неподходящий размер матрицы");
        }

        matrix = new double[rows][columns];
    }

    public Matrix(double[][] matrix) {
        if (matrix == null) {
            throw new NullPointerException("Матрица не содержит элементов");
        }

        this.matrix = new double[matrix.length][];

        for (int i = 0; i < matrix.length; i++) {
            this.matrix[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }
    }

    public Matrix(double[] vectorComponents) {
        if (vectorComponents == null) {
            throw new NullPointerException("Матрица не содержит элементов");
        }

        matrix = new double[1][vectorComponents.length];
        System.arraycopy(vectorComponents, 0, matrix[0], 0, vectorComponents.length);
    }

    public Matrix (Matrix matrix) {
        if (matrix == null) {
            throw new NullPointerException("Матрица не содержит элементов");
        }

        this.matrix = new double[matrix.matrix.length][];

        for (int i = 0; i < matrix.matrix.length; i++) {
            this.matrix[i] = Arrays.copyOf(matrix.matrix[i], matrix.matrix[i].length);
        }
    }
}
