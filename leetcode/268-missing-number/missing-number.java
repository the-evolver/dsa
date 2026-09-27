class Solution {
    public int missingNumber(int[] nums) {

        int sum = Arrays.stream(nums).reduce(0,Integer::sum);

        int n =  nums.length;
        int actualSum = ((n) * (n+1))/2;

        return actualSum - sum;
        
    }
}