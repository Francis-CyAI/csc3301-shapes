import java.util.ArrayList;
import java.util.Scanner; // Scanner will be used to get user input and make the program interactive.

public class Shapes {
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<Shape>(); // Keeps all shapes created during program execution.

        Scanner input = new Scanner(System.in);

        do {
            // Run at least once, until user terminates program using sentinel value, 'q'.
            // ...
            break;
        } while (true);

        Shape rec = new Rectangle(10, 5);
        Shape rhom = new Rhombus(5, 3, 2);
        Shape trap = new Trapezium(5, 7, 6, 8, 6);

        System.out.println(rec.getArea());
        System.out.println(rec.getPerimeter());
        System.out.println(rhom.getArea());
        System.out.println(rhom.getPerimeter());
        System.out.println(trap.getArea());
        System.out.println(trap.getPerimeter());
    }
    
}


abstract class Shape {
    /**
     * This is the base shape class from which all other shape classes will inherit.
     * @author Francis Kalunga
     */
    public abstract double getPerimeter();

    public abstract double getArea();
}

abstract class Polygon extends Shape {
    /**
     * @Author Francis Kalunga
     */
    double[] sides; // = new double[] {12.5, 14, ...};
    // private double l = sides[0]; // length
    // private double h = sides[1]; // height

    @Override
    public double getPerimeter() {
        double p = 0;
        for (int i = 0; i < sides.length; i++) {
            p += sides[i];
        }
        return p;
    }
}

abstract class Quadrilateral extends Polygon {
    /**
     * @Author Mike Shatamuka
     */
    public Quadrilateral(double side1, double side2, double side3, double side4) {
        sides = new double[] { side1, side2, side3, side4 };
    }

}

abstract class Octagon extends Polygon {
    /**
     * @Author Mike Shatamuka
     */
    public Octagon(double sideLength) {
        sides = new double[8];
        for (int i = 0; i < 8; i++) {
            sides[i] = sideLength;
        }
    }

}

class Rectangle extends Polygon {
    public Rectangle(double length, double width) {
        super.sides = new double[]{length, width};
    }

    @Override
    public double getArea() {
        return super.sides[0] * super.sides[1];
    }

    @Override
    public double getPerimeter() {
        return 2 * (super.sides[0] + super.sides[1]);
    }
}

class Trapezium extends Polygon {
    public Trapezium(double a, double b, double h, double c, double d) {
        super.sides = new double[] { a, b, h, c, d };
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
        super.sides =  new double[] { side, diagonal1, diagonal2, side };
    }

    @Override
    public double getArea() {
        return sides[1] * sides[2] / 2;
    }
}

