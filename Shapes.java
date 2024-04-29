import java.util.Scanner; // Scanner will be used to get user input and make the program interactive.

public class Shapes {
   static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("\nWelcome to our Shapes program! \nFeel free any time to exit by entering '-1'.");


        do {
            // Run at least once, until user terminates program using sentinel value, 'q'.
            // ...
            System.out.print("\nThe following shapes are available for creation: " +
                    "\n\t1 - Rectangle, \n\t2 - Trapezium, \n\t3 - Rhombus, \n\t4 - Circle."
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
                case -1:
                    enter("-1");
                default:
                    continue;
            }
            if (!shape.equals(null)) {
                System.out.println("This " + shape.name + " has a perimeter of "
                        + shape.getPerimeter() + " and  an area of " + shape.getArea() + ".");
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
    /**
     * This is the base shape class from which all other shape classes will inherit.
     * 
     * @Author Francis Kalunga
     */
    public String name;

    public abstract double getPerimeter();

    public abstract double getArea();
}

class Circle extends Shape {
    /**
     * @author Francis Kalunga
     */

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
            super.sides = new double[] { length, width };
            super.name = "Rectangle";
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
        super.sides = new double[] { side, diagonal1, diagonal2, side };
        super.name = "Rhombus";
    }

    @Override
    public double getArea() {
        return sides[1] * sides[2] / 2;
    }
}
