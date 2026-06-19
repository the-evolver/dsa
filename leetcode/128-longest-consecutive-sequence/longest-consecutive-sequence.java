class Solution {
    public int longestConsecutive(int[] nums) {

        // for passing in o(n) we need to cnt the largest consecutive elements till i in the array when at i so that at n-1 we have the answer ...

        // any number x can contribute in two ways either it has neighbours else 1 if neighbours x will contribute like lce(x-1) + 1 + lce(x+1)
        // also we dont need to update the whole interval because at the 
        // end we need only interval end values because mid interval will have counted result so bigger result can come from intervals outside valuse which will need the intervals end valuse to calculate..

        HashMap<Integer,Integer> hm = new HashMap<>();
        int maxL = 0;
        for(int num : nums){
            if(hm.containsKey(num)) continue;

            int left = hm.getOrDefault(num-1,0);
            int right = hm.getOrDefault(num+1,0);

            int newV = left + 1 + right;
            maxL = maxL < newV ? newV : maxL;
            hm.put(num-left,newV);
            hm.put(num+right,newV);
            hm.put(num,newV);
        }
        return maxL;
    }
}