import java.util.*;

public class exercise102 {
    public static void main(String[] args){
        System.out.print("Press Enter to compute and show function values.\n");
        Scanner scan = new Scanner(System.in);
        scan.nextLine();
        
        System.out.println("n\t|n^2\t|n^3\t|2^n\t|e^n\t|10^n\t");
        for (int i=0; i<=100; i++){
            System.out.printf("%d\t|%d\t|%d\t|%.0f\t|%.0f\t|%.0f\t\n",i,i*i,i*i*i,Math.pow(2, i), Math.exp(i),Math.pow(10, i));
        }
    }
}
