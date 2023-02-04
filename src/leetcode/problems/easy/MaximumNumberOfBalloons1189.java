package leetcode.problems.easy;

public class MaximumNumberOfBalloons1189 {

    public static int maxNumberOfBalloons(String text) {
        int[] count = new int[26];
        int[] frequency = new int[26];
        int min =  Integer.MAX_VALUE;
        for(char c : ("balloon").toCharArray()) frequency[c - 'a']++;
        for(char c : text.toCharArray()) count[c - 'a']++;
        for (int i = 0; i < 26; i++) {
            if(frequency[i] > 0) min = Math.min(min, count[i]/frequency[i]);
        }
        return min;
    }

    public static void main(String[] args) {
        String test = "hpitp";
        System.out.println(maxNumberOfBalloons(test));
    }
}
