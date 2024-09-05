package $09_datetime.$02_date_calendar.demo01;

import java.text.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int n = 123400;
        // 123400
        System.out.println(n);
        // 1e208
        System.out.println(Integer.toHexString(n));
        // $123,400.00
        System.out.println(NumberFormat.getCurrencyInstance(Locale.US).format(n));

        System.out.println(System.currentTimeMillis());
    }
}