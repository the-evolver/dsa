class Solution {
    public String largestNumber(int[] nums) {

        // basically we need to sort in descending plus specific check order to maintain max integer possible 

        String[] ns = new String[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            ns[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(ns,(str1,str2) -> {
             return (str2 + str1).compareTo(str1 + str2);
             }
            );
            if(ns[0].charAt(0) == '0') return "0";

        StringBuilder sb = new StringBuilder();
        for(String s : ns){
            sb.append(s);
        }
        return sb.toString();
        
    }
}