package leetcode.problems.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class BaseballGame682 {
    public static void main(String[] args) {
//        int[] nums = {73,74,75,71,69,72,76,73};
//        int[] heights = {1,8,6,2,5,4,8,3,7};
        String[] tokens = {"5","2","C","D","+"};
        int sum =0;
        Map<String, BiFunction<Integer, Integer, Integer>> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        map.put("+", (a,b) -> a+b);
        map.put("D", (a,b) -> 2*a);
        //add extra else for "C"

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if(!map.containsKey(token) && !token.equals("C")){
                stack.push(Integer.valueOf(token));
                continue;
            }
            if (map.containsKey(token)){
                int result = 0;
                int operand_1 = stack.peek();
                BiFunction<Integer, Integer, Integer> operation= map.get(token);
                switch (token){
                    case "D":
                        result = operation.apply(operand_1, 0);
                        break;
                    case "+":
                        int re_insert = stack.pop();
                        int operand_2 = stack.peek();
                        result = operation.apply(operand_1, operand_2);
                        stack.push(re_insert);
                        break;
                }
                stack.push(result);
            }
            else stack.pop();
        }

        for(int i : stack){
            sum += i;
        }

        System.out.println(sum);
    }
}
