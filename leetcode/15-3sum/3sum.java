class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        Set<List<Integer>> st = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0 ; i < nums.length ; i++){
              if(i > 0 && nums[i] == nums[i-1]) continue;
              int j = i + 1 ,  k = nums.length - 1;
              while(j < k){
                    int sum = nums[i] + nums[j] + nums[k] ;
                    if(sum == 0){
                        st.add(List.of(nums[i],nums[j],nums[k]));
                        j++;k--;
                    }else if (sum > 0)k--;
                    else j++;
              }
        }

        for(List<Integer> l:st)ans.add(l);
        return ans;
        
    }
}