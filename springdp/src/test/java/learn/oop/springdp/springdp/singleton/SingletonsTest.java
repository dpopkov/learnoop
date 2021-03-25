package learn.oop.springdp.springdp.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class SingletonsTest {

    @Autowired
    SingletonAsSpringBean singletonBean1;

    @Autowired
    SingletonAsSpringBean singletonBean2;

    @Test
    void testSingletons() {
        SingletonTraditional singleton1 = SingletonTraditional.getInstance();
        SingletonTraditional singleton2 = SingletonTraditional.getInstance();
        assertNotNull(singleton1);
        assertNotNull(singleton2);
        assertSame(singleton1, singleton2);

        assertNotNull(singletonBean1);
        assertNotNull(singletonBean2);
        assertSame(singletonBean1, singletonBean2);
    }
}
