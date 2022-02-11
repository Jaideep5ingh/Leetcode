package leetcode.problems.medium;

import java.util.HashMap;

public class DotProductOfTwoSparseVectors1570 {
    HashMap<Integer,Integer> sparseVector = new HashMap();

    DotProductOfTwoSparseVectors1570(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] !=0 ) {
                this.sparseVector.put(i,nums[i]);
            }
        }
    }

    public int dotProduct(DotProductOfTwoSparseVectors1570 vec) {
        int ans = 0;
        for (Integer c : this.sparseVector.keySet()){
            if(vec.sparseVector.get(c) != null){
                ans+=vec.sparseVector.get(c) * this.sparseVector.get(c);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,0,0,2,3};
        int[] nums2 = {0,3,0,4,0};
        DotProductOfTwoSparseVectors1570 v1 = new DotProductOfTwoSparseVectors1570(nums1);
        DotProductOfTwoSparseVectors1570 v2 = new DotProductOfTwoSparseVectors1570(nums2);
        int ans = v1.dotProduct(v2);
        System.out.println(ans);
    }
}
