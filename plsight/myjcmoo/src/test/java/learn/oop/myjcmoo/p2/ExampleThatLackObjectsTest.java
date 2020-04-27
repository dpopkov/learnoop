package learn.oop.myjcmoo.p2;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExampleThatLackObjectsTest {

    @Test
    public void testSummingWithFlag() {
        ExampleThatLackObjects e = new ExampleThatLackObjects();
        int[] a = {1, 2, 3, 4};
        int r;
        r = e.sum3(a, false);
        assertEquals(10, r);
        r = e.sum3(a, true);
        assertEquals(6, r);
    }
}
