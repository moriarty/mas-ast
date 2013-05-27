//import java.io.*;
import java.util.*;

public class A1ex1{
    public static void main(String[] args){
        boolean valid = true;
        int n=-1, count = 0, foo;
        // How many numbers will we be working with.
        do{
            System.out.print("Input an Integer between 1 and 100: ");
            Scanner scan = new Scanner(System.in);
            try {
                n = scan.nextInt();
                if ( n > 0 && n <= 100){
                    valid = true;
                } else {
                    System.out.print("Your input was not in the valid range.\n");
                    valid = false;
                }
            } catch (InputMismatchException e){
                System.out.print("Please enter an Integer!\n");
                valid = false;
            }
        } while (!valid);
        // Good, we know how many, now get the values.
        System.out.printf("Now, enter %d more integers.\n",n);
        int[] values = new int[n];
        do{
            System.out.printf("%d: ",count+1);
            Scanner scan = new Scanner(System.in);
            try {
                foo = scan.nextInt();
                values[count] = foo;
                count++;
            } catch (InputMismatchException e){
                System.out.print("That wasn't an integer.\n");
            }
        } while (count < n);
        // Got our values.
        // Time to compute some statistics.
        // We can get the first 4 values easy.
        // our array of statistics will be
        // smallest, largest, sum, product, average, variance
        int[] stat = new int[6];
        foo = 0;
        stat[0] = values[0]; // init min val
        stat[1] = values[1]; // init max val
        stat[3] = 1;         // init product
        for (int i=0; i < n; i++){
            stat[2] += values[i];
            foo += values[i]*values[i];
            stat[3] *= values[i];
            if (values[i] < stat[0]){
                stat[0] = values[i];
            }
            if (values[i] > stat[1]){
                stat[1] = values[i];
            }
        }
        // Now average is trivial
        stat[4] = stat[2]/n;
        // Now calculate variance using foo variable form above
        stat[5] = foo/n - stat[4]*stat[4];
        
        System.out.print("Statistics:\n");
        System.out.printf("Min: %d\t", stat[0]);
        System.out.printf("Max: %d\n", stat[1]);
        System.out.printf("Sum: %d\t", stat[2]);
        System.out.printf("Product: %d\n", stat[3]);
        System.out.printf("Mean: %d\t", stat[4]);
        System.out.printf("Variance: %d\n", stat[5]);
        
        System.out.print("Values Entered:\n[");
        for (int i=0; i<n-1; i++){
            System.out.printf(" %d,",values[i]);
        }
        System.out.printf(" %d ]\n", values[n-1]);
        
        
        
        
        System.exit(0);
    }
    /**
    public static boolean isPrime(int x){
        for (int x=2; i<=Math.sqrt(x); i++ ){
            if (x % i == 0){
                return false;
            }
        }
        return true;
    }
    */

}
