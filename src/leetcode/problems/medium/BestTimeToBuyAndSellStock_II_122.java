package leetcode.problems.medium;

public class BestTimeToBuyAndSellStock_II_122 {

    public static int maxProfit(int[] prices) {
        int min = prices[0];
        int totalProfit = 0;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i-1]) maxProfit = Math.max(maxProfit, prices[i] - min);
            else if(prices[i] < prices[i-1]){
                min = prices[i];
                totalProfit += maxProfit;
                maxProfit = 0;
            }
        }
        return maxProfit > 0 ? totalProfit+maxProfit : totalProfit;
    }

    public static int maxProfit_leetcode(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i-1]) maxProfit += prices[i] - prices[i-1];
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        System.out.println(maxProfit(nums));
        System.out.println(maxProfit_leetcode(nums));
    }
}
