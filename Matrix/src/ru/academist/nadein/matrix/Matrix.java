package ru.academist.nadein.matrix;

import ru.academist.nadein.vector.Vector;

public class Matrix {
    private Vector[] rows;

    public Matrix(int rowsCount, int columnsCount) {
        if (rowsCount <= 0 || columnsCount <= 0) {
            throw new IllegalArgumentException("������ ������� ������ ������ ����. ������� ���������� �����: " + rowsCount
                    + ", ������� ���������� �������: " + columnsCount);
        }

        rows = new Vector[rowsCount];

        for (int i = 0; i < rows.length; i++) {
            rows[i] = new Vector(columnsCount);
        }
    }

    public Matrix(double[][] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("��������� ������ �� �������� ���������.");
        }

        int maxSize = 0;

        for (double[] row : array) {
            if (row.length > maxSize) {
                maxSize = row.length;
            }
        }

        if (maxSize == 0) {
            throw new IllegalArgumentException("���������� ������� ������� �������� �������. " +
                    "��������� ������� �� �������� ���������.");
        }

        rows = new Vector[array.length];

        for (int i = 0; i < array.length; i++) {
            rows[i] = new Vector(maxSize, array[i]);
        }
    }

    public Matrix(Vector[] vectorsArray) {
        if (vectorsArray.length == 0) {
            throw new IllegalArgumentException("������ �� �������� ���������");
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
            throw new ArrayIndexOutOfBoundsException("������ " + index + " ������� �� ������� �������. " +
                    "���������� ����� � �������: " + getRowsCount());
        }

        return new Vector(rows[index]);
    }

    public void setRowByIndex(int index, Vector vector) {
        if (index < 0 || index >= rows.length) {
            throw new ArrayIndexOutOfBoundsException("������ " + index + " ������� �� ������� �������. " +
                    "���������� ����� � �������: " + getRowsCount());
        }

        if (vector.getSize() != getColumnsCount()) {
            throw new IllegalArgumentException("������ �������: " + vector.getSize() + " ������ ���� ����� ������� ������ �������: " + getColumnsCount());
        }

        rows[index] = new Vector(vector);
    }

    public Vector getColumnByIndex(int index) {
        if (index < 0 || index >= getColumnsCount()) {
            throw new ArrayIndexOutOfBoundsException("������ " + index + " ������� �� ������� �������. " +
                    "���������� �������� � �������: " + getColumnsCount());
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
            throw new IllegalArgumentException("���������� ����� ������ �� �����: ������� 1:" + rows.length +
                    ", ������� 2: " + matrix.rows.length);
        }

        if (rows[0].getSize() != matrix.getColumnsCount()) {
            throw new IllegalArgumentException("���������� �������� ������ �� �����: ������� 1:" + getColumnsCount() +
                    ", ������� 2: " + matrix.getColumnsCount());
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
        if (matrix1.getColumnsCount() != matrix2.rows.length) {
            throw new IllegalArgumentException("���������� �������� ������ �������: " + matrix1.getColumnsCount()
                    + " ������ ���� ����� ���������� ����� ������ �������: " + matrix2.rows.length);
        }

        Matrix resultMatrix = new Matrix(matrix1.rows.length, matrix2.getColumnsCount());

        for (int i = 0; i < matrix1.rows.length; i++) {
            for (int j = 0; j < matrix1.rows.length; j++) {
                double resultComponent = 0;
                for (int k = 0; k < matrix1.getColumnsCount(); k++) {
                    resultComponent += matrix1.rows[i].getComponentByIndex(k) * matrix2.getColumnByIndex(j).getComponentByIndex(k);
                }

                resultMatrix.rows[i].setComponentByIndex(j, resultComponent);
            }
        }

        return resultMatrix;
    }

    // ���������������� �������
    public void transpose() {
        Vector[] resultRow = new Vector[getColumnsCount()];

        for (int i = 0; i < getColumnsCount(); i++) {
            resultRow[i] = getColumnByIndex(i);
        }

        rows = resultRow;
    }

    //��������� ������� �� ������
    public Vector multiplyByVector(Vector vector) {
        if (getColumnsCount() != vector.getSize()) {
            throw new IllegalArgumentException("���������� �������� �������: " + getColumnsCount() + " �� ����� ������� �������: " +
                    vector.getSize());
        }

        Vector resultVector = new Vector(rows.length);

        for (int i = 0; i < rows.length; i++) {
            resultVector.setComponentByIndex(i, Vector.getScalarProduct(rows[i], vector));
        }

        return resultVector;
    }

    // ����� ����������� ����� ���������� ������������ �������
}