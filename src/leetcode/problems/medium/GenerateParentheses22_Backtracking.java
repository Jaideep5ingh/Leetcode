package leetcode.problems.medium;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses22_Backtracking {
    public static List<String> result = new LinkedList<>();

    public static void main(String[] args) {
        int n = 1;
        generateParenthesis(new StringBuilder(), 0, 0 , n);

        System.out.println(result);
    }

    public static void generateParenthesis(StringBuilder curr, int open, int close, int max){
        if(curr.length() == max*2 ){
            result.add(curr.toString());
            return;
        }
        if(open < max){
            curr.append("(");
            generateParenthesis(curr, open+1, close, max);
            curr.deleteCharAt(curr.length() -1 );
        }
        if(close < open){
            curr.append(")");
            generateParenthesis(curr, open, close+1, max);
            curr.deleteCharAt(curr.length() -1);
        }
    }
}
