class Solution {
    public int longestConsecutive(int[] nums) {

        Map<Integer,Integer> mp = new HashMap<>();
        int maxi = 0;

        for(int num : nums){
             if(mp.containsKey(num)) continue;

             int left = mp.getOrDefault(num-1,0);
             int right = mp.getOrDefault(num+1,0);

             mp.put(num,left + right + 1) ;
             mp.put(num-left,left + right + 1) ;
             mp.put(num+right,left + right + 1) ;
             
             maxi = Integer.max(maxi,mp.get(num));
        }
        return maxi;
    }
}