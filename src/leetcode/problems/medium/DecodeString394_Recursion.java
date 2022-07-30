package leetcode.problems.medium;

public class DecodeString394_Recursion {
    static int index = 0;
    public static void main(String[] args) {
//      int[] nums = {1,2,3};
        String s = "3[a]2[bc]";
        String finalAnswer = decodeString(s);
        System.out.println(finalAnswer);
    }

    public static String decodeString(String s) {
        StringBuilder result  = new StringBuilder();
        while(index < s.length() && s.charAt(index) != ']') {
            if(!Character.isDigit(s.charAt(index))){
                result.append(s.charAt(index++));
            }
            else{
                int k =0;
                while(index < s.length() && Character.isDigit(s.charAt(index)))
                    k = k * 10 + s.charAt(index++) - '0';
                index++;
                String decodedString = decodeString(s);
                index++;
                while(k-- > 0){
                    result.append(decodedString);
                }
            }
        }
        return new String(result);
    }
}
