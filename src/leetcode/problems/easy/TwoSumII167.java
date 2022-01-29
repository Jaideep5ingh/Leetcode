package leetcode.problems.easy;

public class TwoSumII167 {
    public static void main(String args[]) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        int i = 0, j= numbers.length-1;
        while (i<=j){
            if(numbers[i] + numbers[j] == target){
                System.out.println("Requireed indices are - " + i + " and " + j);
                break;
            }else if(numbers[i] + numbers[j] > target){
                j--;
            }else if(numbers[i] + numbers[j] < target){
                i++;
            }
        }
    }
}
