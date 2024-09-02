package $02_core.$04_wrapper.demo02;

// NullPointerException
public class Main {
    public static void main(String[] args) {
        Integer n = null;   // 编译器自动使用Integer.valueOf(int)
        int i = n;  // 编译器自动使用Integer.intValue()
    }
}