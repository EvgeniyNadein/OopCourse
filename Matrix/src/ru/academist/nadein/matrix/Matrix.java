package ru.academist.nadein.matrix;

import ru.academist.nadein.vector.Vector;

public class Matrix {
    private Vector[] matrixRows;

    public Matrix(int rowsCount, int columnsCount) {
        if (rowsCount <= 0 || columnsCount <= 0) {
            throw new IllegalArgumentException("Размер матрицы должен больше нуля: " + rowsCount + ", " + columnsCount);
        }

        matrixRows = new Vector[rowsCount];

        for (int i = 0; i < matrixRows.length; i++) {
            matrixRows[i] = new Vector(columnsCount);
        }
    }

    public Matrix(double[][] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Двумерный массив не содержит элементов");
        }

        int maxSize = 0;
        int currentMaxSize;

        for (double[] doubles : array) {
            currentMaxSize = doubles.length;

            if (currentMaxSize > maxSize) {
                maxSize = currentMaxSize;
            }
        }

        matrixRows = new Vector[array.length];

        for (int i = 0; i < array.length; i++) {
            Vector vector = new Vector(maxSize, array[i]);
            matrixRows[i] = vector;
        }
    }

    public Matrix(Vector[] vectorsArray) {
        if (vectorsArray.length == 0) {
            throw new IllegalArgumentException("Массив не содержит элементов");
        }

        int maxSize = 0;
        int currentMaxSize;

        for (Vector vector : vectorsArray) {
            currentMaxSize = vector.getSize();

            if (currentMaxSize > maxSize) {
                maxSize = currentMaxSize;
            }
        }

        matrixRows = new Vector[vectorsArray.length];

        for (int i = 0; i < vectorsArray.length; i++) {
            Vector rowVector = new Vector(maxSize);
            rowVector.add(vectorsArray[i]);
            matrixRows[i] = rowVector;
        }
    }

    public Matrix(Matrix matrix) {
        this.matrixRows = new Vector[matrix.matrixRows.length];

        for (int i = 0; i < matrix.matrixRows.length; i++) {
            this.matrixRows[i] = new Vector(matrix.matrixRows[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");

        for (Vector vector : matrixRows) {
            stringBuilder.append(vector);
            stringBuilder.append(", ");
        }

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length() - 1 );
        stringBuilder.append("}");

        return stringBuilder.toString();
    }

    public int getRowsCount() {
        return matrixRows.length;
    }

    public int getColumnsCount() {
        return matrixRows[0].getSize();
    }

    public Vector getRowByIndex(int index) {
        if (index < 0 || index > matrixRows.length - 1) {
            throw new ArrayIndexOutOfBoundsException("Индекс " + index + " выходит за границы матрицы");
        }

        return new Vector(matrixRows[index]);
    }

    public void setRowByIndex(int index, Vector vector) {
        if (index < 0 || index > matrixRows.length - 1) {
            throw new ArrayIndexOutOfBoundsException("Индекс " + index + " выходит за границы матрицы");
        }

        if (vector.getSize() != matrixRows[index].getSize()) {
            throw new IllegalArgumentException("Размер массива: " + vector.getSize() + " должен быть равен размеру строки матрицы: " + matrixRows[index].getSize());
        }

        matrixRows[index] = new Vector(vector);
    }

    public Vector getColumnByIndex(int index) {
        if (index < 0 || index > matrixRows[0].getSize() - 1) {
            throw new ArrayIndexOutOfBoundsException("Индекс " + index + " выходит за границы матрицы");
        }

        Vector vector = new Vector(matrixRows.length);

        for (int i = 0; i < matrixRows.length; i++) {
            vector.setComponentByIndex(i, matrixRows[i].getComponentByIndex(index));
        }

        return vector;
    }

    public void multiplyByScalar(double scalar) {
        for (Vector vector : matrixRows) {
            vector.multiplyByScalar(scalar);
        }
    }

    public void verifyMatrixSize(Matrix matrix) {
        if (this.matrixRows.length != matrix.matrixRows.length) {
            throw new IllegalArgumentException("Количество строк матриц не равны: " + this.matrixRows.length +
                    ", " + matrix.matrixRows.length);
        }

        if (this.matrixRows[0].getSize() != matrix.matrixRows[0].getSize()) {
            throw new IllegalArgumentException("Количество столбцов матриц не равны: " + this.matrixRows[0].getSize() +
                    ", " + matrix.matrixRows[0].getSize());
        }
    }

    public void add(Matrix matrix) {
        verifyMatrixSize(matrix);

        for (int i = 0; i < this.matrixRows.length; i++) {
            this.matrixRows[i].add(matrix.matrixRows[i]);
        }
    }

    public void subtract(Matrix matrix) {
        verifyMatrixSize(matrix);

        for (int i = 0; i < this.matrixRows.length; i++) {
            this.matrixRows[i].subtract(matrix.matrixRows[i]);
        }
    }

    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        matrix1.verifyMatrixSize(matrix2);

        Matrix resultingMatrix = new Matrix(matrix1);

        for (int i = 0; i < matrix1.matrixRows.length; i++) {
            for (int j = 0; j < matrix1.matrixRows[0].getSize(); j++) {
                resultingMatrix.matrixRows[i].setComponentByIndex(j, resultingMatrix.matrixRows[i].getComponentByIndex(j) + matrix2.matrixRows[i].getComponentByIndex(j));
            }
        }

        return resultingMatrix;
    }

    public static Matrix getDifference(Matrix matrix1, Matrix matrix2) {
        matrix1.verifyMatrixSize(matrix2);

        Matrix resultingMatrix = new Matrix(matrix1);

        for (int i = 0; i < matrix1.matrixRows.length; i++) {
            for (int j = 0; j < matrix1.matrixRows[0].getSize(); j++) {
                resultingMatrix.matrixRows[i].setComponentByIndex(j, resultingMatrix.matrixRows[i].getComponentByIndex(j) - matrix2.matrixRows[i].getComponentByIndex(j));
            }
        }

        return resultingMatrix;
    }

    public static Matrix getProduct(Matrix matrix1, Matrix matrix2) {
        if (matrix1.matrixRows[0].getSize() != matrix2.matrixRows.length) {
            throw new IllegalArgumentException("Количество столбцов первой матрицы должно быть ровно количеству строк второй матрицы");
        }

        Matrix resultingMatrix = new Matrix(matrix1.matrixRows.length, matrix2.matrixRows[0].getSize());


        for (int i = 0; i < matrix1.matrixRows.length; i++) {
            for (int j = 0; j < matrix1.matrixRows.length; j++) {
                double resultingComponent = 0;
                for (int k = 0; k < matrix1.matrixRows[0].getSize(); k++) {
                    resultingComponent += matrix1.matrixRows[i].getComponentByIndex(k) * matrix2.getColumnByIndex(j).getComponentByIndex(k);
                }

                resultingMatrix.matrixRows[i].setComponentByIndex(j, resultingComponent);
            }
        }

        return resultingMatrix;
    }}