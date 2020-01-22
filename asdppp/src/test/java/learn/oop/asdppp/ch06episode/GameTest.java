package learn.oop.asdppp.ch06episode;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void testOneThrow() {
        Game g = new Game();
        g.add(5);
        assertEquals(5, g.score());
    }

    @Test
    public void testTwoThrowsNoMark() {
        Game g = new Game();
        g.add(5);
        g.add(4);
        assertEquals(9, g.score());
    }

    @Test
    public void testFourThrowsNoMark() {
        Game g = new Game();
        g.add(5);
        g.add(4);
        g.add(7);
        g.add(2);
        assertEquals(18, g.score());
        assertEquals(9, g.scoreForFrame(1));
        assertEquals(18, g.scoreForFrame(2));
    }
}
