package learn.oop.asdppp.ch05refactor;

import org.junit.Test;

import static org.junit.Assert.*;

public class GeneratePrimesTest {

    @Test
    public void testGenerate() {
        int[] nullArray = GeneratePrimes.generate(0);
        assertEquals(0, nullArray.length);

        int[] minArray = GeneratePrimes.generate(2);
        assertEquals(1, minArray.length);
        assertEquals(2, minArray[0]);

        int[] threeArray = GeneratePrimes.generate(3);
        assertEquals(2, threeArray.length);
        assertEquals(2, threeArray[0]);
        assertEquals(3, threeArray[1]);

        int[] centArray = GeneratePrimes.generate(100);
        assertEquals(25, centArray.length);
        assertEquals(97, centArray[24]);
    }
}
