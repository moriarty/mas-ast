public class PrimeSieve {
    public static void main(String[] args) { 
        int N = 0;
        if (args.length > 0){
            try {
                N = Integer.parseInt(args[0]);
            } catch (NumberFormatException e){
                System.out.println("Sorry, are you sure you entered an integer?");
                System.exit(0);
            }

        } else {
            N = Integer.MAX_VALUE;
        }
        System.out.println("Calculations starting now, hold tight!");

        // initially assume all integers are prime
        // require a bunch of variables for tracking time.
        // ss/se = sieve start/sieve end
        // ls/le = initialize array start/ end
        // cs/ce = count primes start / end 
        long ls, le, ss, se, cs, ce;
        ls = System.currentTimeMillis();
        boolean[] isPrime = new boolean[N];
        for (int i = 1; i < N; i++) {
            isPrime[i] = true;
        }
        le = System.currentTimeMillis();
        long n=0;
        ss = System.currentTimeMillis();
        // mark non-primes <= N using Sieve of Eratosthenes
        for (long i = 1; i*i < N; i++) {
            n = i+1;
            // if i is prime, then mark multiples of i as nonprime
            // suffices to consider mutiples i, i+1, ..., N/i
            if (isPrime[(int)i]) {
                System.out.println(n);
                for (long j = n; (n*j)-1 < N; j++) {
                    isPrime[(int)((n*j)-1)] = false;
                }
            }
        }
        se = System.currentTimeMillis();

        // count primes
        cs = System.currentTimeMillis();
        int primes = 0;
        for (long i = 1; i < N; i++) {
            if (isPrime[(int)i]) primes++;
        }
        ce = System.currentTimeMillis();
        
        // foo is a For Once Only variable.
        // I could call it temporary, temporaryVariable
        // or forOnceOnlyVariable, 
        // or if I was a javaFan: thisVariableJustHoldsATemporaryValueNeededForSearchingForLargestPrime 
        long foo = 0;
        for (long i = N-1; i > 0; i--){
            if (isPrime[(int)i]){
                foo = i+1;
                break;
            }
        }
        System.out.println("Time Taken:");
        System.out.printf("Initialize Array: %d (ms)\n",le-ls);
        System.out.printf("Calculate All primes: %d (ms)\n",se-ss);
        System.out.printf("Count All primes: %d (ms)\n",ce-cs);
        System.out.println("The number of primes <= " + N + " is " + primes);
        System.out.println("The largest prime found is " + foo);
        System.out.println("Part 2, find all primes between 0 and longest long int, skipped");
    }
}
