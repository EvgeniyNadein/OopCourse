package ru.academist.nadein.matrix;

import ru.academist.nadein.vector.vector.Vector;

import java.util.Arrays;

public class Matrix {
    private Vector[] matrix;

    public Matrix(int rows, int columns) {
        if (rows <= 0 || columns <= 0) {
            throw new IllegalArgumentException("Неподходящий размер матрицы");
        }

        matrix = new Vector[rows];

        for (int i = 0; i < matrix.length; i++) {
            Vector vector = new Vector(columns);
            matrix[i] = vector;
        }
    }

    public Matrix(double[][] twoDimensionalArray) {
        if (twoDimensionalArray.length == 0) {
            throw new NullPointerException("Двумерный массив не содержит элементов");
        }

        matrix = new Vector[twoDimensionalArray.length];

        for (int i = 0; i < twoDimensionalArray.length; i++) {
            Vector vector = new Vector(twoDimensionalArray[i].length);

            for (int j = 0; j < twoDimensionalArray[i].length; j++) {
                vector.setComponentByIndex(j, twoDimensionalArray[i][j]);
            }

            matrix[i] = vector;
        }
    }

    public Matrix(Vector[] vector) {
        if (vector.length == 0) {
            throw new NullPointerException("Массив не содержит элементов");
        }

        int maxLength = 0;
        int currentMaxLength;

        if (vector.length > 1) {
            for (int i = 0; i < vector.length - 1; i++) {
                currentMaxLength = Math.max(vector[i].getSize(), vector[i + 1].getSize());

                if (currentMaxLength > maxLength) {
                    maxLength = currentMaxLength;
                }
            }
        } else {
            maxLength = vector[0].getSize();
        }

        double[] maxLengthArray = new double[maxLength];
        Arrays.fill(maxLengthArray, 0);

        matrix = new Vector[vector.length];

        for (int i = 0; i < vector.length; i++) {
            Vector vector1 = new Vector(maxLengthArray);
            vector1.add(vector[i]);
            matrix[i] = vector1;
        }
    }

    public Matrix(Matrix matrix) {
        if (matrix.matrix.length == 0) {
            throw new NullPointerException("Матрица не содержит элементов");
        }

        this.matrix = Arrays.copyOf(matrix.matrix, matrix.matrix.length);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");

        for (Vector vector : matrix) {
            stringBuilder.append(vector.toString());
            stringBuilder.append(", ");
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        stringBuilder.append("}");

        return stringBuilder.toString();
    }
}