class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        
        unordered_map<char,int> mp;
        int left = 0,right = 0;
        int curr = 0,maxi = 0;
        while(right < s.length()){
            char c = s[right];
             mp[c]++;
             while(left <= right && mp[c] > 1){
                    mp[s[left]]--;
                    left++;
             }
             curr = right - left +1;
             maxi = max(curr,maxi);
             right++;

        }
        return maxi;
    }
};