package leetcode.problems.medium;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath71 {
    public static void main(String[] args) {
        String path = "/a/./b/../../c/";
        if(path==null || path.length()<1)
            System.out.println("/");

        Deque<String> dq = new ArrayDeque<>();

        String [] arr = path.split("/");

        for(String s : arr ){
            if(s!=null && !s.isBlank()){
                if(s.equalsIgnoreCase(".")){
                    continue;
                }
                else if(s.equalsIgnoreCase("..")){
                    if(!dq.isEmpty())
                        dq.removeLast();
                }
                else {
                    dq.offer(s);
                }
            }
        }

        //Create the absolute path:
        if(dq.isEmpty()){
            System.out.println("/");
        }
        else {
            StringBuilder sb = new StringBuilder();
            for(String s:dq){
                sb.append("/").append(s);
            }
            System.out.println(sb.toString());
        }
    }
}
