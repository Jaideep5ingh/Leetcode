import java.sql.Array;
import java.util.*;import java.util.Map.Entry;

 public class Scratch {
  public static void main(String[] args) {
   LinkedList<Integer> stack = new LinkedList<>();
   stack.add(1);
   stack.add(2);
   stack.add(4);
   stack.add(5);
   stack.add(6);
   stack.add(8);

   while(!stack.isEmpty()) {
    System.out.println(stack.pollLast());
   }
  }
 }
