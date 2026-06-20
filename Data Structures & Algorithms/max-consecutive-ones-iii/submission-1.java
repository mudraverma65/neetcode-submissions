class Solution {
    public int longestOnes(int[] nums, int k) {
        int[] prefix = new int[nums.length + 1];

        int zeros = 0;
        prefix[0] = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                zeros++;
            }
            prefix[i+1] = zeros;
        }
        int max = Integer.MIN_VALUE;
        int left = 0, right = 0;
        while(right < nums.length){
            int maxZ = prefix[right+1] - prefix[left];
            if(maxZ > k){
                left ++;
            } else{
                right ++;
            }
            max = Math.max(max, right - left);
        }

        return max;
    }
}