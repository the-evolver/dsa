class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {

        int compo = 0;
        int row = grid.size() , col = grid[0].size();
        vector<vector<bool>> vis(row,vector<bool>(col,false));
        for(int i = 0 ; i < row;i++){
            for(int j = 0; j < col ; j++){
                 if(grid[i][j] == '1' && vis[i][j] == false){
                    compo++;
                    dfs(grid,vis,i,j,row,col);
                 }
            }
        }

         return compo;       
    }

    void dfs(vector<vector<char>>& grid , vector<vector<bool>>& vis , int i , int j,int row, int col){
          if(i < 0 || i == row || j < 0 || j == col || grid[i][j] == '0' || vis[i][j] == true)
              return;

          vis[i][j] = true;

          dfs(grid,vis,i-1,j,row,col);
          dfs(grid,vis,i+1,j,row,col);
          dfs(grid,vis,i,j-1,row,col);
          dfs(grid,vis,i,j+1,row,col);

          return;
    }
};