class Solution {
    public String stoneGameIII(int[] stoneValue) {
        // kisi bhi index i pe mai do broad ways me aa skta hun, idhar chance alice ke pass ho ya bob ke pass ho 
         int n = stoneValue.length;
        int[] dp = new int[n + 1];
         // so hm state me ye store kr rhen hai ki current player ke sath agle wale ka diff kya he

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Integer.MIN_VALUE;
            int sum = 0;

            for (int j = i; j < Math.min(i + 3, n); j++) {
                sum += stoneValue[j];
                dp[i] = Math.max(dp[i], sum - dp[j + 1]);
            }
        }

        if (dp[0] > 0) return "Alice";
        if (dp[0] < 0) return "Bob";
        return "Tie";

        // 
        
    }
}

