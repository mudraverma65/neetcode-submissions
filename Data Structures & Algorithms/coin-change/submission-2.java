class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = -2;
        }
        return dfs(amount, coins, memo);
    }

    public int dfs(int amount, int[] coins, int[] memo) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }

        if (memo[amount] != -2) {
            return memo[amount];
        }
        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {
            int rem = amount - coin;

            int res = dfs(rem, coins, memo);

            if(res >= 0){
                minCoins = Math.min(minCoins, res+1);
            }
        }

        if (minCoins == Integer.MAX_VALUE) {
            memo[amount] = -1;
        } else{
            memo[amount] = minCoins;
        }

        return memo[amount];
    }
}