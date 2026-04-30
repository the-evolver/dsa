class Solution {
public:
    int mini = INT_MIN;
    int maxPathScore(vector<vector<int>>& grid, int k) {
        //   int row = grid.size();
        //   int col = grid[0].size();
        //   vector<vector<bool>> vis(row,vector<bool>(col,false));
        //   dfs(0,0,row,col,k,grid,vis,0,0);

        //   return mini == INT_MIN ? -1 : mini;

        int row = grid.size();
        int col = grid[0].size();
        
        // dp[i][j][c] = max score reaching (i,j) with exactly cost c
        // -1 means unreachable
        vector<vector<vector<int>>> dp(row, vector<vector<int>>(col, vector<int>(k + 1, -1)));
        
        dp[0][0][0] = 0;  // start cell is always 0
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) continue;  // already set
                
                int cost  = (grid[i][j] == 0) ? 0 : 1;
                int score = grid[i][j];
                
                for (int c = cost; c <= k; c++) {
                    int best = -1;
                    
                    // came from above
                    if (i > 0 && dp[i-1][j][c - cost] != -1)
                        best = max(best, dp[i-1][j][c - cost]);
                    
                    // came from left
                    if (j > 0 && dp[i][j-1][c - cost] != -1)
                        best = max(best, dp[i][j-1][c - cost]);
                    
                    if (best != -1)
                        dp[i][j][c] = best + score;
                }
            }
        }
        
        int ans = -1;
        for (int c = 0; c <= k; c++) {
            if (dp[row-1][col-1][c] != -1)
                ans = max(ans, dp[row-1][col-1][c]);
        }
        return ans;
    }

    

    // void dfs(int i,int j , int row,int col,int k,vector<vector<int>>& grid,vector<vector<bool>>& vis , int currCost,int currScore){
    //        if(i < 0 || i == row || j < 0 || j == col || currCost > k) return;

    //        vis[i][j] = true;
    //        currCost  += grid[i][j] == 2 ? 1 : grid[i][j];
    //        currScore += grid[i][j];


    //        if(i == row-1 && j == col-1 && currCost <= k ){
    //            mini = max(mini,currScore);
    //            return;
    //        }
           
    //        dfs(i,j+1,row,col,k,grid,vis,currCost,currScore);
    //        dfs(i+1,j,row,col,k,grid,vis,currCost,currScore);

       
    //        return;


    // }
};