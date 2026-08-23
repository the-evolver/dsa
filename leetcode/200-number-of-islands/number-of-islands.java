class Solution {
    public int numIslands(char[][] grid) {

        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int cnt = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length; j++){
                 if(grid[i][j] == '1' && vis[i][j] == false){
                    cnt++;
                    dfs(grid,vis,i,j);
                 }
            }
        }
        return cnt;
        
    }

    public void dfs(char[][] grid,boolean[][] vis,int i,int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || vis[i][j] == true || grid[i][j] == '0')
            return;

        vis[i][j] = true;
        dfs(grid,vis,i-1,j);
        dfs(grid,vis,i+1,j);
        dfs(grid,vis,i,j-1);
        dfs(grid,vis,i,j+1);
    }
}