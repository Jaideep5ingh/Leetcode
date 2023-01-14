package leetcode.problems.medium;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class TimeBasedKeyValueStore981 {
    HashMap<String, ArrayList<Pair<Integer, String>>> keyTimeMap;

    public TimeBasedKeyValueStore981() {
        this.keyTimeMap = new HashMap<>(20);
    }

    public void set_binarySearch(String key, String value, int timestamp) {
        if(!keyTimeMap.containsKey(key)) {
            keyTimeMap.put(key, new ArrayList<Pair<Integer, String>>());
        }
        keyTimeMap.get(key).add(new Pair<>(timestamp, key));
    }

    public String get_binarySearch(String key, int timestamp) {
        if(!keyTimeMap.containsKey(key)) return "";
        if(keyTimeMap.get(key).get(0).getKey() < timestamp)  return "";

        ArrayList<Pair<Integer, String>> temp = keyTimeMap.get(key);
        int left = 0, right = temp.size();
        while(left<right){
            int mid = (left + right) >> 1;
            Pair<Integer, String> midVal = temp.get(mid);
            if(midVal.getKey() == timestamp) return midVal.getValue();
            if(midVal.getKey() < timestamp) left = mid + 1;
            else right = mid;
        }
        if (right == 0) {
            return "";
        }
        return temp.get(left-1).getValue();
    }
}
