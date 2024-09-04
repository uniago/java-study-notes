package $07_collection.$08_properties.demo01;// properties
import java.io.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws IOException {
        String f = "setting.properties";
        Properties props = new Properties();
        // 从文件系统读取
        // props.load(new java.io.FileInputStream(f));
        // 从classpath读取
        props.load(Main.class.getResourceAsStream(f));

        String filepath = props.getProperty("last_open_file");
        String interval = props.getProperty("auto_save_interval", "120");

        System.out.println("filepath = " + filepath);
        System.out.println("interval = " + interval);
    }
}