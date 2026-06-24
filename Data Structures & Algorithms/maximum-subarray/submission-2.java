class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length+1];

        int allTimeMax = Integer.MIN_VALUE;

        dp[0] = 0;

        for(int i = 0; i<nums.length; i++){
            int currMax = Math.max(dp[i] + nums[i], nums[i]);
            allTimeMax = Math.max(currMax, allTimeMax);
            dp[i+1] = currMax;
        }

        return allTimeMax;
    }
}
