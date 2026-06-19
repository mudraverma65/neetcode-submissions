class Solution {
    public int search(int[] nums, int target) {
        if(nums ==null || nums.length <1){
            return -1;
        }
        int left = 0, right = nums.length -1;
        while(left < right){
            int mid = left + (right -left) / 2;
            if(nums[mid] > nums[right]){
                left = mid + 1;
            } else{
                right = mid;
            }
        }

        int pivot = left;
        int result = binarySearch(0, pivot-1, nums, target);
        if(result == -1){
            result =  binarySearch(pivot, nums.length-1, nums, target);
        }
        return result;
    }

    public int binarySearch(int low, int high, int[] nums, int target){
        while(low <= high){
            int mid = low + (high - low) / 2;

            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] > target){
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }
        return -1;
    }
}
