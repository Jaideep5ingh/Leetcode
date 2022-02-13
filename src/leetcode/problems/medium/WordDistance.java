package leetcode.problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class WordDistance {
    HashMap<String, ArrayList<Integer>> hashmap;

    public WordDistance(String[] wordsDict) {
        hashmap = new HashMap<>();
        for (int i=0; i<wordsDict.length;i++){
            if (!hashmap.containsKey(wordsDict[i])){
                hashmap.put(wordsDict[i], new ArrayList<>());
            }
            hashmap.get(wordsDict[i]).add(i);
        }

    }

    public int shortest(String word1, String word2) {
        ArrayList<Integer> list1, list2;
        list1 = this.hashmap.get(word1);
        list2 = this.hashmap.get(word2);
        int min = Integer.MAX_VALUE,  l1 =0 , l2 = 0;
        while(l1< list1.size() && l2< list2.size()){
            min = Math.min(min,Math.abs(list1.get(l1)-list2.get(l2)));
            if(list1.get(l1)<list2.get(l2)){
                l1++;
            }else l2++;
        }
        return min;
    }

    public static void main(String[] args) {
        WordDistance wordDistance = new WordDistance(new String[]{"coding", "makes", "perfect",
                "coding","nostalgia", "makes","practice"});
        wordDistance.shortest("coding", "practice"); // return 3
        System.out.println(wordDistance.shortest("makes", "coding"));;    // return 1
    }
}
