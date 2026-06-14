class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }

        HashMap<Character, Integer> countMapS = new HashMap<>();
        HashMap<Character, Integer> countMapT = new HashMap<>();

        for(int i = 0; i<s.length(); i++){
            countMapS.put(s.charAt(i), countMapS.getOrDefault(s.charAt(i), 0) + 1);
            countMapT.put(t.charAt(i), countMapT.getOrDefault(t.charAt(i), 0) + 1);
        }
        return countMapS.equals(countMapT);
    }
}
