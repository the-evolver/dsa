class Solution {
    //Integer[] dp;
    public int numDecodings(String s) {

        // dp = new Integer[s.length()];
        // return solve(s.toCharArray(),0);

        // Iterative way

        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        char[] str = s.toCharArray();
        for(int i = str.length - 1 ; i >= 0 ;i--){

             if(str[i] == '0') continue;
             dp[i] +=  dp[i+1];

             if(i+1 < str.length){
                 int ifTwoDig = (str[i] - '0') * 10 + (str[i+1] - '0');

                 if(ifTwoDig <= 26)
                    dp[i] += dp[i+2];
             } 
        }
          
          return dp[0];
        
    }

    // public int solve(char[] arr,int i){
    //     if(i == arr.length) return 1 ; // because we reached end while decoding so whole process is 1 way of decoding
    //     if(arr[i] == '0') return 0; // not possible saar
        
    //     if(dp[i] != null) return dp[i]; // already calculated the amswer sarrr

    //     int ways = solve(arr,i+1); // one digit way .. no 0 here so it can be acted as a digit

    //     if(i + 1 < arr.length){
    //          int num = (arr[i] - '0')*10 + (arr[i+1] - '0');
    //          if(num <= 26) ways += solve(arr,i+2);
    //     }
        
    //     return dp[i] = ways;
    // }
}