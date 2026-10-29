class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<List<Integer>> arr = new ArrayList<>();
        List<Integer> a = new ArrayList<>();

        for (int[] x : intervals) {
         arr.add(new ArrayList<>(List.of(x[0], x[1])));
        }

        arr.add(new ArrayList<>(List.of(newInterval[0], newInterval[1])));

       
    
        Collections.sort(arr,(a1,b1) -> Integer.compare(a1.get(0),b1.get(0)));
        
        // merge OverLapp
        for(int i = 1 ; i < arr.size();){
              int s1 = arr.get(i-1).get(0) , e1 = arr.get(i-1).get(1);
              int s2 = arr.get(i).get(0) , e2 = arr.get(i).get(1);

              if(s2 > e1)i++;
              else{
                    
                    arr.set(i,new ArrayList<>(List.of(s1, Math.max(e1,e2))));
                    arr.remove(i-1);
                  
                    
              }


        }

        int[][] ans = arr.stream()
        .map(row -> row.stream().mapToInt(Integer::intValue).toArray())
        .toArray(int[][]::new);
        
        return ans;
        
    }
}