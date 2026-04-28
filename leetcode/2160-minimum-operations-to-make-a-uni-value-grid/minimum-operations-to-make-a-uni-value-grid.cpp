class Solution {
public:
    int minOperations(vector<vector<int>>& grid, int x) {

        vector<int> arr;

        for(int i = 0 ; i < grid.size();i++){
            for(int j = 0 ; j < grid[0].size();j++){
                  arr.push_back(grid[i][j]);
            }
        }

        sort(arr.begin(),arr.end());
        int i = arr.size()/2;
      
        int op = 0;
        for(int j = 0 ; j < arr.size();j++){
               int val = abs(arr[j]-arr[i]);
               if(val % x == 0) 
                     op += val/x;
               else  return -1;
        }
        return op;
        
    }
};