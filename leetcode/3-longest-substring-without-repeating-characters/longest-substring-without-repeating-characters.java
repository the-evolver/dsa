class Solution {
    public int lengthOfLongestSubstring(String s) {

        Map<Character,Integer> mp = new HashMap<>();
        int ans = 0;
        int i = 0 , j = 0;
        while(j < s.length()){
               char x = s.charAt(j);

               if(mp.containsKey(x)){
                     ans = Integer.max(ans,j-i);
                     i = Integer.max(i,mp.get(x)+1);
               }

               mp.put(x,j);
               j++;
        }
        ans = Integer.max(j-i,ans);
        return ans;
        
    }
}