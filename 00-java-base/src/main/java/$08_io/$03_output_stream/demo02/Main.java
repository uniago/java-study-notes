package $08_io.$03_output_stream.demo02;

import java.io.*;

public class Main {
    public static void main(String[] args)  {
        args = new String[]{"readme.md", "readme2.md"};
        try (FileInputStream fis = new FileInputStream(args[0]);
             FileOutputStream fos = new FileOutputStream(args[1])) {
            // test01(fis, fos);
            test02(fis, fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void test01(InputStream is, OutputStream os) throws IOException {
        byte[] bytes = new byte[1024];
        while (is.read(bytes) != -1) {
            os.write(bytes);
        }
        os.flush();
    }

    public static void test02(InputStream is, OutputStream os) throws IOException {
        int n;
        while((n = is.read()) != -1) {
            os.write(n);
        }
        os.flush();
    }
}
