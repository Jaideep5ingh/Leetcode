package leetcode.problems.medium;

public class StringCompression443 {
    public static void main(String[] args) {
        char[] chars =  {'a','a','b','b','b','b','c','c','d'};
        int k =0;
//  if(chars.length ==1) {
//   System.out.println(chars[0]);
//   System.exit(0);
//  }

        for (int i=0;i < chars.length; i++) {
            int count =1;
            while(i < chars.length-1 && chars[i]==chars[i+1]){
                count++;
                i++;
            }
            if (count>1){
                chars[k] = chars[i];
                chars[++k] =  Character.forDigit(count,10);  ;
            }else{
                chars[k]= chars[i];
            }
            k++;
        }
        for (int i = 0; i < k; i++) {
            System.out.println(chars[i]);
        }
    }
}
