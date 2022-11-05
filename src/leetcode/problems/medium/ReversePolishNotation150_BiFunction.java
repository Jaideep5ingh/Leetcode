package leetcode.problems.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class ReversePolishNotation150_BiFunction {
    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int result=0;
        Stack<Integer> stack = new Stack<>();
        Map<String, BiFunction<Integer, Integer, Integer>> operations = new HashMap<>();
        operations.put("+", (a, b) -> a+b);
        operations.put("*", (a, b) -> a*b);
        operations.put("-", (a, b) -> a-b);
        operations.put("/", (a, b) -> a/b);

        for(String s : tokens){
            if (!operations.containsKey(s)){
                stack.push(Integer.valueOf(s));
                continue;
            }
            int operand_1 = stack.pop();
            int operand_2 = stack.pop();

            BiFunction<Integer, Integer, Integer> operation = operations.get(s);
            result = operation.apply(operand_2, operand_1); //pay special attention to order here.
            stack.push(result);
        }
        System.out.println(result);
    }
}
