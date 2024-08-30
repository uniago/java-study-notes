package $01_base.$07_interface.demo03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List list = new ArrayList(); // 用List接口引用具体子类的实例
        Collection coll = list; // 向上转型为Collection接口
        Iterable it = coll; // 向上转型为Iterable接口
    }
}
