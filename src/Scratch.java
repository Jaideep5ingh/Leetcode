import com.company.dataStructures.implementations.TreeNode;
import leetcode.problems.easy.ListNode;

import java.util.*;

public class Scratch {
 public static void main(String[] args) {
  int[] cost = {4,2,1,2};

  int minimumCost[] = new int[cost.length + 1];

  // Start iteration from step 2, since the minimum cost of reaching
  // step 0 and step 1 is 0
  for (int i = 2; i < minimumCost.length; i++) {
   int test = minimumCost[i - 1];
   int takeOneStep = minimumCost[i - 1] + cost[i - 1];
   int takeTwoSteps = minimumCost[i - 2] + cost[i - 2];
   minimumCost[i] = Math.min(takeOneStep, takeTwoSteps);
  }

 }
}
