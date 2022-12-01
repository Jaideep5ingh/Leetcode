package leetcode.problems.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence128 {
    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        Set<Integer> set = new HashSet<>();
        for (int i : nums) set.add(i);

        int streak = 0;
        for(int num : set){
            if(!set.contains(num-1)){
                int currNum = num;
                int currStreak = 1;
                while(set.contains(currNum+1)){
                    currNum++;
                    currStreak++;
                }
                streak = Math.max(streak, currStreak);
            }
        }
        System.out.println(streak);
    }
}
