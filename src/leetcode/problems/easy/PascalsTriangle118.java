package leetcode.problems.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle118 {
    public static List<List<Integer>> generate_leetcode(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            List<Integer> prevRow = result.get(i-1);

            list.add(1);
            for (int j = 1; j < prevRow.size(); j++) {
                list.add(prevRow.get(j-1) + prevRow.get(j));
            }
            list.add(1);
            result.add(list);
        }
        return result;
    }

    public static List<List<Integer>> generate_my(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(generateFirstTwoRows(1,1));
        if(numRows == 1) return result;
        result.add(generateFirstTwoRows(1,2));
        if(numRows == 2) return result;

        for (int i = 2; i < numRows ; i++) {
            List<Integer> prevRow = result.get(i-1);
            result.add(generateRows(prevRow));
        }
        return result;
    }

    public static List<Integer> generateFirstTwoRows(int start, int end){
        List<Integer> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            result.add(1);
        }
        return result;
    }

    public static List<Integer> generateRows(List<Integer> prevRow){
        List<Integer> result = new ArrayList<>();
        int left=0;
        result.add(1);
        for (int i = 1; i <= prevRow.size()-1; i++) {
            result.add(prevRow.get(left++) + prevRow.get(i));
        }
        result.add(1);
        return result;
    }

    public static void main(String[] args) {
        int n = 4;
        System.out.println(generate_my(n));
        System.out.println(generate_leetcode(n));
    }
}
