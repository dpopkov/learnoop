package learn.oop.jpdppp.examples.hierarchies;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class RangeListTest {

    @Test
    public void whenGetThenReturnsIntegerInRange() {
        RangeList range = new RangeList(3);
        assertThat(range.get(0), is(0));
        assertThat(range.get(1), is(1));
        assertThat(range.get(2), is(2));
        assertThat(range.size(), is(3));
    }
}
