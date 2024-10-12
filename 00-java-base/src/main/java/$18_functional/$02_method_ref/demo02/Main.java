package $18_functional.$02_method_ref.demo02;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] array = new String[] { "Apple", "Orange", "banana", "Lemon" };
        // Arrays.sort(array, String::compareTo);
        Arrays.sort(array, String::compareToIgnoreCase);
        System.out.println(String.join(", ", array));
    }
}