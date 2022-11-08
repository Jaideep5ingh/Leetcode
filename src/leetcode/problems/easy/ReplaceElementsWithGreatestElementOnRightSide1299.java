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
}
