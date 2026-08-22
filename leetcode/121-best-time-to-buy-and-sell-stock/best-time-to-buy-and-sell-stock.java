class Solution {
    public int maxProfit(int[] prices) {

        int runningMin = Integer.MAX_VALUE;
        int ans = 0;

        for(int x : prices){
            if( x < runningMin) runningMin = x;
            ans = Integer.max(ans,x - runningMin);
        }
        return ans;
    }
}