package leetcode.problems.easy;

public class AddBinary67 {
    public static String addBinary_my(String a, String b) {
        if(b.length() > a.length()) return addBinary_my(b,a);
        char[] a_array = a.toCharArray();
        char[] b_array = b.toCharArray();
        int carry = 1;
        StringBuilder result = new StringBuilder();

        for (int i = a.length()-1, j = b.length()-1 ; i >=0; i--, j--) {
            char a_char = a_array[i];
            char b_char = b_array[j];
            if((a_char == '1' && b_char == '1'))  {
                if(carry == 0) {
                    result.append("0");
                    carry = 1;
                }
                else result.append("1");
            }
            else if((a_char == '1' || b_char == '1')){
                if(carry == 0) {
                    result.append("0");
                    carry = 1;
                }
                else result.append("1");
            }else {
                if(carry == 0) {
                    result.append("0");
                }
                else result.append("1");
            }
        }

        return result.toString();
    }

    public static String addBinary_leetcode(String a, String b) {
        if(b.length() > a.length()) return addBinary_leetcode(b,a);
        int carry = 0;
        StringBuilder result = new StringBuilder();

        for (int i = a.length()-1, j = b.length()-1; i >=0; i--, j--) {
            if(a.charAt(i) == '1') ++carry;
            if(j>-1 && b.charAt(j) == '1') ++carry;

            if(carry%2 == 1) result.append("1");
            else result.append("0");

            carry /= 2;
        }
        if(carry == 1) result.append("1");

        return result.reverse().toString();
    }

    public String addBinary_easy(String a, String b) {
        if(a == null || a.isEmpty()) {
            return b;
        }
        if(b == null || b.isEmpty()) {
            return a;
        }
        char[] aArray = a.toCharArray();
        char[] bArray = b.toCharArray();
        StringBuilder stb = new StringBuilder();

        int i = aArray.length - 1;
        int j = bArray.length - 1;
        int aByte;
        int bByte;
        int carry = 0;
        int result;

        while(i > -1 || j > -1 || carry == 1) {
            aByte = (i > -1) ? Character.getNumericValue(aArray[i--]) : 0;
            bByte = (j > -1) ? Character.getNumericValue(bArray[j--]) : 0;
            result = aByte ^ bByte ^ carry;
            carry = ((aByte + bByte + carry) >= 2) ? 1 : 0;
            stb.append(result);
        }
        return stb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1010", b = "1011";
        System.out.println(addBinary_leetcode(a, b));
        System.out.println(addBinary_my(a, b));
    }
}
