class Solution {
    public int minOperations(int[] nums, int x) {

        int maxi = Integer.MIN_VALUE;
        int tsum = 0;
        for(int i : nums) tsum +=i;

        int rsum = tsum-x;
        int curr = 0;

        int l = -1,r=0;
        while(r < nums.length){
               curr += nums[r];
               if(curr == rsum) maxi = Math.max(maxi,r-l);
               while(l <r && curr > rsum) curr-= nums[++l];
                if(curr == rsum) maxi = Math.max(maxi,r-l);
               r++;
        }
        
        return maxi == Integer.MIN_VALUE ? -1 : nums.length - maxi;
    }
}