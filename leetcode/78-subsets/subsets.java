class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        solve(nums,0,results,path);

        return results;
        
    }

    private void solve(int[] nums,int i,List<List<Integer>> results,List<Integer> path){
           if(i == nums.length){
                results.add(new ArrayList<>(path));
                return;
           }

           solve(nums,i+1,results,path);
           path.add(nums[i]);
           solve(nums,i+1,results,path);
           path.remove(path.size()-1);
    }
}