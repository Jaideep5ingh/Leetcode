package leetcode.problems.easy;

import java.util.HashSet;

public class UniqueEmailAddresses929 {
    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        HashSet<String> set = new HashSet<>();

        for(String s : emails){
            String[] parts = s.split("@");
            String localName = parts[0].replaceAll("\\.","");

            int plusChar = localName.indexOf('+');
            int length = plusChar == -1 ? localName.length() : plusChar;
            localName = localName.substring(0,length);

            set.add(localName + "@" + parts[1]);
        }

        System.out.println(set.size());
    }
}
