class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> ans = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0 ; i < nums.length ; i++){
              if( i > 0 && nums[i-1] == nums[i]) continue;

              int n1 = nums[i];
              int j = i+1,k = nums.length-1;
              while(j < k){
                     
                     int sum = nums[i] + nums[j] + nums[k];
                     if(sum == 0){
                          ans.add(new ArrayList<Integer>(List.of(nums[i],nums[j],nums[k])));
                          j++;k--;
                     }
                     else if (sum > 0){
                        k--;
                     }else j++;
              }
        }

        for(List<Integer> a: ans){
             res.add(a);
        }
        return res;
        
    }
}