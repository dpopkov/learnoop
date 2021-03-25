package learn.oop.springdp.springdp.adapter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AppleAdapterTest {

    @Test
    void testAdapter() {
        Orange orange = new MoroOrange();
        Apple adapter = new AppleAdapter(orange);

        String variety = adapter.getVariety();
        assertEquals("Moro Blood Orange", variety);
        String eat = adapter.eat();
        assertEquals("Moro gets peeled, Moro gets enjoyed", eat);
    }
}
