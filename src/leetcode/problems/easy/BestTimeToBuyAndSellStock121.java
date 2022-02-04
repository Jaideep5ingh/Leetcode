package leetcode.problems.easy;

import java.util.PriorityQueue;
import java.util.Queue;

public class BestTimeToBuyAndSellStock121 {
    public static void main(String[] args) {
  int[] prices = {7,1,5,3,6,4};
//        int[] prices = {2,4,1};
        int maxProfit = -1;
        int minBuy = prices[0];

        if (prices.length == 1){
            return 0;
            //The function should break at this point.
        }
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minBuy){
                minBuy = prices[i];
            }
            maxProfit = Math.max(maxProfit, prices[i] - minBuy);
        }
        System.out.println(maxProfit);
    }
}
