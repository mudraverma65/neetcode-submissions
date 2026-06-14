class Solution {
    public boolean validPalindrome(String s) {
        if (isPalindrome(s)) {
            return true;
        }
        for(int i = 0; i< s.length(); i++){
            String newS = s.substring(0,i) + s.substring(i+1, s.length());
            if(isPalindrome(newS)){
                return true;
            }
        }

        return false;
    }

    public boolean isPalindrome(String s){
        int left = 0;
        int right = s.length()-1;

        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}