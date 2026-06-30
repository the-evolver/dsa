class Solution {
public:
    int numberOfSubstrings(string s) {
        // abcabcabc
        int i = 0 ,j = 0;
        int ans = 0;
        vector<int> arr = {0,0,0};
        while(j < s.length()){
             
              arr[s[j]-'a']++;
              while(j > i && arr[0] >= 1 && arr[1] >= 1 && arr[2] >= 1){
                  ans += s.length() - j;
                  
                  arr[s[i++] - 'a']--;
              }
              j++;
              
        }
       
        return ans;
        
    }
};