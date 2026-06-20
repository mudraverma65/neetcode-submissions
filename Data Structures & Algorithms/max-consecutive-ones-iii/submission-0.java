class Solution {
    public int longestOnes(int[] nums, int k) {
        int slidingCounter = 0;
        int maxW = Integer.MIN_VALUE;

        int left = 0, right =0;

        while(right <= nums.length-1 ){
            if(nums[right] == 1){
                right ++;
            } else if(nums[right] == 0){
                if(slidingCounter < k){
                    right ++;
                    slidingCounter ++;
                } else {
                    if(nums[left] == 0){
                        slidingCounter -- ;
                    }
                    left ++;
                }
            }

            maxW = Math.max(maxW, (right - left));
        }
        return maxW;
    }
}