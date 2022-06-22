package leetcode.problems.easy;

public class RichestCustomerWealth1672 {
    public static void main(String[] args) {
        int[][] accounts =
                {{1,2,3},
                        {3,2,1}
                  ,{3,5,6}
                };

        int customerWealth = 0;
        int maxWealth = Integer.MIN_VALUE;

        for (int[] customer: accounts) {
            customerWealth = 0;
            for (int account: customer) {
                customerWealth+=account;
            }
            maxWealth = Math.max(customerWealth, maxWealth);
        }

        System.out.println("The max wealth is : " + maxWealth);
    }
}
