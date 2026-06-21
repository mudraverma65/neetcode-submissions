class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);

        int left = 1, right = piles[piles.length-1];
        int ans = right;
        while(left <= right){
            int mid = left + (right - left) /2;
            long hours = hoursTaken(piles, mid);
            if(hours <= h){
                ans = mid;
                right = mid - 1;
            } else{
                left = mid + 1;
            }
        }
        return ans;
    }

    public long hoursTaken(int[] piles, int speed){
        long hours = 0;

        for(int pile : piles){
            hours += pile / speed;
            int rem = pile % speed;
            if(rem !=0){
                hours ++;
            }
        }
        return hours;
    }
}
