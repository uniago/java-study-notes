package $09_datetime.$02_date_calendar.demo03;

import java.text.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // 获取当前时间:
        Date date = new Date();
        // var sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        var sdf = new SimpleDateFormat("E MMM dd, yyyy");
        System.out.println(sdf.format(date));
    }
}