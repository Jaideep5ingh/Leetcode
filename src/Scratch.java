import java.sql.Array;
import java.util.*;

public class Scratch {
    public static void main(String[] args) {
        String[] cpdomains = {"900 google.mail.com", "50 yahoo.com",
                "1 intel.mail.com", "5 wiki.org"};

        HashMap< String,Integer> counts = new HashMap<>();

        for (String domain : cpdomains){
            String[] frequency = domain.split("\\s+");
            String[] parts = frequency[1].split("\\.");
//            System.out.println(Arrays.toString(domain.split(" ")));
//            System.out.println(Arrays.toString(frequency[1].split("\\.")));
            String curr = "";

            for (int i = parts.length-1; i >=0; i--) {
                curr = parts[i] + (i < parts.length - 1? ".":"") +curr;
                counts.put(curr,counts.getOrDefault(curr,0) + Integer.valueOf(frequency[0]));
            }
        }

        List<String> result = new ArrayList<>();
        for (String dom : counts.keySet()){
            result.add("" + counts.get(dom) + " " + dom);
//            System.out.println("" + counts.get(dom) + " " + dom);
        }

        for (String item : result){
            System.out.println(item);
        }
    }
}
