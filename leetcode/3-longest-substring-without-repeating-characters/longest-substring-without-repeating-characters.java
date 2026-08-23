/*
constraints = 10^5 .. so we need to solve in less than o(n2)
and two pointer way sounds good here .. use map to manage count and use two pointer to iterate the string and caluculate the solution
tc => o(n) sc =o(n)
*/
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