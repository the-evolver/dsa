class Solution {
    public int deleteAndEarn(int[] nums) {

        // state => dp[i][0] = max from o to i by deleting i
        //          dp[i][1] = max from o to i by not deleting i   keeping in mind i have sorted nums ...

        Arrays.sort(nums);
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i : nums){
            mp.merge(i,i,Integer::sum);
        }
          
        int[][] dp = new int[nums.length][2];
        dp[0][0] = mp.get(nums[0]);
        dp[0][1] = 0;

        for(int i = 1 ; i < dp.length ; i++){
               if(nums[i] == nums[i-1]){
                dp[i][0] = dp[i-1][0];
                dp[i][1] = dp[i-1][1];
                continue;
               }
               dp[i][0] = mp.get(nums[i]) + (nums[i] - 1 == nums[i-1] ? dp[i-1][1] : Integer.max(dp[i-1][0],dp[i-1][1]));
               dp[i][1] = Integer.max(dp[i-1][0],dp[i-1][1]);
        }
        
        return Integer.max(dp[dp.length-1][0],dp[dp.length-1][1]);
    }
}