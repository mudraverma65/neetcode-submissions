class Solution {
    public int subarraySum(int[] nums, int k) {
        int res = 0;
        int currSum = 0;

        Map<Integer, Integer> prefixSums = new HashMap<>();

        prefixSums.put(0,1);

        for(int num: nums){
            currSum += num;
            int diff = currSum-k;

            if(prefixSums.containsKey(diff)){
                res += prefixSums.get(diff);
            } 

            prefixSums.put(currSum, prefixSums.getOrDefault(currSum, 0)+1);
        }

        return res;

    }
}