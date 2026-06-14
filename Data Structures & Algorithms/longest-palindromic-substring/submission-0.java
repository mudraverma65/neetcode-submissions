class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 1 ){
            return s;
        }

        int resIndex = 0;
        int resLen = 0;

        for (int i = 0; i<s.length(); i++){
            int left = i; 
            int right = i;

            while(left >=0 && right < s.length() 
            && s.charAt(left) == s.charAt(right)){
                if(resLen < (right - left) + 1){
                    resIndex = left;
                    resLen = (right - left) + 1;
                }
            left --;
            right ++;  
            } 
            
            left = i;
            right = i+1;

            while(left >=0 && right < s.length() 
            && s.charAt(left) == s.charAt(right)){
                if(resLen < (right - left) + 1){
                    resIndex = left;
                    resLen = (right - left) + 1;
                }
                left --;
                right ++;
            }
        }
        return s.substring(resIndex, resIndex + resLen); 
    }
}
