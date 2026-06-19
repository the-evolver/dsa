class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        

        // Solution 1 o(nlogn)
        // vector<pair<int,int>> pnums;
        // for(int i = 0; i < nums.size();i++){
        //     pnums.push_back({nums[i],i});
        // }

        // sort(pnums.begin(),pnums.end());

        // int i = 0 , j = pnums.size()-1;
        // while(i < j){
        //     int curr = pnums[i].first + pnums[j].first;
        //     if(curr == target){
        //         return {pnums[i].second,pnums[j].second};
        //     }else if(curr > target){
        //          j--;
        //     }else{
        //         i++;
        //     }
        // }
        // return {-1,-1}; // will never come here..

        // Solution 2

        unordered_map<int,int> ump;
        for(int i = 0 ; i < nums.size();i++){
             int curr = nums[i];
             if(ump.find(target-curr) != ump.end()){
                return {i,ump[target-curr]};
             }else{
                ump[curr] = i;
             }

        }
        return {-1,-1};


    }
};