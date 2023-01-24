package leetcode.problems.easy;

import java.util.*;

public class MinimumIndexSumOfTwoLists599 {
    public static String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>(20);
        List<String> result = new ArrayList<>();
        int min_sum = Integer.MAX_VALUE, sum;

        for (int i = 0; i < list1.length; i++) map.put(list1[i],i);

        for (int i = 0; i < list2.length; i++) {
            String s = list2[i];
            if(map.containsKey(s)) {
                sum = i + map.get(s);
                if(sum < min_sum){
                    result.clear();
                    result.add(list2[i]);
                    min_sum = sum;
                }else if (sum == min_sum)
                    result.add(list2[i]);
            }
        }
        return result.toArray(new String[result.size()]);
    }


    public static void main(String[] args) {
        String[] list1 = {"Shogun","Tapioca Express","Burger King","KFC"},
                list2 = {"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};
        System.out.println(Arrays.toString(findRestaurant(list1, list2)));

    }
}
