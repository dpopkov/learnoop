package learn.oop.asdppp.ch05refactor;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrimeGeneratorTest {

    @Test
    public void testGenerate() {
        int[] nullArray = PrimeGenerator.generate(0);
        assertEquals(0, nullArray.length);

        int[] minArray = PrimeGenerator.generate(2);
        assertEquals(1, minArray.length);
        assertEquals(2, minArray[0]);

        int[] threeArray = PrimeGenerator.generate(3);
        assertEquals(2, threeArray.length);
        assertEquals(2, threeArray[0]);
        assertEquals(3, threeArray[1]);

        int[] centArray = PrimeGenerator.generate(100);
        assertEquals(25, centArray.length);
        assertEquals(97, centArray[24]);
    }

    @Test
    public void testExhaustive() {
        for (int i = 2; i < 500; i++) {
            verifyPrimeList(PrimeGenerator.generate(i));
        }
    }

    private void verifyPrimeList(int[] list) {
        for (int value : list) {
            verifyPrime(value);
        }
    }

    private void verifyPrime(int n) {
        for (int factor = 2; factor < n; factor++) {
            assertTrue(n % factor != 0);
        }
    }
}
