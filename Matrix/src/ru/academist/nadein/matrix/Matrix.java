package ru.academist.nadein.matrix;

import ru.academist.nadein.vector.Vector;

import java.util.Arrays;

public class Matrix {
    private final Vector[] matrix;

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
            throw new IllegalArgumentException("Двумерный массив не содержит элементов");
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
            throw new IllegalArgumentException("Массив не содержит элементов");
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
            throw new IllegalArgumentException("Матрица не содержит элементов");
        }
        this.matrix = new Vector[matrix.matrix.length];

        for (int i = 0; i < matrix.matrix.length; i++) {
            this.matrix[i] = new Vector(matrix.matrix[i]);
        }
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

    public int getRowsCount() {
        return matrix.length;
    }

    public int getColumnsCount() {
        return matrix[0].getSize();
    }

    public Vector getVectorRowByIndex(int index) {
        if (index < 0 || index > matrix.length) {
            throw new IllegalArgumentException("Индекс выходит за границы матрицы");
        }

        return matrix[index];
    }

    public void setVectorRowByIndex(int index, Vector vector) {
        if (index < 0 || index > matrix.length) {
            throw new IllegalArgumentException("Индекс выходит за границы матрицы");
        }

        matrix[index] = vector;
    }

    public Vector getVectorColumnByIndex(int index) {
        if (index < 0 || index > matrix[0].getSize()) {
            throw new IllegalArgumentException("Индекс выходит за границы матрицы");
        }

        Vector vector = new Vector(matrix.length);

        for (int i = 0; i < matrix.length; i++) {
            vector.setComponentByIndex(i, matrix[i].getComponentByIndex(index));
        }

        return vector;
    }

    public void multiplyByScalar(double scalar) {
        for (Vector vector : matrix) {
            vector.multiplyByScalar(scalar);
        }
    }

    public void add(Matrix matrix) {
        if (this.matrix.length != matrix.matrix.length) {
            throw new IllegalArgumentException("Количество строк матриц не равны");
        }

        if (this.matrix[0].getSize() != matrix.matrix[0].getSize()) {
            throw new IllegalArgumentException("Количество столбцов матриц не равны");
        }

        for (int i = 0; i < this.matrix.length; i++) {
            this.matrix[i].add(matrix.matrix[i]);
        }
    }

    public void subtract(Matrix matrix) {
        if (this.matrix.length != matrix.matrix.length) {
            throw new IllegalArgumentException("Количество строк матриц не равны");
        }

        if (this.matrix[0].getSize() != matrix.matrix[0].getSize()) {
            throw new IllegalArgumentException("Количество столбцов матриц не равны");
        }

        for (int i = 0; i < this.matrix.length; i++) {
            this.matrix[i].subtract(matrix.matrix[i]);
        }
    }

    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        if (matrix1.matrix.length != matrix2.matrix.length) {
            throw new IllegalArgumentException("Количество строк матриц не равны");
        }

        if (matrix1.matrix[0].getSize() != matrix2.matrix[0].getSize()) {
            throw new IllegalArgumentException("Количество столбцов матриц не равны");
        }

        Matrix resultingMatrix = new Matrix(matrix1.matrix.length, matrix1.matrix[0].getSize());

        for (int i = 0; i < matrix1.matrix.length; i++) {
            for (int j = 0; j < matrix1.matrix[0].getSize(); j++) {
                resultingMatrix.matrix[i].setComponentByIndex(j, matrix1.matrix[i].getComponentByIndex(j) + matrix2.matrix[i].getComponentByIndex(j));
            }
        }

        return resultingMatrix;
    }

    public static Matrix getDifference(Matrix matrix1, Matrix matrix2) {
        if (matrix1.matrix.length != matrix2.matrix.length) {
            throw new IllegalArgumentException("Количество строк матриц не равны");
        }

        if (matrix1.matrix[0].getSize() != matrix2.matrix[0].getSize()) {
            throw new IllegalArgumentException("Количество столбцов матриц не равны");
        }

        Matrix resultingMatrix = new Matrix(matrix1.matrix.length, matrix1.matrix[0].getSize());

        for (int i = 0; i < matrix1.matrix.length; i++) {
            for (int j = 0; j < matrix1.matrix[0].getSize(); j++) {
                resultingMatrix.matrix[i].setComponentByIndex(j, matrix1.matrix[i].getComponentByIndex(j) - matrix2.matrix[i].getComponentByIndex(j));
            }
        }

        return resultingMatrix;
    }

    public static Matrix multiplyMatrix(Matrix matrix1, Matrix matrix2) {
        if (matrix1.matrix[0].getSize() == matrix2.matrix.length) {
            Matrix resultingMatrix = new Matrix(matrix1.matrix.length, matrix2.matrix[0].getSize());
            double resultingComponent = 0;

            for (int i = 0; i < matrix1.matrix.length; i++) {
                for (int j = 0; j < matrix1.matrix.length; j++) {
                    for (int k = 0; k < matrix1.matrix[0].getSize(); k++) {
                        resultingComponent += matrix1.matrix[i].getComponentByIndex(k) * matrix2.getVectorColumnByIndex(j).getComponentByIndex(k);
                    }

                    resultingMatrix.matrix[i].setComponentByIndex(j, resultingComponent);
                    resultingComponent = 0;
                }

                resultingComponent = 0;
            }

            return resultingMatrix;
        } else {
            throw new IllegalArgumentException("Количество столбцов первой матрицы должно быть ровно количеству строк второй матрицы");
        }
    }
}