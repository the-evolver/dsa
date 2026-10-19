class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0;
        int rotten = 0;
        Deque<int[]> dq = new ArrayDeque<int[]>();
        int ans = 0;
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for(int i = 0 ; i < grid.length ; i++){
             for(int j = 0 ; j < grid[i].length ; j++){
                   if(grid[i][j] == 1) fresh++;
                   if(grid[i][j] == 2){
                        rotten++;
                        dq.offer(new int[]{i,j,0});
                        vis[i][j] = true;
                   }


             }

        }

        while(dq.size() > 0){
               int[] top = dq.poll();
               int currT = top[2];
               ans = Math.max(ans,currT);
               int justRotten = bfs(top[0],top[1],vis,grid,dq,currT+1);
               fresh -= justRotten;
        }

        return fresh == 0 ? ans: -1;
    }

    public int bfs(int i,int j,boolean[][] vis,int[][] grid,Deque<int[]> dq,int t){
         int rotten = 0;
         if(i+1 < grid.length && vis[i+1][j] == false && grid[i+1][j] == 1){
              dq.offer(new int[]{i+1,j,t});
              vis[i+1][j] = true;
              rotten++;
         }
         if(i-1 >= 0 && vis[i-1][j] == false && grid[i-1][j] == 1){
              dq.offer(new int[]{i-1,j,t});
               vis[i-1][j] = true;
              rotten++;
         }
         if(j+1 < grid[0].length && vis[i][j+1] == false && grid[i][j+1] == 1){
              dq.offer(new int[]{i,j+1,t});
               vis[i][j+1] = true;
              rotten++;
         }
         if(j-1 >= 0 && vis[i][j-1] == false && grid[i][j-1] == 1){
              dq.offer(new int[]{i,j-1,t});
               vis[i][j-1] = true;
              rotten++;
         }

         return rotten;
    }
}