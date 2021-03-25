package learn.oop.springdp.springdp.prototype;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PrototypesTest {

    @Autowired
    ProtoTrue protoTrue1;
    @Autowired
    ProtoTrue protoTrue2;

    @Autowired
    ProtoFalse protoFalse1;
    @Autowired
    ProtoFalse protoFalse2;

    @Test
    void testPrototypes() {
        assertNotNull(protoTrue1);
        assertNotNull(protoTrue2);
        assertNotSame(protoTrue1, protoTrue2);

        assertNotNull(protoFalse1);
        assertNotNull(protoFalse2);
        assertSame(protoFalse1, protoFalse2);
    }
}
