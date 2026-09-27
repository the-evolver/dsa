class Solution {
    public int subarraySum(int[] nums, int k) {

        Map<Integer,Integer> mp = new HashMap<>();

        int currSum = 0;
        int ans = 0;
        mp.put(0,1);
        for(int x : nums){
              currSum += x;
              if(mp.containsKey(currSum - k)){
                 ans += mp.get(currSum-k);
              }

              mp.merge(currSum,1,Integer::sum);
        }
        return ans;
        
    }
}