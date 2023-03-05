package ru.academist.nadein.matrix;

import ru.academist.nadein.vector.vector.Vector;

import java.util.Arrays;

public class Matrix {
    private Vector[][] matrix;

    public Matrix(int rows, int columns) {
        if (rows <= 0 || columns <= 0) {
            throw new IllegalArgumentException("Неподходящий размер матрицы");
        }

        matrix = new Vector[rows][columns];
    }

    public Matrix(Vector[][] matrix) {
        if (matrix == null) {
            throw new NullPointerException("Матрица не содержит элементов");
        }
        this.matrix = new Vector[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            this.matrix[i] = Arrays.copyOf(matrix[i], matrix[i].length);
        }
    }
}
