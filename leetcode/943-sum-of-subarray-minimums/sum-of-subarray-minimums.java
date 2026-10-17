class Solution {
    public void precompute(int[] p, int[] n , int[] arr){
        Arrays.fill(p,-1);
        Arrays.fill(n,arr.length);

        Deque<Integer> qu = new ArrayDeque<>();
        for(int i = 0 ; i < arr.length ; i++){
              if(i == 0) qu.push(i);
              else{
                  while(qu.size() > 0 && arr[qu.peek()] > arr[i]){
                         n[qu.peek()] = i;
                         qu.pop();
                  }
                  qu.push(i);
              }
        }
         qu.clear();
        for(int i = arr.length-1 ; i >= 0 ; i--){
              if(i == arr.length-1) qu.push(i);
              else{
                  while(qu.size() > 0 && arr[qu.peek()] >= arr[i]){
                         p[qu.peek()] = i;
                         qu.pop();
                  }
                  qu.push(i);
              }
        }

    }
    public int sumSubarrayMins(int[] arr) {

        int ans = 0;
        int m = 1000000000+7;
        int[] prevSmaller = new int[arr.length];
        int[] nextSmaller = new int[arr.length];

        precompute(prevSmaller,nextSmaller,arr);

        for(int i = 0 ; i < arr.length ; i++){
             long curr = (((long)arr[i]) * ((long)i - prevSmaller[i]) * ((long)nextSmaller[i] - i));
             ans = (int)((ans + curr) % m);
        }
        return ans;
    }
}