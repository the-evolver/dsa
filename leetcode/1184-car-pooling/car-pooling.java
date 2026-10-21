class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

       
        Map<Integer,Integer> mp = new TreeMap<>();
     
        for(int[] t : trips){
              int c = t[0] , from = t[1] ,to=t[2];
              mp.merge(from,c,Integer::sum);
              mp.merge(to,-c,Integer::sum);
        }

        int runningCapacity = 0;
        for(Map.Entry<Integer,Integer> s : mp.entrySet()){
              runningCapacity += s.getValue();
              if(runningCapacity > capacity) return false;
        }
        return true;
    }
}