class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n  = nums.length;
        PriorityQueue<int[]> maxWindow = new PriorityQueue<>((a,b) -> Integer.compare(b[0],a[0]));
        int[] ans = new int[n-k+1];

        for(int i = 0 ; i < n ; i++){
             maxWindow.offer(new int[]{nums[i],i});
             if(i >= k - 1){
                  while(maxWindow.size() > 0 && ((i - k + 1) > maxWindow.peek()[1])) maxWindow.remove();
                  ans[i-(k-1)] = maxWindow.peek()[0];
             }
        }
        return ans;
    }
}