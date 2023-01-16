package leetcode.problems.easy;

public class FindNumbersWithEvenNumberOfDigits1295 {
    public static int findNumbers(int[] nums) {
        int result = 0;
        for (int num : nums) result = digits(num) % 2 == 0 ? ++result : result;
        return result;
    }

    public static int digits(int num){
        int digits = 1;
        while(num >= 10){
            digits++;
            num /= 10;
        }
        return digits;
    }

    public static void main(String[] args) {
        int[] nums = {100000}; //mid = 7, target = 1
        System.out.println(findNumbers(nums));

    }
}
