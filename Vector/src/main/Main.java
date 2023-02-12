package main;

import vector.Vector;

public class Main {

    public static void main(String[] args) {
        double[] inputArray1 = {1, 4};
        Vector vector1 = new Vector(inputArray1);
        System.out.println(vector1.getComponentByIndex(0));
        System.out.println("������ 1: " + vector1);
        System.out.println();

        Vector vector2 = new Vector(vector1);
        vector2.setComponentByIndex(0, 9);
        System.out.println("������ 2: " + vector2);
        System.out.println();

        Vector vector3 = new Vector(3);
        System.out.println("������ 3: " + vector3);
        System.out.println(vector3.getSize());
        System.out.println();

        Vector vector4 = new Vector(5, inputArray1);
        System.out.println("������ 4: " + vector4);
        vector4.vectorReversal();
        System.out.println("������ 4: " + vector4);
        System.out.println();

        Vector vector5 = new Vector(inputArray1);
        double[] inputArray2 = {1, 2, 5};
        double[] inputArray3 = {1, 2};
        Vector vector6 = new Vector(inputArray2);
        Vector vector7 = new Vector(inputArray3);
        System.out.println("������ 5" + vector5);
        System.out.println("������ 6" + vector6);
        vector5.vectorsAdding(vector6);
        System.out.println("������ 5 + ������ 6: " + vector5);
        System.out.println();

        System.out.println("������ 5" + vector5);
        System.out.println("������ 7" + vector7);
        vector5.vectorsAdding(vector7);
        System.out.println("������ 5 + ������ 7: " + vector5);
        System.out.println();

        System.out.println("������ 7" + vector7);
        vector5.vectorSubtraction(vector7);
        System.out.println("������ 5 - ������ 7: " + vector5);
        System.out.println();

        System.out.println("��������� �������� ���� �������� = " + Vector.twoVectorsAdding(vector1, vector4));
        System.out.println("��������� ��������� ���� �������� = " + Vector.twoVectorsSubtraction(vector4, vector1));
        System.out.println();

        vector7.multiplyVectorByScalar(2);
        System.out.println("��������� ������� 7 �� ������ = " + vector7);
        System.out.println();

        System.out.println("��������� ������������ �������� = " + Vector.vectorsProductScalar(vector7, vector5));
    }
}
