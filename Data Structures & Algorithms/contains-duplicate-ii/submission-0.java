class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> duplicate = new HashSet<>();

        int left = 0;
        for (int right =0; right<nums.length; right++){
            if(right - left > k){
                duplicate.remove(nums[left]);
                left ++;
            }

            if(duplicate.contains(nums[right])){
                return true;
            }

            duplicate.add(nums[right]);

        }

        return false;
    }
}