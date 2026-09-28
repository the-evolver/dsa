class Solution {
    public int maxDepth(String s) {

        int nD = 0;
        
        Stack<Character> st = new Stack<>();

        for(char c: s.toCharArray()){
               if(c == '('){
                   st.push(c);
               }
               else if (c == ')' ){
                  st.pop();
               }
               else if(c == '+'||c == '-'||c == '*'|| c == '/'){
                  // do nothing
               }
               
                    nD = Math.max(nD,st.size());
               
        }
        nD = Math.max(nD,st.size());
        return nD;
        
    }
}