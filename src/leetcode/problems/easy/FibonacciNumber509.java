package leetcode.problems.easy;

import com.company.dataStructures.implementations.TreeNode;

import java.util.HashMap;

public class FibonacciNumber509 {
    static HashMap<Integer, Integer> map;

    public static int fib(int n) {
        if(map.containsKey(n)) return map.get(n);
        int result;
        if(n<2) result = n;
        else {
            result = fib(n-1) + fib(n-2);
        }
        map.put(n, result);
        return result;
    }

    public static void main(String[] args) {
        map = new HashMap<>();
        System.out.println(fib(7));

    }
}
