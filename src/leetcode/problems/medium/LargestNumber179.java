package leetcode.problems.medium;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber179 {
    public static String largestNumber(int[] nums) {
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String order1 = o1+o2;
                String order2 = o2+o1;
                return order2.compareTo(order1);
            }
        };
        String[] strArray = new String[nums.length];
        for (int i = 0; i < nums.length; i++) strArray[i] = String.valueOf(nums[i]);

        Arrays.sort(strArray, comparator);

        if (strArray[0].equals("0")) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        for (String s : strArray) result.append(s);

        return result.toString();
    }


    public static void main(String[] args) {
        int[] nums = {3,30,34,5,9};
        System.out.println(largestNumber(nums));
        String o1 = "30";
        String o2 = "34";
        String order1 = o1+o2;
        String order2 = o2+o1;
        System.out.println(order2.compareTo(order1));
    }
}
