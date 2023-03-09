package ru.academist.nadein.matrix.main;

import ru.academist.nadein.matrix.Matrix;
import ru.academist.nadein.vector.vector.Vector;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        double[] inputArray1 = {1, 4};
        Vector vector1 = new Vector(inputArray1);
        double[] inputArray2 = {1, 2, 5};
        Vector vector2 = new Vector(inputArray2);
        Vector[] array = {vector1, vector2};
        Matrix matrix1 = new Matrix(array);
        Matrix matrix2 = new Matrix(matrix1);

        System.out.println(matrix1);
        System.out.println(matrix2);
        System.out.println();

        System.out.println("������� �������2 �� �������: " + matrix2.getVectorColumnByIndex(1));
        System.out.println("������ �������2 �� �������: " + matrix2.getVectorRowByIndex(1));
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
    }
}