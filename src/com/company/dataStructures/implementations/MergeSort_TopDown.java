package com.company.dataStructures.implementations;

import java.util.Arrays;

public class MergeSort_TopDown {
    public static void main(String[] args) {
        int[] input = new int[]{2,53,64,234,42};
        int[] result = merge_sort(input);

        for(int i : result){
            System.out.println(i);
        }

    }

    public static int[] merge_sort(int [] input){
        if (input.length <=1 ){
            return input;
        }
        int pivot = input.length/2;
        int[] left_list = merge_sort(java.util.Arrays.copyOfRange(input, 0, pivot));
        int[] right_list = merge_sort(Arrays.copyOfRange(input, pivot, input.length));
        return merge(left_list, right_list);

    }

    public static int[] merge(int[] left_list, int[] right_list){
        int [] merged_list = new int[left_list.length + right_list.length];
        int left = 0;
        int right = 0;
        int count = 0;

        while (left<left_list.length && right < right_list.length){
            if (left_list[left] <= right_list[right]){
                merged_list[count] = left_list[left];
                ++left;
                ++count;
            } else if (left_list[left] > right_list[right]){
                merged_list[count] = right_list[right];
                ++right;
                ++count;
            }
        }
        while(left<left_list.length){
            merged_list[count] = left_list[left];
            ++left;
            ++count;
        }
        while (right< right_list.length){
            merged_list[count] = right_list[right];
            ++right;
            ++count;
        }
        return merged_list;
    }
}
