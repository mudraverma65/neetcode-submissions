class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int i= 0; i< nums.length; i++){
            int diff = target - nums[i];
            if(countMap.containsKey(diff)){
                return new int[]{countMap.get(diff), i};
            }
            countMap.put(nums[i],i);
        }
        return new int[0];
    }
}
