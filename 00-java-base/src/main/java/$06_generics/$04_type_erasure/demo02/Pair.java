package $06_generics.$04_type_erasure.demo02;

public class Pair<T> {
    // public boolean equals(T t) {
    //     return this == t;
    // }
    public boolean same(T t) {
        return this == t;
    }
}