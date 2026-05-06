class Solution {
    public int search(int[] nums, int target) {
        int l=0, r=nums.length-1;

        while(l<r){
            int mid = (l + r) /2;
            if (nums[mid] > nums[r]){
                l = mid+1;
            } else{
                r=mid;
            }
        }
        
        int pivot = l;
        int result = binarySearch(target, nums, 0, pivot-1);
        if(result == -1){
            result = binarySearch(target, nums, pivot, nums.length-1);
        }
        return result;
    }

        public int binarySearch(int target, int[] nums, int left, int right){
            while(left <= right){
                int mid = (left + right) /2;
                if(nums[mid] == target){
                    return mid;
                } else if(nums[mid] < target){
                    left = mid +1;
                } else{
                    right = mid-1;
                }
            }
            return -1;
    }
}
