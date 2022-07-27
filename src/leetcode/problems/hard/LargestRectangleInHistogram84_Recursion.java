package leetcode.problems.hard;

public class LargestRectangleInHistogram84_Recursion {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};

        System.out.println(largestRectangleArea(heights, 0));
    }

    public static int largestRectangleArea(int[] heights, int curr) {
        return calculateArea(heights, 0, heights.length - 1);
    }

    public static int calculateArea(int[] heights, int start, int end) {
        if(start > end){
            return 0;
        }

        int minIndex = start;
        for(int i = start; i<= end; ++i){
            if(heights[minIndex] > heights[i])
                minIndex = i;
        }
        int heightMinIndex = heights[minIndex] * (end - start + 1);
        int leftMax = calculateArea(heights, start, minIndex -1);
        int rightMax = calculateArea(heights, minIndex + 1, end);
        int max = Math.max(heightMinIndex, Math.max(leftMax, rightMax));

        return max;
    }
}
