class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals,(a,b)->{
            if(a[1] != b[1]) return Integer.compare(a[1],b[1]);
            return Integer.compare(b[0],a[0]);
        });

        int cnt = 0;
        int j = 0;
        int i = 1;
        while(i < intervals.length){
               if((intervals[i][0] <= intervals[j][0])||(intervals[i][0] < intervals[j][1]))
                  cnt++;
               else{
                   j = i;

               }
                 
                 
               i++;
              
        }
        return cnt;
    }
}