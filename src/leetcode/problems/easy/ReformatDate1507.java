package leetcode.problems.easy;

import java.util.HashMap;

public class ReformatDate1507 {
    public static void main(String[] args) {
        String date= "20th Jan 2052";
        String output="";
        String[] split = date.split("\\s+");
        HashMap<String, String> months = new HashMap<>();
        months.put("Jan","01");
        months.put("Feb","02");
        months.put("Mar","03");
        months.put("Apr","04");
        months.put("May","05");
        months.put("Jun","06");
        months.put("Jul","07");
        months.put("Aug","08");
        months.put("Sept","09");
        months.put("Oct","10");
        months.put("Nov","11");
        months.put("Dec","12");

        output += split[split.length-1] + "-" + months.get(split[1]) + "-";
        if(Character.isDigit(split[0].charAt(1))){
            output += split[0].charAt(0) + "" + split[0].charAt(1);
        }else  output += "0"+split[0].charAt(0);
        System.out.println(output);
    }
}
