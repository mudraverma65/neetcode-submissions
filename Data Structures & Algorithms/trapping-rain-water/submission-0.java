class Solution {
    public int trap(int[] height) {
        int maxLength = height.length;
        if(maxLength == 0 || maxLength ==1){
            return 0;
        }

        int[] leftMax = new int[maxLength];
        int[] rightMax = new int[maxLength];

        int currLeftMax = 0;
        for (int i =0; i<maxLength; i++){
            currLeftMax = Math.max(currLeftMax, height[i]);
            leftMax[i] = currLeftMax;
        }

        int currRightMax = 0;
        for (int i=maxLength-1; i>=0; i--){
            currRightMax = Math.max(currRightMax, height[i]);
            rightMax[i] = currRightMax;
        }

        int result = 0;

        for (int i=0; i< maxLength; i++){
            int water = Math.min(leftMax[i], rightMax[i]) - height[i];
            if(water > 0){
                result+=water;
            }
        }
        return result;
    }
}