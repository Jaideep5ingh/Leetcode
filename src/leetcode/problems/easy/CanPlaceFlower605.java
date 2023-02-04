package leetcode.problems.easy;

public class CanPlaceFlower605 {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length==1 ) return flowerbed[0]==1 ? false : true;
        if(n==0 ) return true;

        int left = 0;
        while(left < flowerbed.length){
            if(flowerbed[left]==0){
                boolean leftPlot = false;
                boolean rightPlot = false;
                if(left>0 && flowerbed[left-1]==0 || left ==0) leftPlot = true;
                if(left == flowerbed.length-1 || flowerbed[left+1] == 0 ) rightPlot = true;
                if(leftPlot && rightPlot){
                    flowerbed[left] = 1;
                    --n;
                }
            }
            ++left;
            if(n==0) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {1,0,0,0,1,0,0};
        System.out.println(canPlaceFlowers(nums, 2));
    }
}
