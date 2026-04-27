class Solution {
public:
        vector<int> dx = {-1, 1, 0, 0};
        vector<int> dy = {0, 0, -1, 1};
        vector<vector<int>> opens = {
            {},         
            {2, 3},     
            {0, 1},   
            {2, 1},     
            {1, 3},     
            {2, 0},    
            {0, 3}      
        };

         vector<int> opposite = {1, 0, 3, 2};  
            
    bool hasValidPath(vector<vector<int>>& grid) {

        int row = grid.size() , col = grid[0].size();
        vector<vector<bool>> vis(row,vector<bool>(col,false));
        return dfs(0,0,row,col,vis,grid);
        
    }
    bool dfs(int i, int j, int r, int c,vector<vector<bool>>& vis, vector<vector<int>>& grid) {
    
            if (i < 0 || i >= r || j < 0 || j >= c) return false;
            if (vis[i][j]) return false;
            if (i == r-1 && j == c-1) return true;
            
            vis[i][j] = true;  

            for (int dir : opens[grid[i][j]]) {
                int ni = i + dx[dir];
                int nj = j + dy[dir];
                
                if (ni < 0 || ni >= r || nj < 0 || nj >= c) continue;

               
                int need = opposite[dir];
                vector<int>& neighborDirs = opens[grid[ni][nj]];
                
                if (find(neighborDirs.begin(), neighborDirs.end(), need) 
                    != neighborDirs.end()) {
                    if (dfs(ni, nj, r, c, vis, grid)) return true;
                }
            }
            return false;
}
    // bool callLeft(int i , int j , int r , int c , vector<vector<bool>>& vis ,vector<vector<int>>& grid){
    //      if(j - 1 < 0 || travelValid(i,j,i,j-1,grid) == false) return false;
    //      return dfs(i,j-1,r,c,vis,grid);
    // }
    // bool callRight(int i , int j , int r , int c , vector<vector<bool>>& vis ,vector<vector<int>>& grid){
    //     if(j + 1 >= c || travelValid(i,j,i,j+1,grid) == false) return false;
    //     return dfs(i,j+1,r,c,vis,grid);
    // }
    // bool callUp(int i , int j , int r , int c , vector<vector<bool>>& vis ,vector<vector<int>>& grid){
    //     if(i - 1 < 0 || travelValid(i,j,i-1,j,grid) == false) return false;
    //     return dfs(i-1,j,r,c,vis,grid);
    // }
    // bool callDown(int i , int j , int r , int c , vector<vector<bool>>& vis ,vector<vector<int>>& grid){
    //     if(i + 1 >= r || travelValid(i,j,i+1,j,grid) == false) return false;
    //     return dfs(i+1,j,r,c,vis,grid);
        
    // }

    // bool travelValid(int i1,int j1,int i2,int j2,vector<vector<int>>& grid){
    //      if(j1+1 == j2){
    //            if (grid[i1][j1] == 1 && (grid[i2][j2] == 1 || grid[i2][j2] == 3 ||grid[i2][j2] == 5)) return true;
    //            if (grid[i1][j1] == 4 && (grid[i2][j2] == 1 || grid[i2][j2] == 3 ||grid[i2][j2] == 5)) return true;
    //            if (grid[i1][j1] == 6 && (grid[i2][j2] == 1 || grid[i2][j2] == 3 ||grid[i2][j2] == 5)) return true;
    //      }
    //       if(j1-1 == j2){
    //            if (grid[i1][j1] == 1 && (grid[i2][j2] == 1 || grid[i2][j2] == 4 || grid[i2][j2] == 6)) return true;
    //            if (grid[i1][j1] == 3 && (grid[i2][j2] == 1 || grid[i2][j2] == 4 || grid[i2][j2] == 6)) return true;
    //            if (grid[i1][j1] == 5 && (grid[i2][j2] == 1 || grid[i2][j2] == 4 || grid[i2][j2] == 6)) return true;
    //      }
    //      if(i1+1 == i2){
    //            if (grid[i1][j1] == 2 && (grid[i2][j2] == 2 || grid[i2][j2] == 5 || grid[i2][j2] == 6)) return true;
    //            if (grid[i1][j1] == 3 && (grid[i2][j2] == 2 || grid[i2][j2] == 5 || grid[i2][j2] == 6)) return true;
    //            if (grid[i1][j1] == 4 && (grid[i2][j2] == 2 || grid[i2][j2] == 5 || grid[i2][j2] == 6)) return true;
    //      }
    //       if(i1-1 == i2){
    //            if (grid[i1][j1] == 2 && (grid[i2][j2] == 2 || grid[i2][j2] == 4 || grid[i2][j2] == 3)) return true;
    //            if (grid[i1][j1] == 5 && (grid[i2][j2] == 2 || grid[i2][j2] == 4 || grid[i2][j2] == 3)) return true;
    //            if (grid[i1][j1] == 6 && (grid[i2][j2] == 2 || grid[i2][j2] == 4 || grid[i2][j2] == 3)) return true;
    //      }
    //      return false;
    // }
};

/*            -1
       1 4 6   1 -> 1 3 5 
              -1
                    2 3 4
                -1  2   -1
                    2 5 6

                3 
*/