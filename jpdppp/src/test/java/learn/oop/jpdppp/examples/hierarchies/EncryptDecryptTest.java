package learn.oop.jpdppp.examples.hierarchies;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.junit.Assert.*;

public class EncryptDecryptTest {

    @Test
    public void testEncrypt() throws IOException {
        String s = "abc";
        ByteArrayInputStream in = new ByteArrayInputStream(s.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        new EncryptDecrypt(1).encrypt(in, out);
        assertEquals("bcd", out.toString());
    }

    @Test
    public void testDecrypt() throws IOException {
        String s = "bcd";
        ByteArrayInputStream in = new ByteArrayInputStream(s.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        new EncryptDecrypt(1).decrypt(in, out);
        assertEquals("abc", out.toString());
    }
}
