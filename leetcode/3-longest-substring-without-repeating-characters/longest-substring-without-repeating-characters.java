class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> mp  =  new HashMap<>();
        int i = 0 , j = 0 , ans = 0;
        char[] c = s.toCharArray();
        while( j < c.length){
               if(mp.containsKey(c[j])){
                   ans = Integer.max(ans,j-i);
                   i = Integer.max(i,mp.get(c[j]) + 1);
                   
               }
               mp.put(c[j],j);
               j++;
        }
        ans = Integer.max(ans,j-i);
        return ans;
        
    }
}