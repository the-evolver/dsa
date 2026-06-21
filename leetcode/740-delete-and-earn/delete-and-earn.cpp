class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {

        int n = 10e4 +1;
        vector<int> arr(n,0);
        for(int x : nums) arr[x] += x;

        vector<vector<int>> dp(n,vector<int>(2,0));
        for(int i = 0 ; i < dp.size();i++){
             dp[i][0] = arr[i] + (i - 2 >= 0 ? max(dp[i-2][0],dp[i-2][1]) : 0);
             dp[i][1] = i - 1 >= 0 ? max(dp[i-1][0],dp[i-1][1]) :0;
             
        }

        return max(dp[n-1][0],dp[n-1][1]);
        
    }
};