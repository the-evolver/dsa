#include <bits/stdc++.h>
using namespace std;

#define ll long long
#define endl "\n"


int longestConsecutive(vector<int>& nums) {
        unordered_map<int,int> mp;
        int ans = 0,curr = 0;
        for(int num : nums){
             if(mp[num] != 0) continue;
             curr = 1 + mp[num-1] + mp[num+1];
             
             ans = max(ans,curr);
             mp[num] = curr;
             mp[num - mp[num-1]] = curr;       // dont need to update whole range ..
                                               // we will not consider  in between element [....[l,,,,r]........
             mp[num + mp[num + 1]] = curr;     // only l and r matters for future max range possibility]
             
        }
        return ans;
}
void solve(vector<int>& nums) {
    longestConsecutive(nums);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

#ifndef ONLINE_JUDGE
    freopen("input.txt", "r", stdin);
    freopen("output.txt", "w", stdout);
#endif

    int t = 1;
    cin >> t;

    while (t--) {
        int n;cin>>n;
        vector<int> nums(n,-1);
        for(int i = 0 ; i < n ; i++) cin>>nums[i];
        solve(nums);
    }

    return 0;
}


