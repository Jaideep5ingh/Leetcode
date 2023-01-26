package leetcode.problems.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_III_170 {
    Map<Integer, Integer> map;

    public TwoSum_III_170() {
        this.map = new HashMap<>();
    }

    public void add(int number) {
        map.put(number, map.getOrDefault(number,0)+1);
    }

    public boolean find(int value) {
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int num = entry.getKey();
            int compliment = value - num;
            if(compliment!=num){
                if(map.containsKey(compliment))
                    return true;
            }
            else{
                if(entry.getValue() > 1) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TwoSum_III_170 twoSum = new TwoSum_III_170();
        twoSum.add(3);   // [] --> [1]
        twoSum.add(2);   // [] --> [1]
        twoSum.add(1);   // [1] --> [1,3]
//        twoSum.add(5);   // [1,3] --> [1,3,5]
//        System.out.println(twoSum.find(2));  // 1 + 3 = 4, return true
//        System.out.println(twoSum.find(3));  // 1 + 3 = 4, return true
//        System.out.println(twoSum.find(4));  // 1 + 3 = 4, return true
        System.out.println(twoSum.find(5));  // 1 + 3 = 4, return true
//        System.out.println(twoSum.find(6));  // 1 + 3 = 4, return true
//        System.out.println(twoSum.find(7));
    }
}
