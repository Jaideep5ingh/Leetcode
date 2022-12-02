package leetcode.problems.easy;

public class ReplaceElementsWithGreatestElementOnRightSide1299 {
    public static void main(String[] args) {
        int[] arr = {23,5546,457,3,344346,563,400};
        int n = arr.length;

        int max = arr[arr.length-1];
        for (int i = n-2; i >= 0 ; i--) {
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(max, temp);
        }
        arr[n-1] = -1;
        for(int i : arr) System.out.print(i + " ");
    }

    public int[] greatestOnRight_startingFromRight(int[] arr){
        int n = arr.length;
        if (n==1) return new int[]{-1}; //replace with return statement

        int max = Integer.MIN_VALUE;
        int[] res = new int[n];
        res[n-1] = -1;

        for (int i = n-2; i >=0 ; i--) {
            max = Math.max(max, arr[i+1]);
            res[i] = max;
        }
        return res;
    }
}
