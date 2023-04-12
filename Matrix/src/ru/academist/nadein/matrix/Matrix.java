package ru.academist.nadein.matrix;

import ru.academist.nadein.vector.Vector;

public class Matrix {
    private Vector[] rows;

    public Matrix(int rowsCount, int columnsCount) {
        if (rowsCount <= 0 || columnsCount <= 0) {
            throw new IllegalArgumentException("Размер матрицы должен больше нуля. Текущее количество строк: " + rowsCount
                    + ", текущее количество столбцов: " + columnsCount);
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
            throw new IllegalArgumentException("Массив не содержит элементов.");
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
            throw new IndexOutOfBoundsException("Индекс " + index + " выходит за границы матрицы. " +
                    "Допустимое значение индекса от 0 до " + (rows.length - 1));
        }

        return new Vector(rows[index]);
    }

    public void setRowByIndex(int index, Vector vector) {
        if (index < 0 || index >= rows.length) {
            throw new IndexOutOfBoundsException("Индекс " + index + " выходит за границы матрицы. " +
                    "Допустимое значение индекса от 0 до " + (rows.length - 1));
        }

        if (vector.getSize() != getColumnsCount()) {
            throw new IllegalArgumentException("Размер вектора: " + vector.getSize()
                    + " должен быть равен размеру строки матрицы: " + rows[0].getSize());
        }

        rows[index] = new Vector(vector);
    }

    public Vector getColumnByIndex(int index) {
        if (index < 0 || index >= getColumnsCount()) {
            throw new IndexOutOfBoundsException("Индекс " + index + " выходит за границы матрицы. " +
                    "Допустимое значение индекса от 0 до " + (rows[0].getSize() - 1));
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

    private void checkSizeEquality(Matrix matrix) {
        if ((rows.length != matrix.rows.length) || (rows[0].getSize() != matrix.rows[0].getSize())) {
            throw new IllegalArgumentException("Размеры матриц не равны. Количество строк матрицы 1: " + rows.length +
                    ", матрицы 2: " + matrix.rows.length + "Количество столбцов матрицы 1: " + rows[0].getSize() +
                    ", матрицы 2: " + matrix.rows[0].getSize());
        }
    }

    public void add(Matrix matrix) {
        checkSizeEquality(matrix);

        for (int i = 0; i < rows.length; i++) {
            rows[i].add(matrix.rows[i]);
        }
    }

    public void subtract(Matrix matrix) {
        checkSizeEquality(matrix);

        for (int i = 0; i < rows.length; i++) {
            rows[i].subtract(matrix.rows[i]);
        }
    }

    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        matrix1.checkSizeEquality(matrix2);

        Matrix resultMatrix = new Matrix(matrix1);
        resultMatrix.add(matrix2);

        return resultMatrix;
    }

    public static Matrix getDifference(Matrix matrix1, Matrix matrix2) {
        matrix1.checkSizeEquality(matrix2);

        Matrix resultMatrix = new Matrix(matrix1);
        resultMatrix.subtract(matrix2);

        return resultMatrix;
    }

    public static Matrix getProduct(Matrix matrix1, Matrix matrix2) {
        if (matrix1.rows[0].getSize() != matrix2.rows.length) {
            throw new IllegalArgumentException("Количество столбцов первой матрицы: " + matrix1.rows[0].getSize()
                    + " должно быть ровно количеству строк второй матрицы: " + matrix2.rows.length);
        }

        Matrix resultMatrix = new Matrix(matrix1.rows.length, matrix2.rows[0].getSize());

        for (int i = 0; i < matrix1.rows.length; i++) {
            for (int j = 0; j < matrix2.rows[0].getSize(); j++) {
                double resultComponent = 0;

                for (int k = 0; k < matrix1.rows[0].getSize(); k++) {
                    resultComponent += matrix1.rows[i].getComponentByIndex(k) * matrix2.rows[k].getComponentByIndex(j);
                }

                resultMatrix.rows[i].setComponentByIndex(j, resultComponent);
            }
        }

        return resultMatrix;
    }

    // Транспонирование матрицы
    public void transpose() {
        Vector[] newRows = new Vector[getColumnsCount()];

        for (int i = 0; i < rows[0].getSize(); i++) {
            newRows[i] = getColumnByIndex(i);
        }

        rows = newRows;
    }

    //умножение матрицы на вектор
    public Vector multiplyByVector(Vector vector) {
        if (getColumnsCount() != vector.getSize()) {
            throw new IllegalArgumentException("Количество столбцов матрицы: " + rows[0].getSize() + " не равно размеру вектора: " +
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