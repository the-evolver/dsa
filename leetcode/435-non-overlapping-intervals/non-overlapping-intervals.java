/*
Among the intervals that are still available, my greedy keeps A, the one that ends earliest.
Suppose the best possible answer keeps some other interval X at that spot instead.
A ends ___ X ends.
So anything that came after X without overlapping it also comes after A without ___.
So I can swap X for A, and the answer is still valid and still keeps ___ intervals.
So choosing A never makes things worse, and keeping the most intervals means removing the ___.
*/
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
               if(intervals[i][0] < intervals[j][1]) cnt++;
               else j = i;
               
               i++;
              
        }
        return cnt;
    }
}