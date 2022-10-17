package leetcode.problems.medium;

public class ContainerWithMostWater11 {
    public static void main(String[] args)  {
        int[] heights = {1,8,6,2,5,4,8,3,7};
        int result = 0;
        int left = 0,  right = heights.length-1;
        while(left < right){
            int leftHeight = heights[left];
            int rightHeights = heights[right];
            int width = Math.abs(right - left);
            result = Math.max(result, width * Math.min(leftHeight, rightHeights));
            if(leftHeight <= rightHeights) ++left;
            else --right;
        }
        System.out.println(result);
    }
}
