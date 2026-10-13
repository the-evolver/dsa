class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int[] ans = new int[nums.length];
        Arrays.fill(ans,1);

        int leftRunning = 1;
        for(int i = 0 ; i < nums.length;i++){
              ans[i] = leftRunning;
              leftRunning *= nums[i];
        }

        int rightRunning =  1;

        for(int i = nums.length-1 ; i >= 0 ;i--){
              ans[i] *= rightRunning;
              rightRunning *= nums[i];
        }
        return ans;
    }
}