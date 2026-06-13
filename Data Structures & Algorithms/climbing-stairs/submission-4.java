class Solution {
    public int climbStairs(int n) {
        int second = 1;
        int first = 1;

        for (int i=n-2; i>=0; i--){
            int curr = first + second;
            second = first;
            first = curr;
        }
        return first;
    }
}
