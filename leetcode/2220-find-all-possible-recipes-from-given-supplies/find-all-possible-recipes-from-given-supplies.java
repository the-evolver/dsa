class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {

        Map<String,Integer> inDeg = new HashMap<>();
        Map<String,List<String>> mp = new HashMap<>();
        Map<String,Integer> recp = new HashMap<>();

        for(String str : recipes) recp.put(str,1);

        for(int i = 0 ; i < ingredients.size();i++){
             String currR = recipes[i];
             for(String str : ingredients.get(i)){
                    // mp.merge(str,currR,() -> new ArrayList<String>());
                    mp.computeIfAbsent(str, k -> new ArrayList<>()).add(currR);
                    inDeg.merge(currR,1,Integer::sum);
             }

        }  

        Queue<String> qu = new ArrayDeque<>();
        for(String str : supplies) qu.offer(str);

        List<String> ans = new ArrayList<String>();

        while(qu.size() > 0){
            String supp = qu.poll();
            if(recp.containsKey(supp)) ans.add(supp);

            for(String str : mp.getOrDefault(supp, Collections.emptyList())){
                 inDeg.merge(str,-1,Integer::sum);
                 if(inDeg.get(str) == 0) qu.offer(str);
            }
        }


        return ans;
    }
}