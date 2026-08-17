class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String,List<String>> mp = new HashMap<>();
        for(String str : strs){
            String keyStr = str;
            char[] keyArr = str.toCharArray();
            Arrays.sort(keyArr);
            String sortedKeyStr = new String(keyArr);

            mp.computeIfAbsent(sortedKeyStr, k -> new ArrayList<>()).add(str);
        }
        List<List<String>> ls = new ArrayList<>(mp.values());
        return ls;
        
    }
}