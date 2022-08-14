package triangle;

import ru.academits.nadein.shapes.Shape;

public class Triangle implements Shape {
    private double xA;
    private double yA;
    private double xB;
    private double yB;
    private double xC;
    private double yC;

    public Triangle(double xA, double yA, double xB, double yB, double xC, double yC) {
        this.xA = xA;
        this.yA = yA;
        this.xB = xB;
        this.yB = yB;
        this.xC = xC;
        this.yC = yC;
    }

    public void setxA(double xA) {
        this.xA = xA;
    }

    public void setxB(double xB) {
        this.xB = xB;
    }

    public void setxC(double xC) {
        this.xC = xC;
    }

    public void setyA(double yA) {
        this.yA = yA;
    }

    public void setyB(double yB) {
        this.yB = yB;
    }

    public void setyC(double yC) {
        this.yC = yC;
    }

    @Override
    public double getWidth() {
        return Math.max(Math.max(xA, xB), xC) - Math.min(Math.min(xA, xB), xC);
    }

    @Override
    public double getHeight() {
        return Math.max(Math.max(yA, yB), yC) - Math.min(Math.min(yA, yB), yC);
    }

    @Override
    public double getArea() {
        double epsilon = 1.0e-10;
        double triangleArea = 0;

        if (Math.abs((xA - xC) * (yB - yC) - (xB - xC) * (yA - yC)) <= epsilon) {
            return triangleArea;
        } else {
            double sideABLength = Math.sqrt(Math.pow(xB - xA, 2) + Math.pow(yB - yA, 2));
            double sideACLength = Math.sqrt(Math.pow(xC - xA, 2) + Math.pow(yC - yA, 2));
            double sideBCLength = Math.sqrt(Math.pow(xB - xC, 2) + Math.pow(yB - yC, 2));

            double triangleSemiPerimeter = (sideABLength + sideACLength + sideBCLength) / 2;
            triangleArea = Math.sqrt(triangleSemiPerimeter * (triangleSemiPerimeter - sideABLength)
                    * (triangleSemiPerimeter - sideACLength) * (triangleSemiPerimeter - sideBCLength));
        }

        return triangleArea;
    }

    @Override
    public double getPerimeter() {
        double epsilon = 1.0e-10;
        double trianglePerimeter = 0;

        if (Math.abs((xA - xC) * (yB - yC) - (xB - xC) * (yA - yC)) <= epsilon) {
            return trianglePerimeter;
        } else {
            double sideABLength = Math.sqrt(Math.pow(xB - xA, 2) + Math.pow(yB - yA, 2));
            double sideACLength = Math.sqrt(Math.pow(xC - xA, 2) + Math.pow(yC - yA, 2));
            double sideBCLength = Math.sqrt(Math.pow(xB - xC, 2) + Math.pow(yB - yC, 2));

            trianglePerimeter = (sideABLength + sideACLength + sideBCLength);
        }

        return trianglePerimeter;
    }
}
