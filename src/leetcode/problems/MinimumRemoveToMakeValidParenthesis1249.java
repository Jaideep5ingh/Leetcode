package leetcode.problems;

import java.util.Stack;

public class MinimumRemoveToMakeValidParenthesis1249 {
    public static void main(String[] args) {
        StringBuilder s2 = new StringBuilder();

        s2.append("L(e)))et((co)d(e");
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) == '(' ){
                stack.push(i);
            }else if(stack.isEmpty() && s2.charAt(i) == ')'){
                s2.deleteCharAt(i);
                i--;
            }
            else if(!stack.isEmpty() && s2.charAt(i) == ')' && s2.charAt(stack.peek()) == '(') {
                stack.pop();
            }
        }

        while(!stack.isEmpty()){
            s2.deleteCharAt(stack.pop());
        }

        System.out.println(s2);
    }
}
