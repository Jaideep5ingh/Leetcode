package leetcode.problems.medium;

import java.util.*;

public class TopKFrequentWords692 {
    public static void main(String[] args) {
        String[] words = {"i","love","leetcode","i","love","coding"};
        int k =3;
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            hashMap.put(words[i],hashMap.getOrDefault(words[i],0) +1);
        }
        PriorityQueue<Map.Entry<String, Integer>> priorityQueue = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue() == o2.getValue()? o2.getKey().compareTo(o1.getKey()) : o1.getValue() - o2.getValue();
            }
        });

        for (Map.Entry<String, Integer> entry : hashMap.entrySet()){
            priorityQueue.offer(entry);
            if (priorityQueue.size() >k){
                priorityQueue.poll();
            }
        }
        ArrayList<String> ans = new ArrayList<>();
        while(!priorityQueue.isEmpty()){
            ans.add(priorityQueue.poll().getKey());
        }
        System.out.println(ans);
    }
}
