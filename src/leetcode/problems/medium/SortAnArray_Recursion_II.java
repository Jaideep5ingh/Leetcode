package leetcode.problems.medium;

import java.util.Arrays;

public class SortAnArray_Recursion_II {
    public static void main(String[] args) {
        int[] arr = {5,2,3,1};

        int[] result = merge_sort(arr);

        for (int i: result){
            System.out.print(i);
            System.out.print(" ");
        }
    }

    public static int[] merge_sort(int[] arr){
        if(arr.length <= 1){
            return arr;
        }

        int pivot = arr.length/2;

        int[] left_list = merge_sort(Arrays.copyOfRange(arr, 0, pivot));
        int[] right_list = merge_sort(Arrays.copyOfRange(arr, pivot, arr.length));

        return merge(left_list, right_list);
    }

    public static int[] merge(int[] left_list, int[] right_list){
        int[] result = new int[left_list.length + right_list.length];
        int left=0, count=0, right=0;

        while(left<left_list.length && right < right_list.length){
            if(left_list[left] < right_list[right]){
                result[count++] = left_list[left++];
            }else{
                result[count++] = right_list[right++];
            }
        }

        while(left<left_list.length){
            result[count++] = left_list[left++];
        }

        while(right < right_list.length){
            result[count++] = right_list[right++];
        }

        return result;
    }
}
