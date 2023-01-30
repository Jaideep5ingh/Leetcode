package leetcode.problems.easy;

import java.util.Arrays;
import java.util.LinkedList;

public class DesignHashMap706 {
    int keyRange;
    LinkedList<Integer[]>[] list;

    public DesignHashMap706() {
        this.keyRange = 2069;
        list = new LinkedList[keyRange];
        for (int i = 0; i < keyRange; i++) {
            list[i] = new LinkedList<>();
            list[i].add(new Integer[2]);
            Arrays.fill(list[i].get(0), Integer.MIN_VALUE);
        }
    }

    public void put(int key, int value) {
        int hashValue = hashValue(key);
        for(Integer[] pair : this.list[hashValue]){
            int k = pair[0];
            if(k == key) {
                pair[1] = value;
                return;
            }
        }
        this.list[hashValue].addLast(new Integer[]{key,value});
    }

    public int get(int key) {
        int hashValue = hashValue(key);
        for(Integer[] pair : this.list[hashValue]){
            int k = pair[0];
            if(k == key) return pair[1];
        }
        return -1;
    }

    public void remove(int key) {
        int hashValue = hashValue(key);
        for (int i = 0; i < this.list[hashValue].size(); i++) {
            if(this.list[hashValue].get(i)[0] == key) this.list[hashValue].remove(i);
        }
    }

    public int hashValue(int key){
        return key % this.keyRange;
    }

    public static void main(String[] args) {
        DesignHashMap706 myHashMap = new DesignHashMap706();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(1));    // return 1, The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(3));    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        myHashMap.get(2);    // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        System.out.println(myHashMap.get(2));    // return -1 (i.e., not found), The map is now [[1,1]]
    }
}
