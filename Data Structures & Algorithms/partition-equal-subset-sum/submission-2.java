class Solution {
    Boolean[][] memo;
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        int subSum = totalSum / 2;
        int rem = totalSum % 2;
        memo = new Boolean[nums.length][subSum+1];
        if (rem != 0) {
            return false;
        }

        return dfs(nums, 0, subSum);
    }

    public boolean dfs(int[] nums, int i, int target) {
        if (target == 0) {
            return true;
        }
        if (target < 0 || i == nums.length) {
            return false;
        }
        if (memo[i][target] != null) {
            return memo[i][target];
        }

        memo[i][target] = dfs(nums, i + 1, target) || dfs(nums, i + 1, target - nums[i]);

        return memo[i][target];
    }
}
