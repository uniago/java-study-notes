package $04_reflection.$01_class.demo01;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        // 方法一：直接通过一个class的静态变量class获取
        Class cls1 = String.class;
        // 方法二：如果我们有一个实例变量，可以通过该实例变量提供的getClass()方法获取：
        String s = "Hello";
        Class cls2 = s.getClass();
        // 方法三：如果知道一个class的完整类名，可以通过静态方法Class.forName()获取：
        Class cls3 = Class.forName("java.lang.String");
        boolean sameClass = cls1 == cls2; // true


        Integer n = new Integer(123);
        boolean b1 = n instanceof Integer; // true，因为n是Integer类型
        boolean b2 = n instanceof Number; // true，因为n是Number类型的子类
        boolean b3 = n.getClass() == Integer.class; // true，因为n.getClass()返回Integer.class
        // boolean b4 = n.getClass() == Number.class; // false，因为Integer.class!=Number.class
    }
}
