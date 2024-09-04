package $04_reflection.$05_inherit.demo05;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个类，展开所有继承类，其中符号> 表示接口，序号是普通类继承的层数。
 */
public class ClassExtensionInfo{
    public static void main(String[] args) throws Throwable{
        expandClassNameList(StringBuffer.class);
    }
    // 类名越靠上说明继承层级越多
    public static void expandClassNameList(Class<?> cls) {
        List<Class<?>> list = new ArrayList<>();
        while (cls != null) {
            list.add(cls);
            cls = cls.getSuperclass();
        }
        // 序号是类继承的层数
        int length = list.size();
        for (int i = 0; i < length ; i++) {
            System.out.printf("%d. ", length - i);
            printClassName(list.get(i), 0);
        }
    }
    // 递归打印接口名称
    private static void printClassName(Class<?> cls, int rank) {
        System.out.println("\t> ".repeat(rank) + cls.getName());
        for (Class<?> superClass : cls.getInterfaces()) {
            printClassName(superClass, ++rank);
        }
    }
}