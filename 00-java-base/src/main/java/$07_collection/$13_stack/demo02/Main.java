package $07_collection.$13_stack.demo02;// 高难度练习，慎重选择！

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String exp = "x + 2 * (y - 5)";
        SuffixExpression se = compile(exp);
        Map<String, Integer> env = Map.of("x", 1, "y", 9);
        int result = se.execute(env);
        System.out.println(exp + " = " + result + " " + (result == 1 + 2 * (9 - 5) ? "✓" : "✗"));
    }
    public static boolean isOperator(String str){
        if(str!=null && "\\+-*/\\(\\)".indexOf(str)>0){
            return true;
        }else{
            return false;
        }
    }
    static SuffixExpression compile(String exp) {
        // TODO:
        Deque<String> stack = new LinkedList<>();
        char[] expCharArr = exp.toCharArray();
        String numStr = "0123456789";
        Map<String,Integer> operationMap = new HashMap(){{put("+",1);put("-",1);put("*",2);put("/",2);put("(",3);put(")",3);}};
        StringBuilder sb = new StringBuilder();
        for(char c : expCharArr){

            if(c==' '){
                continue;
            }
            if(!isOperator(String.valueOf(c))){
                //操作数直接返回
                sb.append(String.valueOf(c));
            }else{
                //操作符：
                if(stack.peek()==null ){
                    stack.push(String.valueOf(c));
                }else if(")".equals(String.valueOf(c))){
                    while(stack.peek()!=null && !"(".equals(stack.peek())){
                        sb.append(stack.pop());
                    }
                    if("(".equals(stack.peek())){
                        stack.pop();
                    }
                }else if(operationMap.get(String.valueOf(c))>operationMap.get(stack.peek())){
                    stack.push(String.valueOf(c));
                }else{
                    while(stack.peek()!=null && operationMap.get(String.valueOf(c))<=operationMap.get(stack.peek())){
                        if("(".equals(stack.peek())){
                            break;
                        }else{
                            sb.append(stack.pop());
                        }
                    }
                    if("(".equals(stack.peek())){
                        stack.pop();
                    }
                    stack.push(String.valueOf(c));
                }

            }
        }
        while(stack.peek()!=null){
            sb.append(stack.pop());
        }

        return new SuffixExpression(sb.toString());
    }
}

class SuffixExpression {
    private String executeExpression;
    public SuffixExpression(String executeExpression){
        this.executeExpression = executeExpression;
    }
    int execute(Map<String, Integer> env){
        Deque<String> stack = new LinkedList<>();
        char[] expCharArr = this.executeExpression.toCharArray();
        Integer result=0;
        Integer intA;
        Integer intB;
        String A;
        String B;
        for(char c : expCharArr){
            if(!Main.isOperator(String.valueOf(c))){
                stack.push(String.valueOf(c));
            }else{
                A = stack.pop();
                B = stack.pop();
                A = env.get(A)==null? A:env.get(A).toString();
                B = env.get(B)==null? B:env.get(B).toString();
                intA = Integer.valueOf(A);
                intB = Integer.valueOf(B);
                if('+'==c){
                    result = intB + intA;
                }else if('-'==c){
                    result = intB - intA;
                }else if('*'==c){
                    result = intB * intA;
                }else if('/'==c){
                    result = intB / intA;
                }
                stack.push(String.valueOf(result));
            }

        }
        return Integer.valueOf(stack.pop());
    }
}