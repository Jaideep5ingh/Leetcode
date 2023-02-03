package leetcode.problems.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle_II_119 {
    public static List<Integer> getRow_my(int rowIndex) {
        List<Integer> prevRow = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        prevRow.add(1);
        list.add(1);

        for (int i = 0; i < rowIndex; i++) {
            list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < prevRow.size(); j++) {
                list.add(prevRow.get(j-1) + prevRow.get(j));
            }
            list.add(1);
            prevRow = list;
        }
        return list;
    }

    public static List<Integer> getRow_leetcode(int rowIndex) {
        List<Integer> Row = new ArrayList<>(){{add(1);}};

        for (int i = 0; i < rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                Row.set(j, Row.get(j-1) + Row.get(j));
            }
            Row.add(1);
        }
        return Row;
    }

    public static void main(String[] args) {
//        char[] jewels = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
//        int[] nums = {0,0,1,1,1,2,2,3,3,4};
//        String[] strs = {"flower","flow","flight"};
//        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
//        char[] s = {'h','e','l','l','o'};
        int n = 7;
        System.out.println(getRow_my(n));
        System.out.println(getRow_leetcode(n));

    }
}
