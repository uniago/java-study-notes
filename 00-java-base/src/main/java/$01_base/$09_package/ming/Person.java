// Person.java
package $01_base.$09_package.ming;

// 2.导入完整类名:
// import $01_base.$09_package.mr.jun.Arrays;
// 3.导入mr.jun包的所有class:
import $01_base.$09_package.mr.jun.*;
// 4.导入System类的所有静态字段和静态方法:
import static java.lang.System.*;

public class Person {
    public void run() {
        // 1.写完整类名: mr.jun.Arrays
        // $01_base.$09_package.mr.jun.Arrays arrays = new $01_base.$09_package.mr.jun.Arrays();
        Arrays arrays = new Arrays();
    }

    public static void main(String[] args) {
        // 相当于调用System.out.println(…)
        out.println("Hello World!");
    }
}