// Budget: n = 3000 → need O(n2 at max)
// Biggest intermediate value = 3*10^5 → type int
// Brute force: find all such triplets using three pointer iteration k = j+1,j=i+1 nad i 0..n-2 → O(n3), too slow because because it takes more than 10^9 mopertation in wc..
// Idea + why it's correct: we dont need the order we need triplets if we fix one pointer then its two pointer find with - nums[i] as target and that we can do in o(n)  (why does moving a pointer never skip a valid triplet?) => because we check for all avalaible triplet ..
// Edge cases I tested: 1) [-1,0,1,2,-1,-4]  2) [0,1,1]
// Verdict: paseed   Time:12 minutes
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
       
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0 ; i < nums.length ; i++){
              if(i > 0 && nums[i] == nums[i-1]) continue;
              int j = i + 1 ,  k = nums.length - 1;
              while(j < k){
                    int sum = nums[i] + nums[j] + nums[k] ;
                    if(sum == 0){
                        ans.add(List.of(nums[i],nums[j],nums[k]));

                        do{
                            j++;
                        }while(j+1 < k && nums[j] == nums[j-1] );
                        do{
                            k--;
                        } while(k-1 > j && nums[k] == nums[k+1]);

                    }else if (sum > 0)k--;
                    else j++;
              }
        }

       
        return ans;
        
    }
}