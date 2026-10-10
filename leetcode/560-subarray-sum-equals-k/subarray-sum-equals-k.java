class Solution {
    public int subarraySum(int[] nums, int k) {

        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        int ans = 0;
        int rsum = 0;
        for(int i : nums){
            rsum += i;
            ans += mp.getOrDefault(rsum-k,0);
            mp.merge(rsum,1,Integer::sum);
        }
        return ans;
        
    }
}