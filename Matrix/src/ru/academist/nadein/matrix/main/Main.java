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
        Matrix matrix2 = new Matrix(array);

        System.out.println(matrix1);
        System.out.println(matrix2);
        System.out.println();

        System.out.println(matrix2.getVectorColumnByIndex(1));

        matrix2.add(matrix1);
        System.out.println("Сложение матриц: " + matrix2);
        matrix2.subtract(matrix1);
        System.out.println("Вычитание матриц: " + matrix2);
        matrix1.multiplyByScalar(3);
        System.out.println("Умножение матрицы на скаляр: " + matrix1);
    }
}