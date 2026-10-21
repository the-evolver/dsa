class Solution {
    public int subarraySum(int[] nums, int k) {

        int ans = 0;
        Map<Integer,Integer>mp = new HashMap<>();
        mp.put(0,1);
        int currS = 0 ;
        for(int i : nums){
             currS += i;
             ans += mp.getOrDefault(currS-k,0);
             mp.merge(currS,1,Integer::sum);
        }
        return ans;
    }
}