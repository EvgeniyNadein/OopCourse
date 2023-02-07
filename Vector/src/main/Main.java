package main;

import vector.Vector;

public class Main {

    public static void main(String[] args) {
        double[] inputArray = {1};
        Vector vector1 = new Vector(inputArray);
        System.out.println(vector1.get(0));
        System.out.println("вектор 1: " + vector1);

        Vector vector2 = new Vector(vector1);
        vector2.set(0, 9);
        System.out.println("вектор 2: " + vector2);

        Vector vector3 = new Vector(3);
        System.out.println("вектор 3: " + vector3);
        System.out.println(vector3.getSize());
    }
}
