
class Solution {
    public int findMin(int[] nums) {

        int st = 0 , en = nums.length-1,mid;
        int ans = Integer.MAX_VALUE;

        while(st <= en){
                mid = (st + (en-st)/2);
                ans = Math.min(ans,nums[mid]);
                if(nums[en] > nums[mid])
                    en = mid-1;
                else
                   st = mid+1;
                
        }
        return ans;
    }
}