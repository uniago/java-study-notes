package $11_reg_exp.$05_non_greedy.demo02;

import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(\\d??)(9*)");
        Matcher matcher = pattern.matcher("9999");
        if (matcher.matches()) {
            System.out.println("group1=" + matcher.group(1)); // ""
            System.out.println("group2=" + matcher.group(2)); // "9999"
        }
    }
}