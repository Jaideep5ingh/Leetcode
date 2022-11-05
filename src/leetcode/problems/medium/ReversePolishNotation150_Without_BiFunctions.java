package leetcode.problems.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

public class ReversePolishNotation150_Without_BiFunctions {
    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
//        int result=0;
        Stack<Integer> stack = new Stack<>();

        for(String s : tokens){
            if (!"+-*/".contains(s)){
                stack.push(Integer.valueOf(s));
                continue;
            }
            int operand_1 = stack.pop();
            int operand_2 = stack.pop();
            stack.push(evaluate(operand_2, operand_1, s));
        }
        System.out.println(stack.pop());
    }

    public static int evaluate(int operand_1, int operand_2, String operator){
        int ans=0;
        switch (operator){
            case "+":
                ans = operand_1 + operand_2;
                break;
            case "-":
                ans = operand_1 - operand_2;
                break;
            case "*":
                ans = operand_1 * operand_2;
                break;
            case "/":
                ans = operand_1 / operand_2;
                break;
        }
        return ans;
    }
}
