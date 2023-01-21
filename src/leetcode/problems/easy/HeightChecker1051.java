package leetcode.problems.easy;

import java.util.Arrays;

public class HeightChecker1051 {
    public static int heightChecker_solution1_sorting(int[] heights) {
        int ans = 0;
        int[] temp = Arrays.copyOf(heights, heights.length);
        Arrays.sort(temp);
        for (int i = 0; i < heights.length; i++) {
            if(heights[i] != temp[i]) ans++;
        }
        return ans;
    }

    public static int heightChecker_solution2_countingSort(int[] heights) {
        int ans = 0;
        int[] counts = new int[101]; // given there can be at max 100 elements in the array
        for (int i = 0; i < heights.length; i++) {
            counts[heights[i]]++;
        }
        int currHeight=0;
        for(int height : heights){
            while(counts[currHeight] == 0)
                currHeight++;
            if(currHeight != height)
                ++ans;
            --counts[currHeight];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] heights = {1,1,4,2,1,3};
        System.out.println(heightChecker_solution2_countingSort(heights));
    }

}
