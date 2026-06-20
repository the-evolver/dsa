class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        // logic we will have a window with no duplicate chars .. like if i am at index i then the window is [j..i] longest window length ending at i
        // with no duplicates

        HashMap<Character,Integer> freq = new HashMap<>();
        char[] sarr = s.toCharArray();
        int j = 0 , i = 0;
        int maxL = 0;
        while(i < sarr.length){
               freq.merge(sarr[i],1,Integer::sum);
               while(freq.get(sarr[i]) > 1){
                  freq.merge(sarr[j],-1,Integer::sum);
                  j++;
               }
               maxL = Integer.max(maxL,i-j+1);
               i++;
        }
        return maxL;
        
    }
}