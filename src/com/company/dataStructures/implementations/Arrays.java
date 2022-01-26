package com.company.dataStructures.implementations;

public class Arrays {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        s = s.replaceAll("[^a-zA-Z0-9]*\\s", "");
        s = s.toLowerCase();
//        s = s.replaceAll("\\s","");
        int i = 0;
        int j = s.length()-1;
        boolean palindrome = false;
        while(j>=i){
            if(s.charAt(i) != s.charAt(j)){
                palindrome = false;
            }
            i++;
            j--;
        }
        palindrome = true;
        System.out.println(palindrome);
    }
}
