package leetcode.problems.medium;

import java.util.Stack;

public class DecodeString394_Single_Stack {
    public static void main(String[] args) {
        String s = "10[a4[c]]";
        StringBuilder temp = new StringBuilder("");
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()){
            if(c == ']'){
                while(!Character.isDigit(stack.peek())) {
                    char top = stack.pop();
                    if(top != '[') temp.append(top);
                }
                int base = 1;
                int k = 0;
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    k += (stack.pop() - '0') * base;
                    System.out.println(k);
                    base*=10;
                }

                String topString = temp.toString().repeat(k);
                for (int i = topString.length() - 1; i >=0 ; i--) {
                    stack.push(topString.charAt(i));
                }
                temp = new StringBuilder("");
            }else stack.push(c);
        }
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        System.out.println(result.reverse());
    }
}
