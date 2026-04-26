class Solution {
public:
    bool containsCycle(vector<vector<char>>& grid) {
        int row =  grid.size() , col = grid[0].size();
        vector<vector<bool>> vis(row,vector<bool>(col,false));

        for(int i = 0 ; i < row ;i++){
            for(int j = 0 ; j < col;j++){
                  if(vis[i][j] == false){
                       if(dfs(grid,i,j,-1,-1,row,col,vis))
                           return true;
                  }
            }
        }
        return false;
    }

    bool dfs(vector<vector<char>>& grid,int i , int j , int pi ,int pj,int row,int col,vector<vector<bool>>& vis){
          if(i >= row || i < 0 || j < 0 || j >= col) return false;
          if(pi != -1 && pj != -1 && grid[i][j] != grid[pi][pj] ) return false;
          if(vis[i][j] == true) return true;

          vis[i][j] = true;
          
          bool res = false;

          if(i + 1 != pi) res = res || dfs(grid,i+1,j,i,j,row,col,vis);
          if(i - 1 != pi) res = res || dfs(grid,i-1,j,i,j,row,col,vis);
          if(j + 1 != pj) res = res || dfs(grid,i,j+1,i,j,row,col,vis);
          if(j - 1 != pj) res = res || dfs(grid,i,j-1,i,j,row,col,vis);
          
          return res;
    }
};