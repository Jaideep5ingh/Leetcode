package leetcode.problems.medium;

import java.util.Stack;

public class ValidParenthesis20 {
    public static void main(String[] arg){
        System.out.println(isValid("(((((((()"));
    }

    public static boolean isValid(String s) {
        Stack<Character> previous = new Stack<>();

        if(s.charAt(0) == ')' || s.charAt(0) == '}' || s.charAt(0) == ']'){
            return false;
        }

        Character current = s.charAt(0);
        previous.push(s.charAt(0));
        Character other = current == '('?')' :
                current == '{'? '}':']';

        for (int i = 1; i < s.length(); i++) {
            if((s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']')
                    && s.charAt(i) == other ){
                previous.pop();
                current=previous.isEmpty()?null:previous.peek();
            }else{
                previous.push(s.charAt(i));
                current=s.charAt(i);
            }
            if (!previous.isEmpty())
                other = current == ')'?')' :
                    current == '{'? '}':']';
        }
        return previous.isEmpty();
    }


}
