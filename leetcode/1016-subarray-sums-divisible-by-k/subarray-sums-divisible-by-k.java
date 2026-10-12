class Solution {
    public int subarraysDivByK(int[] nums, int k) {

        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        int sum = 0 , ans = 0,rem;

        for(int x : nums ){
             sum += x;
             rem = ((sum % k) + k ) % k;

             ans += mp.getOrDefault(rem,0);
             mp.merge(rem,1,Integer::sum);
        }
        return ans;
        
    }
}