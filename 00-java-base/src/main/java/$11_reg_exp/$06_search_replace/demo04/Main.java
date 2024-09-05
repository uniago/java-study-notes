package $11_reg_exp.$06_search_replace.demo04;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // 定义一个字符串模板
        String str = "Hello, ${name}! You are learning ${lang}!";
        // 定义一个Map，存储模板中的变量和对应的值
        Map<String, String> map = Map.of("name", "Bob", "lang", "Java");
        // 调用render方法，将模板中的变量替换为对应的值
        String render = render(str, map);
        // 输出替换后的字符串
        System.out.println(render);
    }

    /**
     * 根据模板和数据，将模板中的变量替换为对应的值
     * @param template 模板字符串
     * @param data 数据，存储模板中的变量和对应的值
     * @return 替换后的字符串
     */
    public static String render(String template, Map<String, String> data) {
        // 定义一个正则表达式，用于匹配模板中的变量
        Pattern compile = Pattern.compile("\\$\\{([a-z]+)}");
        // 创建一个Matcher对象，用于匹配模板中的变量
        Matcher matcher = compile.matcher(template);
        // 创建一个StringBuilder对象，用于存储替换后的字符串
        StringBuilder sb = new StringBuilder();
        // 遍历模板中的变量
        while(matcher.find()) {
            // 获取变量的名称
            String key = matcher.group(1);
            // 获取变量的值
            String value = data.get(key);
            // 如果变量存在，则将变量替换为对应的值
            if (value != null) {
                // 将匹配到的字符串替换为指定的字符串，并将结果添加到StringBuilder对象中
                matcher.appendReplacement(sb, value);
            }
        }
        // 将剩余的字符串添加到StringBuffer对象中
        matcher.appendTail(sb);
        // 返回替换后的字符串
        return sb.toString();
    }}
