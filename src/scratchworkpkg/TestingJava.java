package scratchworkpkg;

import java.util.Arrays;
import java.util.Random;
import java.math.*;

/**
 * 
 * Scratch work.. mostly for testing prime algorithms.
 * 
 * @author alex
 *
 */

/*
Random (int) between Min and Max.
Min + (int)(Math.random()*((Max-Min) + 1));
*/


public class TestingJava {
    public static void main(String[] args){
        
        int N = 10;
        int X_MIN = 0;
        int Y_MIN = 0;
        int X_MAX = 10;
        int Y_MAX = 10;
        int GRANULARITY = 100;
        
        Random generator = new Random( 25368478 );
        
        int[] xData = new int[N];
        int[] xSampled = new int[N];
        int[] yData = new int[N];
        int[] ySampled = new int[N];
        double[] value = new double[N];
        double sum = 0;
        
        
        int[] pick_from = new int[GRANULARITY];
        
        for (int i = 0; i<N; i++){
            xData[i] = X_MIN + (int)(Math.random()*((X_MAX-X_MIN)+1));
            yData[i] = Y_MIN + (int)(Math.random()*((Y_MAX-Y_MIN)+1));
            value[i] = Math.random();
            sum += value[i];
        }
        int foo = 0;
        for (int i = 0; i<N; i++){
            value[i] = value[i]/sum;
            for (int c = 0; c < value[i]*GRANULARITY; c++){
                pick_from[c+foo] = i;
            }
            //System.out.printf("%d\t%f",foo,value[i]*GRANULARITY);
            foo = foo + (int)(value[i]*GRANULARITY);
            
        }
        int randomIndex = generator.nextInt(GRANULARITY);
        for (int i = 0; i < N; i++){
            randomIndex = generator.nextInt(GRANULARITY);
            xSampled[i] = xData[pick_from[randomIndex]];
            ySampled[i] = yData[pick_from[randomIndex]];
        }
        System.out.println();
        System.out.println(Arrays.toString(xData));
        System.out.println(Arrays.toString(yData));

        System.out.println(Arrays.toString(xSampled));
        System.out.println(Arrays.toString(ySampled));
        
        //System.out.println(Arrays.toString(pick_from));
    }
}
    //public static void main(String[] args){
        /**
        System.out.println("I will run");
        int primes = 0;
        System.out.println(System.currentTimeMillis());
        for (int i = 2; i < 1000000000; i++){
            if (isPrime(i)){
                primes++;
            }
        }
        **/
      /**  int primes = 0;
        //int foo = 2;
        long e;
        long s = System.currentTimeMillis();
        System.out.println(s);
        for (int i = 2; i<10000000; i++){
            if (isPrime(i)){
                primes ++;
                System.out.println(i);
            }
        }
        e = System.currentTimeMillis();
        System.out.println(e-s);
        System.out.println(primes);
//        System.out.println(foo);
        System.exit(0);
    }
    public static boolean isPrime(int x){
        // Input: n > 1 && odd
        // Output: true if prime, else false
        
        // Because n is "small" ref ( The Pseudoprimes to 25*10^9 )
        
        // n-1 as 2^s*d
        if (x == 2) return true;
        int s = 0, d=x-1;
        while(d%2==0){
            s++;
            d = d/2;
        }
        int foo = 2;
        boolean bar = false;
        int e = 0, r = 0;
        
        // Repeat for all a in set [2, min(n-1, floor(2(ln(x))^2))
        for (int i=0; i<a.length; i++){
            foo = a[i];
            for (int j=0; j<s; j++){
                e = (int) Math.pow(2, j);
                e = e*d;
                r = ((int) Math.pow(foo, e)) % x;
                if (r == x-1 || r==1){
                    bar = true;
                }
            }
            if (!bar){ return false; }
        }
        return true;
    }
    /*
     * 
     * //System.out.print(Math.PI);
        //int[] myPi = {1,4,1,5,9,2,6,5,3,5,8,9,7,9,3};
        //int thisPi = myPi[0:4];
        /*int n = 3;
        double myPi = Math.PI*Math.pow(10, n);
        long thisPi = Math.round(myPi);
        
        myPi = thisPi*Math.pow(10, -n);
        
        System.out.println(thisPi);
        */
/*        int i=2;
        System.out.printf("i= %."+i+"f\n",6.0000);
        String foo = "foo";

     * 
     * 2 147 483 647
     */
