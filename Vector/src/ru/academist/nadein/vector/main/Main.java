package ru.academist.nadein.vector.main;

import ru.academist.nadein.vector.vector.Vector;

public class Main {
    public static void main(String[] args) {
        double[] inputArray1 = {1, 4};
        Vector vector1 = new Vector(inputArray1);
        System.out.println(vector1.getComponentByIndex(0));
        System.out.println("вектор 1: " + vector1);
        System.out.println();

        Vector vector2 = new Vector(vector1);
        vector2.setComponentByIndex(0, 9);
        System.out.println("вектор 2: " + vector2);
        System.out.println();

        Vector vector3 = new Vector(3);
        System.out.println("вектор 3: " + vector3);
        System.out.println(vector3.getSize());
        System.out.println();

        Vector vector4 = new Vector(5, inputArray1);
        System.out.println("вектор 4: " + vector4);
        vector4.deploy();
        System.out.println("вектор 4: " + vector4);
        System.out.println();

        Vector vector5 = new Vector(inputArray1);
        double[] inputArray2 = {1, 2, 5};
        double[] inputArray3 = {1, 2};
        Vector vector6 = new Vector(inputArray2);
        Vector vector7 = new Vector(inputArray3);
        System.out.println("вектор 5" + vector5);
        System.out.println("вектор 6" + vector6);
        vector5.add(vector6);
        System.out.println("вектор 5 + вектор 6: " + vector5);
        System.out.println();

        System.out.println("вектор 5" + vector5);
        System.out.println("вектор 7" + vector7);
        vector5.add(vector7);
        System.out.println("вектор 5 + вектор 7: " + vector5);
        System.out.println();

        System.out.println("вектор 7" + vector7);
        vector5.subtract(vector7);
        System.out.println("вектор 5 - вектор 7: " + vector5);
        System.out.println();

        System.out.println("Результат сложение двух векторов = " + Vector.getSum(vector1, vector4));
        System.out.println("Результат вычитания двух векторов = " + Vector.getDifference(vector4, vector1));
        System.out.println();

        double scalar = 2;
        vector7.multiplyByScalar(scalar);
        System.out.println("умножение вектора 7 на скаляр " + scalar + " = " + vector7);
        System.out.println();

        System.out.println("скалярное произведение векторов = " + Vector.getScalarProduct(vector7, vector5));
        System.out.println();

        System.out.println(vector1.equals(vector2));
        double[] inputArray4 = {2, 4};
        Vector vector8 = new Vector(inputArray4);
        Vector vector9 = new Vector(inputArray4);
        System.out.println(vector7);
        System.out.println(vector8.equals(vector7));
        System.out.println(vector9.equals(vector7));
        System.out.println(vector7.equals(vector8));
    }
}