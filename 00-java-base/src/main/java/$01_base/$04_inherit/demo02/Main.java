package $01_base.$04_inherit.demo02;

public class Main {
    public static void main(String[] args) {
        // Student s = new Student();
        // Person p = s; // upcasting, ok
        // Object o1 = p; // upcasting, ok
        // Object o2 = s; // upcasting, ok


        // Person p = new Person();
        // System.out.println(p instanceof Person); // true
        // System.out.println(p instanceof Student); // false
        //
        // Student s = new Student();
        // System.out.println(s instanceof Person); // true
        // System.out.println(s instanceof Student); // true
        //
        // Student n = null;
        // System.out.println(n instanceof Student); // false

        // Person p = new Student();
        // if (p instanceof Student) {
        //     // 只有判断成功才会向下转型:
        //     Student s = (Student) p; // 一定会成功
        // }

        Object obj = "hello";
        if (obj instanceof String) {
            String s = (String) obj;
            System.out.println(s.toUpperCase());
        }

        // // instanceof variable:
        // Object obj = "hello";
        // if (obj instanceof String s) {
        //     // 可以直接使用变量s:
        //     System.out.println(s.toUpperCase());
        // }
    }
}
