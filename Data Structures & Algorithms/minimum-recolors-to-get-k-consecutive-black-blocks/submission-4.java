class Solution {
    public int minimumRecolors(String blocks, int k) {
        int rep = 0;
        int left = 0; 
        int right;

        for(right=0; right<k; right++){
            if(blocks.charAt(right) == 'W'){
                rep++;
            }
        }

        int minVal = rep;

        while(right < blocks.length()){
            if(blocks.charAt(left) == 'W'){
                rep--;
            }
            if(blocks.charAt(right)=='W'){
                rep++;
            }
            left++;
            right++;
            minVal = Math.min(minVal, rep);
        }

        return minVal;
        
    }
}