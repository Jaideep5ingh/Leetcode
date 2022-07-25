package leetcode.problems.medium;

import java.util.LinkedList;
import java.util.List;

public class Combinations77_Backtracking {

    public static List<List<Integer>> output = new LinkedList();
    public static int n=4, k=2;

    public static void main(String[] args) {
        backtrack(1, new LinkedList<>());
    }

    public static void backtrack(int first, LinkedList<Integer> curr) {
        // if the combination is done
        if (curr.size() == k)
            output.add(new LinkedList(curr));

        for (int i = first; i < n + 1; ++i) {
            curr.add(i);
            backtrack(i + 1, curr);
            curr.removeLast();
        }
    }
}
