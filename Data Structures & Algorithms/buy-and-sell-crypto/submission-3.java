class Solution {
    public int maxProfit(int[] prices) {
        int minBuy = prices[0];
        int maxP = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > minBuy) {
                int profit = prices[i] - minBuy;
                maxP = Math.max(profit, maxP);
            } else {
                minBuy = prices[i];
            }
        }
        return maxP;
    }
}
