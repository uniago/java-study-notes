package $08_io.$10_print.demo01;

import java.io.*;
import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) {
        StringWriter buffer = new StringWriter();
        try (PrintWriter pw = new PrintWriter(buffer)) {
            pw.println("Hello");
            pw.println(12345);
            pw.println(true);
        }
        System.out.println(buffer.toString());
        System.err.println(buffer);

        // 模拟 System.out
        try (OutputStream fos = new FileOutputStream(FileDescriptor.out);
             PrintStream customOut = new PrintStream(fos, true, Charset.defaultCharset())) {
            customOut.println("hello哇");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}