class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // basically the problem is of cycle detection in directed graph

        int[] inDegree = new int[numCourses];
        List<List<Integer>> dependents = IntStream.range(0,numCourses).
                                         mapToObj(i -> new ArrayList<Integer>()).
                                         collect(Collectors.toList());
        for(int[] c : prerequisites){
              inDegree[c[0]]++;
              dependents.get(c[1]).add(c[0]);
        }

        Queue<Integer> qu = new ArrayDeque<Integer>();
        for(int i = 0 ; i < numCourses;i++) if(inDegree[i] == 0) qu.offer(i);
        int cnt = 0;

        while(qu.size() > 0){
              int top = qu.poll();
              cnt++;
              for(int x : dependents.get(top)){
                  inDegree[x]--;
                  if(inDegree[x] == 0) qu.offer(x);
                   
              }
        }
        return cnt == numCourses;
    }
}