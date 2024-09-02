package $02_core.$01_string_encoding.demo04;

// String
public class Main {
    public static void main(String[] args) {
        // 是否包含子串:
        "Hello".contains("ll"); // true
        "Hello".indexOf("l"); // 2
        "Hello".lastIndexOf("l"); // 3
        "Hello".startsWith("He"); // true
        "Hello".endsWith("lo"); // true

        // 提取子串
        "Hello".substring(2); // "llo"
        "Hello".substring(2, 4);  //"ll"

        // 移除字符串首尾空白字符
        "  \tHello\r\n ".trim(); // "Hello"
        "\u3000Hello\u3000".strip(); // "Hello"
        " Hello ".stripLeading(); // "Hello "
        " Hello ".stripTrailing(); // " Hello"

        // 判断字符串是否为空和空白字符串
        "".isEmpty(); // true，因为字符串长度为0
        "  ".isEmpty(); // false，因为字符串长度不为0
        "  \n".isBlank(); // true，因为只包含空白字符
        " Hello ".isBlank(); // false，因为包含非空白字符

        // 根据字符或字符串替换
        String s = "hello";
        s.replace('l', 'w'); // "hewwo"，所有字符'l'被替换为'w'
        s.replace("ll", "~~"); // "he~~o"，所有子串"ll"被替换为"~~"
        // 通过正则表达式替换
        String s2 = "A,,B;C ,D";
        s.replaceAll("[\\,\\;\\s]+", ","); // "A,B,C,D"

        // 分割字符串
        String s3 = "A,B,C,D";
        String[] ss = s.split("\\,"); // {"A", "B", "C", "D"}

        // 拼接字符串
        String[] arr = {"A", "B", "C"};
        String s4 = String.join("***", arr); // "A***B***C"

        // 格式化字符串
        String s5 = "Hi %s, your score is %d!";
        // System.out.println(s5.formatted("Alice", 80));
        System.out.println(String.format("Hi %s, your score is %.2f!", "Bob", 59.5));

        // 把任意基本类型或引用类型转换为字符串
        String.valueOf(123); // "123"
        String.valueOf(45.67); // "45.67"
        String.valueOf(true); // "true"
        String.valueOf(new Object()); // 类似java.lang.Object@636be97c

        // 把字符串转换为int类型
        int n1 = Integer.parseInt("123"); // 123
        int n2 = Integer.parseInt("ff", 16); // 按十六进制转换，255
        // 符串转换为boolean
        boolean b1 = Boolean.parseBoolean("true"); // true
        boolean b2 = Boolean.parseBoolean("FALSE"); // false
        // 该字符串对应的系统变量转换为Integer
        Integer.getInteger("java.version"); // 版本号，11

        // String和char[]类型可以互相转换
        char[] cs = "Hello".toCharArray(); // String -> char[]
        String s6 = new String(cs); // char[] -> String
    }
}