package $08_io.$07_serialize.demo01;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
        try (ObjectOutputStream output = new ObjectOutputStream(buffer)) {
            // –¥»Îint:
            output.writeInt(12345);
            // –¥»ÎString:
            output.writeUTF("Hello");
            // –¥»ÎObject:
            output.writeObject(Double.valueOf(123.456));
        }
        System.out.println(Arrays.toString(buffer.toByteArray()));
    }
}