class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> dict = new HashMap<>();

        for (int i =0; i< numbers.length; i++){
            int diff = target - numbers[i];

            if (dict.containsKey(diff) && diff != numbers[i]){
                return new int[]{ dict.get(diff)+1, i+1};
            } else{
                dict.put(numbers[i], i);
            }
        }
        return new int[0];
    }
}
