class Solution {
    public String minWindow(String s, String t) {

        Map<Character,Integer> tmap = new HashMap<>();
        Map<Character,Integer> smap = new HashMap<>();
        
        for(char c : t.toCharArray()){
              tmap.merge(c,1,Integer::sum);
        }
        
        int len = Integer.MAX_VALUE;
        String ans ="";
        int i = 0 , j = 0;
        
        while(j < s.length()){
              smap.merge(s.charAt(j),1,Integer::sum);
              while(checkMap(tmap,smap) == true){
                       if((j-i +1) < len){
                           len = j-i+1;
                           ans = s.substring(i,j+1);
                       }
                       smap.merge(s.charAt(i),-1,Integer::sum);
                       i++;
              }
              j++;
        }

        return ans;
    }

    public boolean checkMap(Map<Character,Integer> tmap,Map<Character,Integer>smap){
          for(Map.Entry<Character,Integer> e : tmap.entrySet()){
                Character k = e.getKey();
                Integer v = e.getValue();

                if(smap.getOrDefault(k,-1) < v ) return false;
          }
          return true;
    }
}