class Solution {
    Integer[] dp;

    public int numDecodings(String s) {
        dp = new Integer[s.length()];
        return solve(s.toCharArray(), 0);
    }

    private int solve(char[] str, int i) {
        if (i == str.length) return 1;
        if (str[i] == '0') return 0;

        if (dp[i] != null) return dp[i];

        int ways = solve(str, i + 1);

        if (i + 1 < str.length) {
            int num = (str[i] - '0') * 10 + (str[i + 1] - '0');

            if (num <= 26) {
                ways += solve(str, i + 2);
            }
        }

        return dp[i] = ways;
    }
}