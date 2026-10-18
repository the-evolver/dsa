class Solution {
    public int maxScore(int[] cardPoints, int k) {

        int tsum = 0;
        for(int i : cardPoints) tsum += i;
        if(k == cardPoints.length) return tsum;

        int l = -1,r= 0;
        int csum = 0;
        int ans = Integer.MIN_VALUE;
        while(r < cardPoints.length){
               csum += cardPoints[r];
               while((r-l) > cardPoints.length - k){
                      csum -= cardPoints[++l];
               }
               if((r-l) == cardPoints.length - k)
                    ans = Math.max(ans,tsum-csum);
               r++;
        }
        return ans;
    }
}