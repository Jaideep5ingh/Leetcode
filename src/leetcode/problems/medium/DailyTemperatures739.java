package leetcode.problems.medium;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures739 {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int n = temperatures.length;
        int[] answer = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int currDay = 0; currDay < n; currDay++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[currDay]){
                int prevDay = stack.pop();
                answer[prevDay]= currDay - prevDay;
            }
            stack.push(currDay);
        }
        System.out.println(Arrays.toString(answer));
    }
}
