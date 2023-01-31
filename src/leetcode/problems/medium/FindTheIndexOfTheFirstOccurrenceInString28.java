package leetcode.problems.medium;

public class FindTheIndexOfTheFirstOccurrenceInString28 {

    public static int strStr_slidingWindow(String haystack, String needle) {
        int hLength = haystack.length(), nLength = needle.length();
        if(nLength > hLength) return -1;
        for (int windowStart = 0; windowStart <= hLength-nLength; windowStart++) {
            for (int i = 0; i < nLength; i++) {
                if(haystack.charAt(windowStart + i) != needle.charAt(i)) break;
                if(i == nLength-1) return windowStart;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String haystack = "ppi" , needle = "pi";
        System.out.println(strStr_slidingWindow(haystack, needle));
    }
}
