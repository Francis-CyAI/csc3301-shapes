import java.util.ArrayList;
import java.util.Scanner; // Scanner will be used to get user input and make the program interactive.

public class Shapes {
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<Shape>(); // Keeps all shapes created during program execution.

        Scanner input = new Scanner(System.in);

        do {
            // Run at least once, until user terminates program using sentinel value, 'q'.
            // ...
        } while (true);
    }
    
}


abstract class Shape {
    /**
     * This is the base shape class from which all other shape classes will inherit.
     * @author Francis Kalunga
     */
    public abstract double perimeter();

    public abstract double area();
}