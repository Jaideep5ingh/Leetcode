package leetcode.problems.hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum239 {
    static Deque<Integer> deque = new ArrayDeque<>();
    static int[] nums;
    public static void cleanDeque(int i, int k){
        //removing the first element of the sliding window to add the latest element
        if (!deque.isEmpty() && deque.getFirst() == i-k) deque.removeFirst();

        //for retaining the max of the the current window
        while(!deque.isEmpty() && nums[i] > nums[deque.getLast()]) deque.removeLast();
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        this.nums =  nums;
        int max_idx = 0;
        for (int i = 0; i < k; i++) {
            cleanDeque(i, k);
            deque.addLast(i);
            if(nums[i] > nums[max_idx]) max_idx = i;
        }
        int[] output = new int[n - k + 1];
        output[0] = nums[max_idx];

        for (int i = k; i < n; i++) {
            cleanDeque(i, k);
            deque.addLast(i);
            output[i - k + 1] = nums[deque.getFirst()];
        }
        return output;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum239 o = new SlidingWindowMaximum239();
        int[] nums = {1,3,-1,-3,5,3,6,7}; //mid = 7, target = 1
        int k = 3, x=3;
        System.out.println(Arrays.toString(o.maxSlidingWindow(nums, k )));

    }
}
