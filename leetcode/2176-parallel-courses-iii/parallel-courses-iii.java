class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {

        int[] ind = new int[n+1];
        Map<Integer,List<Integer>> mp = new HashMap<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));

        for(int[] e : relations){
            int a = e[0];
            int b = e[1];
            ind[b]++;
            mp.computeIfAbsent(a,k-> new ArrayList<Integer>()).add(b);
           
        }
        int ans = 0;
        for(int e = 1 ; e <= n ; e++){
             if(ind[e] == 0){
                 pq.offer(new int[]{e,time[e-1]});
             }
        }
         
         while(pq.size() > 0){
                
                int[] top = pq.poll();
                ans = Math.max(ans,top[1]);

                for(int x :mp.getOrDefault(top[0], new ArrayList<>())){
                      ind[x]--;
                      if(ind[x] == 0){
                          pq.offer(new int[]{x,time[x-1]+top[1]});
                      }
                }
         }
         return ans;
        
    }
}