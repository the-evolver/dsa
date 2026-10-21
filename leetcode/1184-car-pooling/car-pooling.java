class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

       
        Map<Integer,Integer> mp = new HashMap<>();
        int st = Integer.MAX_VALUE, en = Integer.MIN_VALUE;
        for(int[] t : trips){
              int c = t[0] , from = t[1] ,to=t[2];
              st = Math.min(st,from);
              en = Math.max(en,to);
              mp.merge(from,c,Integer::sum);
              mp.merge(to,-c,Integer::sum);
        }

        int runningCapacity = 0;
        for(int i = st ; i <= en ; i++){
              runningCapacity += mp.getOrDefault(i,0);
              if(runningCapacity > capacity) return false;
        }
        return true;
    }
}