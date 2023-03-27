package ru.academist.nadein.matrix.main;

import ru.academist.nadein.matrix.Matrix;
import ru.academist.nadein.vector.Vector;

public class Main {
    public static void main(String[] args) {
        double[] array1 = {1, 4};
        Vector vector1 = new Vector(array1);
        double[] array2 = {1, 2, 5};
        Vector vector2 = new Vector(array2);
        Vector[] array = {vector1, vector2};
        Matrix matrix1 = new Matrix(array);
        Matrix matrix2 = new Matrix(matrix1);

        System.out.println(matrix1);
        System.out.println(matrix2);
        System.out.println();

        System.out.println("������� �������2 �� �������: " + matrix2.getColumnByIndex(1));
        System.out.println("������ �������2 �� �������: " + matrix2.getRowByIndex(1));
        System.out.println("���������� ����� �������2: " + matrix2.getRowsCount());
        System.out.println("���������� ������� �������2: " + matrix2.getColumnsCount());
        System.out.println();

        matrix2.add(matrix1);
        System.out.println("�������� ������: " + matrix2);
        matrix2.subtract(matrix1);
        System.out.println("��������� ������: " + matrix2);
        matrix1.multiplyByScalar(3);
        System.out.println("��������� ������� �� ������: " + matrix1);
        System.out.println();

        System.out.println("�������� ������: " + Matrix.getSum(matrix1, matrix2));
        System.out.println(matrix1);
        System.out.println("��������� ������: " + Matrix.getDifference(matrix2, matrix1));
        System.out.println(matrix2);
        System.out.println();

        double[][] array3 = {{5, 1, 2, 5}, {1, 2, 3, 4}, {1, 2, 3, 4}};
        double[][] array4 = {{1, 2, 3}, {2, 3, 4}};
        Matrix matrix3 = new Matrix(array3);
        Matrix matrix4 = new Matrix(array4);
        System.out.println(matrix4);
        System.out.println(matrix3);
        System.out.println("��������� ������: " + Matrix.getProduct(matrix4, matrix3));
        System.out.println();

        double[][] array5 = {{1, 2, 2}, {3, 1, 1}};
        double[][] array6 = {{4, 2}, {3, 1}, {1, 5}};
        Matrix matrix5 = new Matrix(array5);
        Matrix matrix6 = new Matrix(array6);
        System.out.println(matrix6);
        System.out.println(matrix5);
        matrix4.setRowByIndex(1, vector2);
        System.out.println(matrix4);
        System.out.println("��������� ������: " + Matrix.getProduct(matrix6, matrix5));
        System.out.println();

        double[][] array7 = {{5, 2,}, {3, 1}};
        double[][] array8 = {{4, 6}, {5, 2}};
        Matrix matrix7 = new Matrix(array7);
        Matrix matrix8 = new Matrix(array8);
        System.out.println(matrix7);
        System.out.println(matrix8);
        System.out.println("��������� ������: " + Matrix.getProduct(matrix7, matrix8));
        System.out.println();

        matrix6.transpose();
        System.out.println("���������������� �������: " + matrix6);
        System.out.println();

        System.out.println(vector2);
        System.out.println(matrix6.multiplyByVector(vector2));
    }
}