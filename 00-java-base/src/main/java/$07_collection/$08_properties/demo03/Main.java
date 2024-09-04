package $07_collection.$08_properties.demo03;// properties

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {
        Properties props = new Properties();
        props.setProperty("url", "http://www.liaoxuefeng.com");
        props.setProperty("language", "Java");
        props.setProperty("中文", "一段中文");
        // 编码写死:8859_1
        props.store(new FileOutputStream("setting-bak.properties"), "这是写入的properties注释");
        // 指定编码:UTF-8
        props.store(new FileWriter("setting-bak-utf8.properties", StandardCharsets.UTF_8), "这是写入的properties注释");
    }
}