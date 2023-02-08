package leetcode.problems.medium;

public class PermutationInString567 {
    public static boolean checkInclusion_my(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();
        if(s1Len > s2Len) return false;
        if(s1Len == 0) return true;

        int[] s1Count = new int[26];
        int[] windowCount;

        for(char c : s1.toCharArray()) s1Count[c - 'a']++;
        String s1PermutationString = arrayToString(s1Count);

        int left = 0, right = s1Len - 1;
        while(right < s2Len){
            windowCount = new int[26];
            for (int i = left; i <= right; i++) windowCount[s2.charAt(i) - 'a']++;
            if(s1PermutationString.equals(arrayToString(windowCount))) return true;
            ++left; ++right;
        }

        return false;
    }

    public static String arrayToString(int[] count){
        StringBuilder s = new StringBuilder("#");
        for(int num : count) s.append(num + "#");
        return s.toString();
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1map[s1.charAt(i) - 'a']++;
            s2map[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(s1map, s2map))
                return true;
            char s2CurrentChar = s2.charAt(i);
            char s2Char = s2.charAt(i + s1.length());
            s2map[s2Char - 'a']++;
            s2map[s2CurrentChar - 'a']--;
        }
        return matches(s1map, s2map);
    }

    public static boolean matches(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String hay = "ab";
        String needle = "eidboaoo";
        System.out.println(checkInclusion(hay, needle));
    }
}
