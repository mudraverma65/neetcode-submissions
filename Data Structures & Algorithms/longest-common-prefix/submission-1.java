class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++){
            for(int j = 0; j < prefix.length(); j++){
                if(j >= strs[i].length() || strs[i].charAt(j) != prefix.charAt(j) ){
                    prefix = prefix.substring(0, j);
                }
            }
        }
        return prefix;
    }
}