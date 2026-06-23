class Solution {
    public String largestNumber(int[] nums) {
        String arr[] = new String[nums.length];
        for(int i =0; i<nums.length; i++){
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, (a,b) -> (b+a).compareTo(a+b));

        StringBuilder res = new StringBuilder();
        for(String curr: arr){
            res.append(curr);
        }

        return res.charAt(0) == '0' ? "0" : res.toString();
    }
}