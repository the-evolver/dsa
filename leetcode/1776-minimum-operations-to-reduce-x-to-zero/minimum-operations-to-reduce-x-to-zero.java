class Solution {
    // if we try to find the total ways by selecting the ends then it will be 2^n worst case combo.. instead we can think like at the core when we find the value x by selecting some leftmost and rightmost then there will be a continuos window at mid and if we think of maximising this window then by default we will then ans by its compliment that is maximising window means minimising the the ends to select...
    public int minOperations(int[] nums, int x) {
      
        int tsum = 0;
        for(int a:nums) tsum+=a;
        if(x > tsum) return -1;
        int reqs =  tsum -x;
        int currS = 0;
        int l = 0 ,r = 0;

        int ans = Integer.MAX_VALUE;
        while(r < nums.length){
               currS += nums[r++];
               while(l < r && currS > reqs){
                   currS -= nums[l];
                   l++;
               }
               if(currS == reqs){
                   ans = Math.min(ans,l+nums.length-r);
               }

        }
         return ans == Integer.MAX_VALUE ? -1 :ans;

    }
}