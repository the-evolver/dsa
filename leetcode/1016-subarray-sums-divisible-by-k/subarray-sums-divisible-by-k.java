class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        int currSum = 0,currRem,ans=0;
        for(int i : nums){
            currSum += i;
            currRem = ((currSum % k ) + k ) % k;
            ans += mp.getOrDefault(currRem,0);
            mp.merge(currRem,1,Integer::sum);

        }
        return ans;
    }
}