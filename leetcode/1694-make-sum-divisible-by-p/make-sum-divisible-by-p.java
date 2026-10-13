class Solution {
    public int minSubarray(int[] nums, int p) {

        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,-1);

        int currSum = 0;
        
        for(int i : nums){
            currSum = (currSum + i) % p;
        }

        int tarRem = currSum % p;

        if(tarRem == 0) return 0;
        int currRem;
        currSum = 0;
        int ans = nums.length;
        for(int i = 0 ; i < nums.length ; i++){
            //  currSum += nums[i];
            //  currRem = (currSum) % p;
             currSum = (currSum + nums[i]) % p;
             currRem = (currSum) % p;
             int req = (currRem-tarRem + p) % p;

             if(mp.containsKey(req)){
                  int j = mp.get(req);
                  ans = Math.min(ans,i-j);
             }
             mp.put(currRem,i);
        }

        return ans == nums.length ? -1 : ans;
        
    }
}