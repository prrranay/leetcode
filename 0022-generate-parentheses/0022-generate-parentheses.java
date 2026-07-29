class Solution {
    List<String> ans = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        solve(0, 0, n, new StringBuilder(""));
        return ans;
    }

    public void solve(int open, int close, int max, StringBuilder str) {
        if (str.length() == max * 2) {
            ans.add(str.toString());
            return;
        }

        if (open < max) {
            str.append('(');
            solve(open + 1, close, max, str);
            str.deleteCharAt(str.length() - 1);
        }

        if (close < open) {
            str.append(')');
            solve(open, close + 1, max, str);
            str.deleteCharAt(str.length() - 1);
        }
    }
}