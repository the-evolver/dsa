class Solution {
    public boolean carPooling(int[][] trips, int capacity) {

        int[] jc = new int[1001];
        for(int[] x : trips){
             for(int i = x[1]; i < x[2] ;i++){
                  jc[i] += x[0];
                  if(jc[i] > capacity) return false;
             }
        }
        return true;
    }
}