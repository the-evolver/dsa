// Brute force => start for an index i and search for all j > i+1 that arr[i] + arr[j] == tar .. the timecomplexity is o(n2) which will fail as constraints are 10^4 .. so need to optimise .. and we can optimise the solution from o(n2) to o(nlog ) to o(n)
// o(nlogn) => use a pair array where firsr is value and second is index and sort it by value .. then use two pointer on sorted space ..

// o(n) == use map to store the values and when we get the complement return it ..
class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer,Integer> mp = new HashMap<>();
        for(int i = 0 ; i < nums.length ;i++){
             int compliment = target - nums[i];
             if(mp.containsKey(compliment)){
                return new int[]{i,mp.get(compliment)};
             }
             mp.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}