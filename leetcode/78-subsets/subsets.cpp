class Solution {
public:
    set<vector<int>> st;
    vector<vector<int>> subsets(vector<int>& nums) {
         solve(nums,0,{});
         vector<vector<int>> ans;
         for(auto it : st){
            ans.push_back(it);
         }
        return ans;
    }

    void solve(vector<int>& nums,int i,vector<int> curr){
        if(i == nums.size()){
            st.insert(curr);
            return;
        }

        // two option either current element will be set either it will be not

        solve(nums,i+1,curr);
        curr.push_back(nums[i]);
        solve(nums,i+1,curr);
        curr.pop_back();

        return;
    }
};