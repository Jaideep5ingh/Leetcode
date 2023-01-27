package leetcode.problems.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements347 {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((n1, n2) -> map.get(n1) - map.get(n2));
        int[] result = new int[k];

        for (int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            priorityQueue.add(entry.getKey());
            if(priorityQueue.size() > k) priorityQueue.poll();
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = priorityQueue.poll();
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums1, k)));
    }
}
