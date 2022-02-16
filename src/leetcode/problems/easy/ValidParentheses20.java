package leetcode.problems.easy;

import java.util.Stack;

public class ValidParentheses20 {
    public static void main(String[] args) {
        String s = "[";
        if(s.isEmpty()) System.exit(0);

        Stack<Character> stack = new Stack<>();
        char[] c = s.toCharArray();
        stack.push(c[0]);
        boolean result=false;
        char stackTop=' ';

        for (int i=1; i<c.length;i++){
            if (!stack.isEmpty()) stackTop = stack.peek();

            if (   !stack.isEmpty() &&
                    ((c[i] == '}' && stackTop!='{')
                            || (c[i] == ')' && stackTop!='(')
                            || (c[i] == ']' && stackTop!='['))){
                break;
            }else if(   !stack.isEmpty() &&
                    ((c[i] == '}' && stackTop=='{')
                            || (c[i] == ')' && stackTop=='(')
                            || (c[i] == ']' && stackTop=='['))){
                stack.pop();
            }else{
                stack.push(c[i]);
            }
        }
        System.out.println("Valid Parenthesis ? Ans : " + result );
    }
}
