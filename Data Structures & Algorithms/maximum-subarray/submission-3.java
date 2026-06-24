class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length+1];

        int allTimeMax = Integer.MIN_VALUE;

        int current = 0;

        for(int i = 0; i<nums.length; i++){
            int currMax = Math.max(current + nums[i], nums[i]);
            allTimeMax = Math.max(currMax, allTimeMax);
            current = currMax;
        }

        return allTimeMax;
    }
}
