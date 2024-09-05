package $11_reg_exp.$06_search_replace.demo04;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String str = "Hello, ${name}! You are learning ${lang}!";
        Map<String, String> map = Map.of("name", "Bob", "lang", "Java");
        String reg = "\\$\\{([a-z]+)}";
        Pattern compile = Pattern.compile(reg);
        Matcher matcher = compile.matcher(str);
        while(matcher.find()) {
            String variable = matcher.group(1);
            String value = map.get(variable);
            String s = str.replaceAll(reg, value);
            System.out.println(s);
        }
    }
}
