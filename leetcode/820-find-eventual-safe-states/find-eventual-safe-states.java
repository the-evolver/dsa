class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        List<Integer> ans = new ArrayList<>();
        int[] outDegree = new int[graph.length];
        List<List<Integer>> ls = IntStream.range(0,graph.length).mapToObj(x -> new ArrayList<Integer>()).collect(Collectors.toList());
        
        for(int i = 0 ; i < graph.length;i++){
               outDegree[i] = graph[i].length;
               for(int j = 0; j < graph[i].length;j++){
                    ls.get(graph[i][j]).add(i);
               }
        }

        Queue<Integer> qu = new ArrayDeque<Integer>();
        for(int i = 0 ; i < outDegree.length;i++) if(outDegree[i] == 0) qu.offer(i);

        while(qu.size() > 0){
               int top = qu.poll();
               ans.add(top);

               for(int x : ls.get(top)){
                     outDegree[x]--;
                     if(outDegree[x] == 0) qu.offer(x);
               }

        }
        Collections.sort(ans,(a,b) -> Integer.compare(a,b));
        return ans;
    }
}