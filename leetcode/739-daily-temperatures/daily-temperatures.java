class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        Stack<Integer> st = new Stack<>();
        int[] ans = new int[temperatures.length];
        Arrays.fill(ans,0);
        for(int x = 0 ; x < temperatures.length ;x++ ){
              if(st.size() == 0) st.push(x);
              else{
                    while(st.size() > 0 && temperatures[x] > temperatures[st.peek()]){
                           int j = st.pop();
                          
                           ans[j] = x - j;
                    }
                    st.push(x);
              }
        }
        return ans;
        
    }
}