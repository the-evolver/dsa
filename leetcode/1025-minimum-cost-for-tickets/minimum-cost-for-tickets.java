class Solution {
    Integer[] dp;
    public int mincostTickets(int[] days, int[] costs) {
        dp = new Integer[days.length];
        return solve(days, costs, 0);
    }

    private int solve(int[] days, int[] costs, int i) {
        if (i == days.length) return 0;
        if (dp[i] != null) return dp[i];       

        int[] dur = {1, 7, 30};
        int best = Integer.MAX_VALUE;
        for (int j = 0; j < 3; j++) {
            int k = i;
            while (k < days.length && days[k] < days[i] + dur[j]) k++;
            best = Math.min(best, costs[j] + solve(days, costs, k));
        }
        return dp[i] = best;
    }
}