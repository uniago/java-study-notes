package $07_collection.$13_stack.demo01;// 转十六进制

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String hex = toHex(12500);
        if (hex.equalsIgnoreCase("30D4")) {
            System.out.println("测试通过");
        } else {
            System.out.println("测试失败");
        }
    }

    static String toHex(int n) {
        List<String> hexList = Arrays.asList("0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F");
        Deque<String> stack = new LinkedList<>();
        while(n!=0){
            stack.push(hexList.get(n%16));
            n = n/16;
        }
        StringBuilder sb = new StringBuilder();
        while(stack.peek()!=null){
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}