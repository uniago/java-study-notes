package $02_core.$10_utils.demo03;

// import java.util.HexFormat;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        byte[] data = "Hello".getBytes();
        // HexFormat hf = HexFormat.of();
        // String hexData = hf.formatHex(data); // 48656c6c6f

        // 分隔符为空格，添加前缀0x，大写字母:
        // HexFormat hf = HexFormat.ofDelimiter(" ").withPrefix("0x").withUpperCase();
        // hf.formatHex("Hello".getBytes())); // 0x48 0x65 0x6C 0x6C 0x6F

        // byte[] bs = HexFormat.of().parseHex("48656c6c6f");
    }
}