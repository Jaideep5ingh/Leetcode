package Revision.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15_Revision {
    public static void main(String[] args) {
        int[] nums  = {-1,0,1,2,-1,-4};
        ArrayList<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for (int counter = 0; counter < nums.length && nums[counter]<0; counter++) {
            if (counter==0 || nums[counter-1]!=nums[counter]){
                continue;
            }
            int k=counter+1, j =nums.length-1;
            while(k<j){
                int sum = nums[counter] + nums[k] + nums[j];
                if (sum<0)
                k++;
                else if (sum>0) j--;
                else {
                    list.add(Arrays.asList(nums[counter] , nums[k++],nums[j--]));
                    while(k<j && nums[k-1]==nums[k]) ++k;
                }
            }
        }
        System.out.println(list.toString());
    }
}
