import java.util.ArrayList;
import java.util.Scanner; // Scanner will be used to get user input and make the program interactive.

public class Shape {
    public static void main(String[] args) {
        Shape[] shapes = new ArrayList<>(); // Keeps all shapes created during program execution.

        Scanner input = new Scanner(system.in);

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