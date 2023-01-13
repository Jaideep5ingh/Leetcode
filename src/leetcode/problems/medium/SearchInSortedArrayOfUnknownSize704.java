package leetcode.problems.medium;

public class SearchInSortedArrayOfUnknownSize704 {

    //TODO : THE FIRST 2 FUNCTIONS (findRightBound_v1, search_v1) ARE PART OF V1 OF MY SOLUTIONS
    public static int findRightBound_v1(){
        int left = 0;
        int right = (int)(Math.pow(10, 4));
//        int right = 10;
        int max = (int)(Math.pow(2, 31) - 1);
        while(left < right ){
            int mid = (left + right) >> 1;
            int midValue = sendNumber(mid);

            if(midValue!=max && sendNumber(mid+1) == max) return mid;

            if(midValue == max) right = mid;
            else left = mid+1;
        }
        return -1;
    }

    public static int search_v1(int target) {
        int left = 0, right = findRightBound_v1();
        while(left<=right){
            int mid = (left + right) >> 1;
            int midVal = sendNumber(mid);

            if(midVal == target) return mid;

            if(midVal < target) left = mid+1;
            else right = mid - 1;
        }
        return -1;
    }

    public static int search_v2(int target) {
        int left = 0, right = (int)(Math.pow(10, 4));
        int max = (int)(Math.pow(2, 31) - 1);

        while(left<=right){
            int mid = (left + right) >> 1;
            int midVal = sendNumber(mid);
            if(midVal == target) return mid;
            if(sendNumber(mid) == max || midVal > target) right = mid-1;
            else left = mid + 1;
        }
        return -1;
    }

    public static int search_leetcode(int target){
        if (sendNumber(0) == target) return 0;
        int left = 0, right =1;
        while(sendNumber(right) < target){
            left = right;
            right = right << 1;
        }
        while(left <= right){
            int mid = (left + right) >> 1;
            int midVal = sendNumber(mid);
            if(midVal == target) return mid;
            if(midVal < target) left = mid + 1;
            else right = mid-1;
        }
        return -1;
    }

    public static int sendNumber(int i){
        int[] nums = {-1,0,3,5,9,12};
        if(i >= nums.length) return (int)(Math.pow(2, 31) - 1);
        else return nums[i];
    }

    public static void main(String[] args) {
        System.out.println(search_leetcode(9));
        System.out.println(search_v1(9));
        System.out.println(search_v2(9));
    }
}
