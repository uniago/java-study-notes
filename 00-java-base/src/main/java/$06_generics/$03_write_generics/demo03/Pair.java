package $06_generics.$03_write_generics.demo03;

public class Pair<T, K> {
    private T first;
    private K last;
    public Pair(T first, K last) {
        this.first = first;
        this.last = last;
    }
    public T getFirst() { return first; }
    public K getLast() { return last; }
}