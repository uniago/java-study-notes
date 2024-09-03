package $06_generics.$06_super.demo02;

import java.util.List;

public class Collections {
    public static <T> void copy(List<? super T> dest, List<? extends T> src) {
        for (int i=0; i<src.size(); i++) {
            T t = src.get(i); // src是producer, read only
            dest.add(t); // dest是consumer, write only
        }
    }
}