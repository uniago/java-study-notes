package $11_reg_exp.$05_non_greedy.demo01;

import java.util.regex.*;

public class Main {
    public static void main(String[] args) {
        // Pattern pattern = Pattern.compile("(\\d+)(0*)");
        Pattern pattern = Pattern.compile("(\\d+?)(0*)");
        Matcher matcher = pattern.matcher("1230000");
        if (matcher.matches()) {
            System.out.println("group1=" + matcher.group(1)); // "1230000"
            System.out.println("group2=" + matcher.group(2)); // ""
        }
    }
}