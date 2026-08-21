class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[] dp = new int[amount+1];

for(int i : coins){
	if(i <= amount) {
        dp[i] = 1;
    }
}

for(int i = 1 ; i <= amount ; i++){
	  if(dp[i] != 0) continue;

	  int mini = Integer.MAX_VALUE;
	  for(int j = 0 ; j < coins.length ; j++){
	       if(i - coins[j] > 0 && dp[i-coins[j]] != 0)
	           mini = Integer.min(mini,dp[i-coins[j]]);
	  }

	  dp[i] = mini != Integer.MAX_VALUE ? mini + 1 : 0; 
}

return dp[amount] == 0 ? -1 : dp[amount];
        
    }
}