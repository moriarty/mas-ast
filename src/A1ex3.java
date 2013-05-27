import java.util.InputMismatchException;
import java.util.Scanner;
//import java.math;


public class A1ex3 extends A1ex2 {
    // write a program that inputs the diameter of a circle and outputs the circumference and area of the circle. 
    // circle should extend some shape class if I cared for OOP, maybe I'll do that later
    
    
    public static void main(String[] args){
        boolean valid = true;
        double d = 0;
        int n = 0;
        
        do {
            System.out.print("Input the diameter of circle: ");
            try {
                Scanner scan = new Scanner(System.in);
                d = scan.nextDouble();
                // Check if number is reasonable
                if ( d > 0 ){
                    valid = true;
                } else {
                    System.out.print("The diameter must be positive.\n");
                    valid = false;
                }
            // Catch if it is not valid input
            } catch (InputMismatchException e){
                System.out.print("Please enter a Double!\n");
                valid = false;
            }
        } while (!valid);
        // Output circ and area
        System.out.printf("%.8f\n",d);
        System.out.printf("%.8f\n\n",Math.PI*d);
        System.out.printf("%f\n",((Math.PI/4.0)*Math.pow(d, 2)));
        
        // Ask user for precision
        do {
            System.out.print("Input max precision for PI (integer): ");
            Scanner scan = new Scanner(System.in);
            try {
                n = scan.nextInt();
                // Check if number is reasonable
                if ( n > 0 && n < 17){
                    valid = true;
                } else {
                    System.out.print("Java's Math.PI only provides 16 digits, you're input was out of range.\n");
                    valid = false;
                }
            // Catch if it is not valid input
            } catch (InputMismatchException e){
                System.out.print("Please enter an Integer!\n");
                valid = false;
            }
        } while (!valid);
        // Approximate by iterating over the number of digits of precision for PI. 
        // 1:3, 2:3.1, 3:3.14 ... n:3.1415...
        double thisArea = 0;
        double thisCirc = 0;
        double prevArea = 0;
        double prevCirc = 0;
        double dArea = 0;
        double dCirc = 0;
        String foo = "|%-18s";
        System.out.printf(foo+foo+foo+foo+foo+foo,"percision","Pi","Area","% increase", "Circ.","% increase");
        for (int i=0; i<n; i++){
            double fooPi = Math.floor(Math.PI*Math.pow(10, i));
            double thisPi = fooPi*Math.pow(10, -i);
            // Output increase in percentage of circumference and area over the previous iteration.
            //Area = pi/4 * D^2, Circ = pi*d
            thisArea = (thisPi/4.0)*Math.pow(d, 2);
            thisCirc = thisPi*d;
            // Java is magic and handles the error itself?
            dArea = (thisArea - prevArea ) / prevArea;
            dCirc = (thisCirc - prevCirc ) / prevCirc;
            prevArea = thisArea;
            prevCirc = thisCirc;
            //}
            foo = "%-19."+i+"f";
            System.out.printf("\n %-19d"+foo+foo+"%-19.15f"+foo+"%-19.15f",i+1,thisPi,thisArea,dArea,thisCirc,dCirc);
            
        
        }
        System.exit(0);
    }
}
