import java.sql.Array;
import java.util.*;import java.util.Map.Entry;

 public class Scratch {
  public static void main(String[] args) {
   int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
   int current_array = 0;
   int max_array = 0;

   for (int i = 0; i < nums.length; i++) {
    current_array += nums[i];
    if (current_array < max_array){
     current_array= 0;
    }
    max_array = Math.max(current_array, max_array);
   }
   System.out.println("Max Sub-array = " + max_array);
  }
 }
