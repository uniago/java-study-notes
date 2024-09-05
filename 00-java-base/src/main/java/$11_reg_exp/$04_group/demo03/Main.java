package $11_reg_exp.$04_group.demo03;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String time = "23:01:59";
        Pattern pattern = Pattern.compile("(\\d{2}):(\\d{2}):(\\d{2})");
        Matcher matcher = pattern.matcher(time);
        if (matcher.matches()) {
            System.out.println(matcher.group(0));
            System.out.println(matcher.group(1));
            System.out.println(matcher.group(2));
            System.out.println(matcher.group(3));
        } else {
            System.err.println("匹配失败!");
        }
    }
}
