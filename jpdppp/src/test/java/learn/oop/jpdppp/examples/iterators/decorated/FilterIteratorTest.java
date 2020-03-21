package learn.oop.jpdppp.examples.iterators.decorated;

import org.junit.Test;

import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class FilterIteratorTest {

    @Test
    public void whenNotFilteringThenReturnsAllItems() {
        Iterator<String> it0 = List.of("a", "b").iterator();
        FilterIterator<String> it = new FilterIterator<>(it0, s -> true);
        assertTrue(it.hasNext());
        assertEquals("a", it.next());
        assertTrue(it.hasNext());
        assertEquals("b", it.next());
        assertFalse(it.hasNext());
    }

    @Test
    public void whenFilteringThenReturnsFilteredItemsOnly() {
        Iterator<String> it0 = List.of("a", "cc", "b").iterator();
        FilterIterator<String> it = new FilterIterator<>(it0, s -> s.length() == 2);
        assertTrue(it.hasNext());
        assertEquals("cc", it.next());
        assertFalse(it.hasNext());
    }
}
