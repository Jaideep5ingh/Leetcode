package leetcode.problems.easy;

import java.util.Arrays;
import java.util.Comparator;

public class ReorderDataInLogFiles937 {
    public static void main(String[] args) {
        String[] logs = {"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] first = o1.split(" ",2);
                String[] second = o2.split(" ",2);

                boolean isDigit1 = Character.isDigit(first[1].charAt(0));
                boolean isDigit2 = Character.isDigit(second[1].charAt(0));

                if(!isDigit1 && !isDigit2) {
                    int comparision = first[1].compareTo(second[1]);
                    return comparision != 0 ? comparision : first[0].compareTo(second[0]);
                }

                if (!isDigit1 && isDigit2){
                    return -1;
                }else if (isDigit1 && !isDigit2){
                    return 1;
                }else return 0;
            }
        };

        Arrays.sort(logs,comparator);

        System.out.println(Arrays.toString(logs));
    }
}
