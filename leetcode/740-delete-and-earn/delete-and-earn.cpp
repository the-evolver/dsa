class Solution {
public:
    int deleteAndEarn(vector<int>& nums) {

        int n = 10000 + 1;
        vector<int> arr(n,0);
        vector<int> dp(n,0);

        for(int x : nums) arr[x] += x;

        for(int i = 1 ; i < n ; i++){
            dp[i] = max(arr[i] + (i-2 >= 0 ? dp[i-2] : 0),dp[i-1]);
        }
        return dp[n-1];
    }
};