class Solution {
    public int rob(int[] nums) {

        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = nums[0];  // dp[i][0] = store max money till ith house looting ith house
        dp[0][1] = 0;        // max money till ith house without looting ith house...

        for(int i = 1 ; i < n ; i++){
             dp[i][0] = nums[i] + dp[i-1][1];
             dp[i][1] = Integer.max(dp[i-1][0],dp[i-1][1]);
             
        }

        return Integer.max(dp[n-1][0],dp[n-1][1]);
        
    }
}