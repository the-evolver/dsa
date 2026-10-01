class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> st = new HashSet<>();
        for(int i:nums){
            st.add(i);
        }
        for(int i = 1 ; i <= Integer.MAX_VALUE;i++){
               if(st.contains(i) == false) return i;
        }

        return 0;
        // impossible
    }
}