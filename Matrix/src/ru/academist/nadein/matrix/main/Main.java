package ru.academist.nadein.matrix.main;

import ru.academist.nadein.matrix.Matrix;
import ru.academist.nadein.vector.Vector;

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

        System.out.println("Колонка матрицы2 по индексу: " + matrix2.getColumnByIndex(1));
        System.out.println("Строка матрицы2 по индексу: " + matrix2.getRowByIndex(1));
        System.out.println("Количество строк матрицы2: " + matrix2.getRowsCount());
        System.out.println("Количество колонок матрицы2: " + matrix2.getColumnsCount());
        System.out.println();

        matrix2.add(matrix1);
        System.out.println("Сложение матриц: " + matrix2);
        matrix2.subtract(matrix1);
        System.out.println("Вычитание матриц: " + matrix2);
        matrix1.multiplyByScalar(3);
        System.out.println("Умножение матрицы на скаляр: " + matrix1);
        System.out.println();

        System.out.println("Сложение матриц: " + Matrix.getSum(matrix1, matrix2));
        System.out.println(matrix1);
        System.out.println("Вычитание матриц: " + Matrix.getDifference(matrix2, matrix1));
        System.out.println(matrix2);
        System.out.println();

        double[][] inputArray3 = {{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 0, 0}};
        double[][] inputArray4 = {{1, 2, 3}, {1, 1, 1}, {0, 0, 0}, {2, 1, 0}};
        Matrix matrix3 = new Matrix(inputArray3);
        Matrix matrix4 = new Matrix(inputArray4);
        System.out.println(matrix3);
        System.out.println(matrix4);
        System.out.println("Умножение матриц: " + Matrix.getProduct(matrix3, matrix4));
        System.out.println();

        double[][] inputArray5 = {{1, 2, 2}, {3, 1, 1}};
        double[][] inputArray6 = {{4, 2}, {3, 1}, {1, 5}};
        Matrix matrix5 = new Matrix(inputArray5);
        Matrix matrix6 = new Matrix(inputArray6);
        System.out.println(matrix5);
        System.out.println(matrix6);
        System.out.println("Умножение матриц: " + Matrix.getProduct(matrix6, matrix5));
        System.out.println();

        matrix6.transpose();
        System.out.println("Транспонирование матрицы: " + matrix6);
        System.out.println();

        System.out.println(vector2);
        System.out.println(matrix6.multiplyByVector(vector2));
    }
}