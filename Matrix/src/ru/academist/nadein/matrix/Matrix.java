package ru.academist.nadein.matrix;

import ru.academist.nadein.vector.Vector;

public class Matrix {
    private Vector[] rows;

    public Matrix(int rowsCount, int columnsCount) {
        if (rowsCount <= 0 || columnsCount <= 0) {
            throw new IllegalArgumentException("Размер матрицы должен больше нуля. Текущее количество строк: " + rowsCount
                    + ", текущее количество колонок: " + columnsCount);
        }

        rows = new Vector[rowsCount];

        for (int i = 0; i < rows.length; i++) {
            rows[i] = new Vector(columnsCount);
        }
    }

    public Matrix(double[][] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("Двумерный массив не содержит элементов.");
        }

        int maxSize = 0;

        for (double[] row : array) {
            if (row.length > maxSize) {
                maxSize = row.length;
            }
        }

        if (maxSize == 0) {
            throw new IllegalArgumentException("Невозможно создать матрицу нулевого размера. " +
                    "Вложенные массивы не содержат элементов.");
        }

        rows = new Vector[array.length];

        for (int i = 0; i < array.length; i++) {
            rows[i] = new Vector(maxSize, array[i]);
        }
    }

    public Matrix(Vector[] vectorsArray) {
        if (vectorsArray.length == 0) {
            throw new IllegalArgumentException("Массив не содержит элементов");
        }

        int maxSize = 0;

        for (Vector row : vectorsArray) {
            if (row.getSize() > maxSize) {
                maxSize = row.getSize();
            }
        }

        rows = new Vector[vectorsArray.length];

        for (int i = 0; i < vectorsArray.length; i++) {
            rows[i] = new Vector(maxSize);
            rows[i].add(vectorsArray[i]);
        }
    }

    public Matrix(Matrix matrix) {
        rows = new Vector[matrix.rows.length];

        for (int i = 0; i < matrix.rows.length; i++) {
            rows[i] = new Vector(matrix.rows[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('{');

        for (Vector vector : rows) {
            stringBuilder.append(vector).append(", ");
        }

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append('}');

        return stringBuilder.toString();
    }

    public int getRowsCount() {
        return rows.length;
    }

    public int getColumnsCount() {
        return rows[0].getSize();
    }

    public Vector getRowByIndex(int index) {
        if (index < 0 || index >= rows.length) {
            throw new ArrayIndexOutOfBoundsException("Индекс " + index + " выходит за границы матрицы. " +
                    "Количество строк в матрице: " + getRowsCount());
        }

        return new Vector(rows[index]);
    }

    public void setRowByIndex(int index, Vector vector) {
        if (index < 0 || index >= rows.length) {
            throw new ArrayIndexOutOfBoundsException("Индекс " + index + " выходит за границы матрицы. " +
                    "Количество строк в матрице: " + rows.length);
        }

        if (vector.getSize() != getColumnsCount()) {
            throw new IllegalArgumentException("Размер вектора: " + vector.getSize() + " должен быть равен размеру строки матрицы: " + getColumnsCount());
        }

        rows[index] = new Vector(vector);
    }

    public Vector getColumnByIndex(int index) {
        if (index < 0 || index >= getColumnsCount()) {
            throw new IndexOutOfBoundsException("Индекс " + index + " выходит за границы матрицы. " +
                    "Количество столбцов в матрице: " + getColumnsCount());
        }

        Vector vector = new Vector(rows.length);

        for (int i = 0; i < rows.length; i++) {
            vector.setComponentByIndex(i, rows[i].getComponentByIndex(index));
        }

        return vector;
    }

    public void multiplyByScalar(double scalar) {
        for (Vector vector : rows) {
            vector.multiplyByScalar(scalar);
        }
    }

    public void checkMatrixSize(Matrix matrix) {
        if (rows.length != matrix.rows.length) {
            throw new IllegalArgumentException("Количество строк матриц не равно: матрица 1:" + rows.length +
                    ", матрица 2: " + matrix.rows.length);
        }

        if (getColumnsCount() != matrix.getColumnsCount()) {
            throw new IllegalArgumentException("Количество столбцов матриц не равно: матрица 1:" + getColumnsCount() +
                    ", матрица 2: " + matrix.getColumnsCount());
        }
    }

    public void add(Matrix matrix) {
        checkMatrixSize(matrix);

        for (int i = 0; i < rows.length; i++) {
            rows[i].add(matrix.rows[i]);
        }
    }

    public void subtract(Matrix matrix) {
        checkMatrixSize(matrix);

        for (int i = 0; i < rows.length; i++) {
            rows[i].subtract(matrix.rows[i]);
        }
    }

    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        matrix1.checkMatrixSize(matrix2);

        Matrix resultMatrix = new Matrix(matrix1);
        resultMatrix.add(matrix2);

        return resultMatrix;
    }

    public static Matrix getDifference(Matrix matrix1, Matrix matrix2) {
        matrix1.checkMatrixSize(matrix2);

        Matrix resultMatrix = new Matrix(matrix1);
        resultMatrix.subtract(matrix2);

        return resultMatrix;
    }

    public static Matrix getProduct(Matrix matrix1, Matrix matrix2) {
        if (matrix1.getColumnsCount() != matrix2.getRowsCount()) {
            throw new IllegalArgumentException("Количество столбцов первой матрицы: " + matrix1.getColumnsCount()
                    + " должно быть ровно количеству строк второй матрицы: " + matrix2.getRowsCount());
        }

        Matrix resultMatrix = new Matrix(matrix1.getRowsCount(), matrix2.getColumnsCount());

        for (int i = 0; i < matrix1.getRowsCount(); i++) {
            for (int j = 0; j < matrix2.getColumnsCount(); j++) {
                double resultComponent = 0;
                for (int k = 0; k < matrix1.getColumnsCount(); k++) {
                    resultComponent += matrix1.rows[i].getComponentByIndex(k) * matrix2.rows[k].getComponentByIndex(j);
                }

                resultMatrix.rows[i].setComponentByIndex(j, resultComponent);
            }
        }

        return resultMatrix;
    }

    // Транспонирование матрицы
    public void transpose() {
        Vector[] resultRow = new Vector[getColumnsCount()];

        for (int i = 0; i < getColumnsCount(); i++) {
            resultRow[i] = getColumnByIndex(i);
        }

        rows = resultRow;
    }

    //умножение матрицы на вектор
    public Vector multiplyByVector(Vector vector) {
        if (getColumnsCount() != vector.getSize()) {
            throw new IllegalArgumentException("Количество столбцов матрицы: " + getColumnsCount() + " не равно размеру вектора: " +
                    vector.getSize());
        }

        Vector resultVector = new Vector(rows.length);

        for (int i = 0; i < rows.length; i++) {
            resultVector.setComponentByIndex(i, Vector.getScalarProduct(rows[i], vector));
        }

        return resultVector;
    }

    // Нужно реализовать метод вычисления определителя матрицы
}