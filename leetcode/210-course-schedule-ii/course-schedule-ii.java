class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        int[] ind = new int[numCourses];
        List<List<Integer>> con = IntStream.range(0,numCourses).mapToObj(x-> new ArrayList<Integer>()).collect(Collectors.toList());
        int[] ans = new int[numCourses];
        for(int[] edge : prerequisites){
             ind[edge[0]]++;
             con.get(edge[1]).add(edge[0]);
        }        

        Queue<Integer> qu = new ArrayDeque<Integer>();
        for(int i  = 0 ; i < numCourses;i++) if(ind[i] == 0) qu.offer(i);

        int cnt = 0;
        while(qu.size() > 0){
            int top = qu.poll();
            ans[cnt++] = top;
            for(int x : con.get(top)){
                 ind[x]--;
                 if(ind[x] == 0) qu.offer(x);
            }
        }

        return cnt == numCourses ? ans : new int[]{};
    }
}