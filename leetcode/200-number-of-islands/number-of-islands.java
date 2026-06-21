class Solution {
    public int numIslands(char[][] grid) {

        int row = grid.length , col = grid[0].length;
        boolean[][] vis = new boolean[row][col];

        int component = 0;
        for(int i = 0 ; i < row ; i++){
            for(int j = 0 ; j < col ; j++){
                if(grid[i][j] == '1' && vis[i][j] == false){
                    component++;
                    dfs(i,j,row,col,grid,vis);
                }
            }
        }
        return component;
        
    }

    public void dfs(int i, int j,int row,int col,char[][] grid,boolean[][] vis){
        if(i < 0 || i == row || j < 0 || j == col || grid[i][j] == '0' || vis[i][j] == true) return;

        vis[i][j] = true;
        dfs(i+1,j,row,col,grid,vis);
        dfs(i-1,j,row,col,grid,vis);
        dfs(i,j+1,row,col,grid,vis);
        dfs(i,j-1,row,col,grid,vis);

        return;
    }
}