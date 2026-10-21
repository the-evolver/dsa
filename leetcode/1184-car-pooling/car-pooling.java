// Budget: n = 10^3 , locations up to 10^3 → need O(n2 works)
// Biggest intermediate value = 100 * 10^3 → type int satifies
// Brute force: store the max number of passengers in call at position x  → O(n2), too slow but works here
// Idea + why it's correct: it is correct as we check for each position
// Edge cases I tested: 1) [[3,5,9],[4,2,5],[3,4,6],[9,1,4],[5,6,8],[5,4,6]] 14 2) [[2,1,5],[3,5,7]] 3
// Verdict: paseed   Time: 30 mins but i am not happy with this pproach

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        // int[] jc = new int[1001];
        // for(int[] x : trips){
        //      for(int i = x[1]; i < x[2] ;i++){
        //           jc[i] += x[0];
        //           if(jc[i] > capacity) return false;
        //      }
        // }
        // return true;
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