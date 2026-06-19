class Solution {
    public int subarraySum(int[] nums, int k) {
        
      // Solution one o(n2) search all sub arrays and find sum of each ...

      // solution two o(n) .. any subarray which is equal to target can be represented specially
      // ... [a,b,c,d,e,f]  target = m
      // then lets say sum of a + b+c+d+e = t and there exists t - m sum in the map where we store continuos sum it means there is count of t-m subaaryas with sum m...

      HashMap<Integer,Integer> hm = new HashMap<>();

      int curr = 0;
      int cnt = 0;
      for(int i = 0 ; i < nums.length ; i++){
         curr += nums[i];
         if(hm.containsKey(curr-k)){
             cnt += hm.get(curr-k);
         }
         int val = hm.containsKey(curr) ? hm.get(curr):0;
         hm.put(curr,val + 1);
         cnt += curr == k ? 1 : 0;

      }
       return cnt;

    }
}