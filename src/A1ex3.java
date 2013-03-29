import java.util.InputMismatchException;
import java.util.Scanner;
import java.math;


public class A1ex3 extends A1ex2 {
    public static void main(String[] args){
        boolean valid = true;
        int n = 0;
        int pi = Math.
        // Ask user for precision
        do {
            System.out.print("Input max precision for PI (integer): ");
            Scanner scan = new Scanner(System.in);
            try {
                n = scan.nextInt();
                // Check if number is reasonable
                if ( n > 0 && n <= 15){
                    valid = true;
                } else {
                    System.out.print("Java's Math.PI only provides 15 digits, you're input was out of range.\n");
                    valid = false;
                }
            // Catch if it is not valid input
            } catch (InputMismatchException e){
                System.out.print("Please enter an Integer!\n");
                valid = false;
            }
        } while (!true);
        // Approximate by iterating over the number of digits of precision for PI. 
        // 1:3, 2:3.1, 3:3.14 ... n:3.1415...
        for (int i=0; i<n; i++){
            
            // Output increase in percentage of circumference and area over the previous iteration.
        
        }
    }
}
