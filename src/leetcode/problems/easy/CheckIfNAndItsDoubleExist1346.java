package leetcode.problems.easy;

import java.util.HashMap;
import java.util.HashSet;

public class CheckIfNAndItsDoubleExist1346 {
//    public static boolean checkIfExist(int[] arr) {
//        HashMap<Integer, Integer> map = new HashMap<>(20);
//        for (int i = 0; i < arr.length; i++) {
//            map.put(arr[i], i);
//            boolean isEven = arr[i] % 2 == 0;
//            if( (map.containsKey(arr[i]) && map.containsKey(arr[i]*2)) ||
//                    (map.containsKey(arr[i]) && map.containsKey(arr[i]/2) && isEven)){
//                if(map.get(arr[i]) != map.get(arr[i]*2)) return true;
//                else if ((arr[i] == 0 && map.containsKey(0))){
//                    return i!=map.get(0);
//                }
//            }
//        }
//        return false;
//    }

    public static boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr){
            if(set.contains(num*2) || (num %2 == 0) &&  set.contains(num/2)){
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {0,0}; //mid = 7, target = 1
        System.out.println(checkIfExist(nums));

    }
}
