class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];

        computePrevAndNextSmaller(n,prevSmaller,nextSmaller,heights);

        int ans = 0;
        for(int i = 0 ; i < n ; i++){
             ans = Math.max(ans,(heights[i] * (nextSmaller[i] - prevSmaller[i]-1)));
        }

       return ans;
        
    }

    public void computePrevAndNextSmaller(int n,int[] prevSmaller,int[] nextSmaller,int[] heights){
        prevSmaller[0] = -1;
        nextSmaller[n-1] = n;

        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < n ; i++){
             if(dq.size() == 0) dq.push(i);
             else{
                  while(dq.size() > 0 && heights[dq.peek()] > heights[i]){
                         nextSmaller[dq.peek()] = i;
                         dq.pop();
                  }
                  dq.push(i);
             }
        }
        while(dq.size() > 0){
              nextSmaller[dq.peek()] = n;
              dq.poll();
        }
      
        for(int i = n-1; i >=0 ; i--){
             if(dq.size() == 0) dq.push(i);
             else{
                  while(dq.size() > 0 && heights[dq.peek()] > heights[i]){
                         prevSmaller[dq.peek()] = i;
                         dq.pop();
                  }
                  dq.push(i);
             }
        }

        while(dq.size() > 0){
             prevSmaller[dq.peek()] = -1;
              dq.poll();
        }
    }
}