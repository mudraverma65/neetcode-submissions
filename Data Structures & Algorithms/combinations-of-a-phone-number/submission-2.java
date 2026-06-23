class Solution {
    HashMap<Integer, String[]> digitChar = new HashMap<>();
    {
        digitChar.put(2, new String[] {"a", "b", "c"});
        digitChar.put(3, new String[] {"d", "e", "f"});
        digitChar.put(4, new String[] {"g", "h", "i"});
        digitChar.put(5, new String[] {"j", "k", "l"});
        digitChar.put(6, new String[] {"m", "n", "o"});
        digitChar.put(7, new String[] {"p", "q", "r", "s"});
        digitChar.put(8, new String[] {"t", "u", "v"});
        digitChar.put(9, new String[] {"w", "x", "y", "z"});
        digitChar.put(0, new String[] {" "});
    }

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }

        dfs(digits, 0, res, new StringBuilder());
        return res;
    }

    public void dfs(String digits, int index, List<String> res, StringBuilder curr) {
        if (curr.length() == digits.length()) {
            res.add(curr.toString());
            return;
        }
        int myDigit = digits.charAt(index) - '0';

        if (!digitChar.containsKey(myDigit)) {
            return;
        }

        String[] allChars = digitChar.get(myDigit);
        for (String digit : allChars) {
            curr.append(digit);
            dfs(digits, index + 1, res, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}
