package $04_reflection.$05_inherit.demo04;

public class Main {
    public static void main(String[] args) {
        Object n = Integer.valueOf(123);
        boolean isDouble = n instanceof Double; // false
        boolean isInteger = n instanceof Integer; // true
        boolean isNumber = n instanceof Number; // true
        boolean isSerializable = n instanceof java.io.Serializable; // true

        // Integer i = ?
        Integer.class.isAssignableFrom(Integer.class); // true，因为Integer可以赋值给Integer
        // Number n = ?
        Number.class.isAssignableFrom(Integer.class); // true，因为Integer可以赋值给Number
        // Object o = ?
        Object.class.isAssignableFrom(Integer.class); // true，因为Integer可以赋值给Object
        // Integer i = ?
        Integer.class.isAssignableFrom(Number.class); // false，因为Number不能赋值给Integer
    }
}
