package $06_generics.$03_write_generics.demo02;

public class Pair<T> {
    private T first;
    private T last;
    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }
    public T getFirst() { return first; }
    public T getLast() { return last; }

    // 对静态方法使用<T>:
    // public static Pair<T> create(T first, T last) {
    //     return new Pair<T>(first, last);
    // }

    // 可以编译通过, 但这个<T>和Pair<T>类型的<T>已经没有任何关系了:
    // public static <T> Pair<T> create(T first, T last) {
    //     return new Pair<T>(first, last);
    // }

    // 静态泛型方法应该使用其他类型区分:
    public static <K> Pair<K> create(K first, K last) {
        return new Pair<K>(first, last);
    }
}