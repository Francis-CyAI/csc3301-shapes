package com.example;
import java.util.Scanner;


public class Shapes {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("\nWelcome to our Shapes program! \nFeel free any time to exit by entering '-1'.");

        do {
            System.out.print("\nThe following shapes are available for creation: " +
                    "\n\t1 - Rectangle, \n\t2 - Trapezium, \n\t3 - Rhombus, \n\t4 - Circle, \n\t5 - Polygon."
                    + "\nEnter a number that corresponds to a shape to select that shape: ");

            int ans = input.nextInt();

            Shape shape = null;

            switch (ans) {
                case 1:
                    shape = new Rectangle(
                            enter("length"),
                            enter("width"));
                    break;
                case 2:
                    shape = new Trapezium(
                            enter("top length"),
                            enter("bottom length"),
                            enter("height"),
                            enter("left side length"),
                            enter("right side length"));
                    break;
                case 3:
                    shape = new Rhombus(
                            enter("side length"),
                            enter("diagonal1 length"),
                            enter("diagonal2 length"));
                    break;
                case 4:
                    shape = new Circle(
                            enter("radius"));
                    break;
                case 5:
                    int sides = (int)enter("number of sides");
                    double[] lengths = new double[sides];
                    for (int i = 0; i < sides; i++) {
                        lengths[i] = enter("length of side " + (i + 1));
                    }
                    shape = new Polygon(lengths);
                    break;
                case -1:
                    enter("-1");
                default:
                    continue;
            }
            if (shape != null) {
                System.out.println("This " + shape.name + " has a perimeter of "
                        + shape.getPerimeter() + " and an area of " + shape.getArea() + ".");
            }
        } while (true);        
    }

    static double enter(String w) {
        if (w.equals("-1")) {
            close();
        }
        System.out.print("\n\tEnter " + w + ": ");
        double in = input.nextDouble();
        if (in < 0) {
           close();
        }
        return in;
    }
    
    static void close() {
        System.out.print("Good bye!");
        System.exit(1);
    }
}

abstract class Shape {
    public String name;

    public abstract double getPerimeter();

    public abstract double getArea();
}

class Circle extends Shape {
    private double r;

    public Circle(double radius) {
        r = radius;
        super.name = "Circle";
    }

    @Override
    public double getPerimeter() {
        return 2 * 3.1416 * r; 
    }

    @Override
    public double getArea() {
        return 3.1416 * r * r;
    }
}    

class Polygon extends Shape {
    double[] sides; 

    public Polygon(double[] sides) {
        this.sides = sides;
        super.name = "Polygon";
    }

    @Override
    public double getPerimeter() {
        double p = 0;
        for (int i = 0; i < sides.length; i++) {
            p += sides[i];
        }
        return p;
    }

    @Override
    public double getArea() {
        double area = 0;
        int n = sides.length;
        for (int i = 0; i < n - 1; i++) {
            area += sides[i] * sides[i + 1];
        }
        area += sides[n - 1] * sides[0];
        for (int i = 0; i < n - 1; i++) {
            area -= sides[i + 1] * sides[i];
        }
        return Math.abs(area) / 2;
    }
}

class Rectangle extends Polygon {
    public Rectangle(double length, double width) {
        super(new double[] { length, width });
        super.name = "Rectangle";
    }

    @Override
    public double getArea() {
        return super.sides[0] * super.sides[1];
    }
}

class Trapezium extends Polygon {
    public Trapezium(double a, double b, double h, double c, double d) {
        super(new double[] { a, b, h, c, d });
        super.name = "Trapezium";
    }

    @Override
    public double getArea() {
        return sides[2] * (sides[0] + sides[1]) / 2;
    }

    @Override
    public double getPerimeter() {
        return super.getPerimeter() - sides[2]; // minus h
    }
}

class Rhombus extends Polygon {
    public Rhombus(double side, double diagonal1, double diagonal2) {
        super(new double[] { side, diagonal1, diagonal2, side });
        super.name = "Rhombus";
    }

    @Override
    public double getArea() {
        return sides[1] * sides[2] / 2;
    }
}
