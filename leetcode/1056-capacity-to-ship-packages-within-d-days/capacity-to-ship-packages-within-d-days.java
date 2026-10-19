class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int tw = 0;
        for(int w : weights) tw+=w;
        int lo = 1 ,hi = tw , mid;
        int ans = tw;
        while(lo <= hi){
             mid = hi - ((hi - lo)/2);
             boolean valid = isValid(weights,mid,days);
             if(valid){
                ans = Math.min(ans,mid);
                hi = mid-1;
             }else
               lo = mid+1;

        }
        return ans;


        
    }
    public boolean isValid(int[] w , int l , int days){
          int d =1;
          int curr = 0;
          int i = 0;

          while(i < w.length){
                 if(d > days) return false;
                 if(curr + w[i] <= l){
                     curr += w[i++];
                     
                 }else{
                    curr = 0;
                    d++;

                 }
                
          }
          return d <= days ? true : false;
    }
}