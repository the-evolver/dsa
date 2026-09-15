class Solution {
public:
    int maxPalindromes(string s, int k) {
        int n = s.size();

        vector<int> dp(n + 1, 0);

        for (int i = 0; i < n; i++) {

            dp[i + 1] = max(dp[i + 1], dp[i]);
            for (int l = i, r = i; l >= 0 && r < n && s[l] == s[r]; l--, r++) {

                int len = r - l + 1;

                if (len >= k) {
                    dp[r + 1] = max(dp[r + 1], dp[l] + 1);
                }
            }
            for (int l = i, r = i + 1; l >= 0 && r < n && s[l] == s[r]; l--, r++) {

                int len = r - l + 1;

                if (len >= k) {
                    dp[r + 1] = max(dp[r + 1], dp[l] + 1);
                }
            }
        }

        return dp[n];
    }
};

 // // while(i < s.length()){
        // //        string curr = "";
        // //        while(j < s.length()){
        // //              if(curr.length() == 0 || curr[0] == s[j]){
        // //                 curr += s[j];
        // //                 j++;
        // //                 if(curr.length() == k){
        // //                     ans++;
        // //                     curr = "";
        // //                     j++;
        // //                     i=j;
        // //                 }
        // //              }else{
        // //                 curr = curr.substr(1);
        // //                 i++;
        // //              }
                      
        // //        }
        // // }
        // return ans;