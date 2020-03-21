package learn.oop.jpdppp.examples.iterators.decorated.inputstreams;

import learn.oop.jpdppp.tools.StopWatch;

import java.io.*;

public class InputStreamEfficiency {
    @SuppressWarnings("SpellCheckingInspection")
    public static void main(String[] args) throws IOException {
        String path = "data/mobydick.txt";
        long t1 = readUnbuffered(path);
        long t2 = readUsingArrayBuffer(path);
        long t3 = readDecoratorsBuffer(path);
        long t4 = readDecoratorsBufferWithArrayBuffer(path);
        System.out.println("Unbuffered time              = " + t1);
        System.out.println("Array buffer time            = " + t2);
        System.out.println("Decorator buffer time        = " + t3);
        System.out.println("Decorator double buffer time = " + t4);
    }

    private static long readUnbuffered(String path) throws IOException {
        long time;
        try (InputStream in = new FileInputStream(path)) {
            StopWatch stopWatch = new StopWatch();
            int b = 0;
            while (b != -1) {
                b = in.read();
            }
            time = stopWatch.stop();
        }
        return time;
    }

    private static long readUsingArrayBuffer(String path) throws IOException {
        long time;
        try (InputStream in = new FileInputStream(path)) {
            byte[] buffer = new byte[100];
            StopWatch stopWatch = new StopWatch();
            int nRead = 0;
            while (nRead != -1) {
                nRead = in.read(buffer);
            }
            time = stopWatch.stop();
        }
        return time;
    }

    private static long readDecoratorsBuffer(String path) throws IOException {
        long time;
        try (InputStream in = new BufferedInputStream(new FileInputStream(path))) {
            StopWatch stopWatch = new StopWatch();
            int b = 0;
            while (b != -1) {
                b = in.read();
            }
            time = stopWatch.stop();
        }
        return time;
    }

    private static long readDecoratorsBufferWithArrayBuffer(String path) throws IOException {
        long time;
        try (InputStream in = new BufferedInputStream(new FileInputStream(path))) {
            byte[] buffer = new byte[1024 * 4];
            StopWatch stopWatch = new StopWatch();
            int nRead = 0;
            while (nRead != -1) {
                nRead = in.read(buffer);
            }
            time = stopWatch.stop();
        }
        return time;
    }
}
