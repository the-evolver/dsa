// Budget: n = 2*10^4 → need O(n or nlogn at max); max values: 1000 → types: int is satisfied as max 2*10^4*10^3 < 10^9
// Brute force: o(n2)  → O(n2), too slow because (2*10^4)^2 => >= 10^8 means 
// Idea + why it's correct: we need to solve it in o(n) so we need solve it using some calculation..

class Solution {
    public int subarraySum(int[] nums, int k) {
         
         int cnt = 0;
         Map<Integer,Integer> mp = new HashMap<>();
         mp.put(0,1);
         int currSum = 0;

         for(int x : nums){
             currSum += x;
             cnt += mp.getOrDefault(currSum-k,0);
             mp.merge(currSum,1,Integer::sum);
         }

         return cnt;
    }
}