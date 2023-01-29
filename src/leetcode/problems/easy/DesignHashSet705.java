package leetcode.problems.easy;

import java.util.LinkedList;

public class DesignHashSet705 {
    LinkedList<Integer>[] list;
    int keyRange;

    public DesignHashSet705() {
        this.keyRange = 769;
        this.list = new LinkedList[769];
        for (int i = 0; i < keyRange; i++) {
            list[i] = new LinkedList<Integer>();
        }
    }

    public void add(int key) {
        int hash = hashValue(key);
        int index = this.list[hash].indexOf(key);
        if (index == -1) {
            this.list[hash].addFirst(key);
        }
    }

    public void remove(int key) {
        int hash = hashValue(key);
        int idx = this.list[hash].indexOf(key);
        if(idx!=-1) this.list[hash].remove(idx);
//      this.list[hash].remove(key); //did not work as it kept reading key as the index to be deleted.
//      this.list[hash].remove((Object)key); //This on the other hand worked.
    }

    public boolean contains(int key) {
        return this.list[hashValue(key)].indexOf(key) != -1;
    }

    public int hashValue(int key){
        return key % this.keyRange;
    }

    public static void main(String[] args) {
        DesignHashSet705 myHashSet = new DesignHashSet705();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(1)); // return True
        System.out.println(myHashSet.contains(3)); // return False, (not found)
        myHashSet.add(2);      // set = [1, 2]
        System.out.println(myHashSet.contains(2)); // return True
        myHashSet.remove(2);   // set = [1]
        myHashSet.contains(2);
    }
}
