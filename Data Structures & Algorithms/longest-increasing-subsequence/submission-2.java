class Solution {
    public int lengthOfLIS(int[] nums) {

        if(nums == null || nums.length == 0){
            return 0;
        }

        int[] dp = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            dp[i] = 1;
        }

        int largest = 1;

        for(int i = 1; i < nums.length; i++){
            for (int j = i-1; j >= 0; j--){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            largest = Math.max(dp[i], largest);
        }

        return largest;
        
    }
}
