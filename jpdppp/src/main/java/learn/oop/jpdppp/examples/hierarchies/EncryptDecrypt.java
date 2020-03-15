package learn.oop.jpdppp.examples.hierarchies;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class EncryptDecrypt {
    private int offset;

    public EncryptDecrypt(int offset) {
        this.offset = offset;
    }

    public void encrypt(InputStream in, OutputStream out) throws IOException {
        int x;
        while ((x = in.read()) != -1) {
            byte b = (byte) x;
            b += offset;
            out.write(b);
        }
    }

    public void decrypt(InputStream in, OutputStream out) throws IOException {
        int x;
        while ((x = in.read()) != -1) {
            byte b = (byte) x;
            b -= offset;
            out.write(b);
        }
    }
}
