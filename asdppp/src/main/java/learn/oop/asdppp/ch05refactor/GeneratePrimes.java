package learn.oop.asdppp.ch05refactor;

/**
 * Generates primes to a a user-specified maximum.
 * Uses algorithm Sieve of Eratosthenes.
 */
public class GeneratePrimes {

    public static int[] generate(int maxValue) {
        if (maxValue >= 2) {
            // declarations
            int s = maxValue + 1; // size of array
            boolean[] f = new boolean[s];
            int i;

            // initialize array
            for (i = 0; i < s; i++) {
                f[i] = true;
            }

            // get rid of known non-primes
            f[0] = f[1] = false;

            // sieve
            int j;
            for (i = 2; i < Math.sqrt(s) + 1; i++) {
                if (f[i]) { // if i is uncrossed, cross its multiples
                    for (j = 2 * i; j < s; j += i) {
                        f[j] = false;   // multiple is not prime
                    }
                }
            }

            // how many primes are there?
            int count = 0;
            for (i = 0; i < s; i++) {
                if (f[i]) {
                    count++;
                }
            }
            int[] primes = new int[count];

            // move the primes into the result
            for (i = 0, j = 0; i < s; i++) {
                if (f[i]) {
                    primes[j++] = i;
                }
            }
            return primes;
        } else {
            return new int[0];  // return empty array if bad input
        }
    }
}
