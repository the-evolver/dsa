class Solution {
    public int findMaxLength(int[] nums) {

        Map<Integer,Integer> mp = new HashMap<>();
        int sum = 0;
        int ans = 0;
        for(int i = 0 ; i < nums.length;i++){
              
              sum += nums[i] == 1 ? 1 : -1;
              if(sum == 0) ans = Math.max(ans,i+1);
              else{
                 if(mp.containsKey(sum)){
                    int r = mp.get(sum);
                    ans = Math.max(i-r,ans);
                }
                else{
                    mp.put(sum,i);
                }
              }
              
        }
        return ans;
    }
}