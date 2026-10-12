class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) return new ArrayList<>(List.of(0));

        int[] inD = new int[n];
        Map<Integer,List<Integer>> mp = new HashMap<>();

        for(int[] x : edges){
              int a = x[0] , b =x[1];
              inD[a]++;inD[b]++;
              mp.computeIfAbsent(a,k-> new ArrayList<Integer>()).add(b);
              mp.computeIfAbsent(b,k-> new ArrayList<Integer>()).add(a);

        }

        int rem = n;
        Queue<Integer> qu = new ArrayDeque<>();

        for(int i = 0 ; i < n ; i++) if(inD[i] == 1)qu.offer(i);

        while(rem > 2){
                int remove = qu.size();
                rem -= remove;
                for(int i = 1 ; i <= remove;i++){
                     int top = qu.poll();
                     for(int num : mp.get(top)){
                        inD[num]--;
                        if(inD[num] == 1) qu.offer(num);
                     }
                }

        }
        
        List<Integer> ans = new ArrayList<>();
        while(qu.size() > 0){
            ans.add(qu.poll());
        }
        return ans;
    }
}