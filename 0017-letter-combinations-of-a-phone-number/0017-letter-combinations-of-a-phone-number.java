class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        String[] mapping = {
                "",
                "", "abc", "def",
                "ghi", "jkl", "mno",
                "pqrs", "tuv", "wxyz"
        };
        List<String> ans = new ArrayList<>();
        create(digits, mapping, 0, ans, new StringBuilder());
        return ans;
    }

    private static void create(String digits, String[] mapping, int i, List<String> ans, StringBuilder curr) {
        if (i == digits.length()) {
            ans.add(curr.toString());
            return;
        }
        String str = mapping[digits.charAt(i) - '0'];

        for (char ch : str.toCharArray()) {
            curr.append(ch);
            create(digits, mapping, i + 1, ans, curr);
            curr.deleteCharAt(curr.length() - 1);
        }
    }
}