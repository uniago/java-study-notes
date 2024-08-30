package $01_base.$11_inner_class.demo03;// Anonymous Class
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> map1 = new HashMap<>();
        HashMap<String, String> map2 = new HashMap<>() {}; // 匿名类!
        // 创建一个匿名内部类实例，并在构造代码块中初始化 HashMap
        // 原理: 构造代码块会在构造函数之前执行,相当于在构造函数中使用put方法添加键值对
        HashMap<String, String> map3 = new HashMap<>() {
            // 构造代码块
            {
                put("A", "1");
                put("B", "2");
            }
        };
        System.out.println(map3.get("A"));

        // 创建一个匿名内部类实例，并在构造代码块中初始化 ArrayList
        List<String> list = new ArrayList<>() {
            {
                add("one");
                add("two");
                add("three");
            }
        };

        // 打印 ArrayList 中的内容
        System.out.println(list); // 输出: [one, two, three]
    }
}