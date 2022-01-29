package leetcode.problems.easy;

import java.util.HashMap;

public class TwoSum1 {
    public static void main(String args[]) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < numbers.length-1; i++) {
            hashMap.put(numbers[i], i);
        }

        for (int i = 0; i < numbers.length-1; i++) {
            int compliment = target - numbers[i];

            if (hashMap.containsKey(compliment) &&  hashMap.get(compliment) != i){
                System.out.println(hashMap.get(compliment) + " " + i);
                break;
            }
        }
//        System.out.println("Required indices are : " + i +  " and " );
    }
}
