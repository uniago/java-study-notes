package $11_reg_exp.$04_group.demo01;

import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("(\\d{3,4})\\-(\\d{7,8})");
        Matcher m = p.matcher("010-12345678");
        if (m.matches()) {
            String g1 = m.group(1);
            String g2 = m.group(2);
            System.out.println(g1); // 010
            System.out.println(g2); // 12345678
        } else {
            System.out.println("匹配失败!");
        }
    }
}