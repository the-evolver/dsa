class Solution {
  
    public int totalNumbers(int[] digits) {
        
         // way - 2 as search space is 100-999 just chekc for all numbers there which can be formed and count if they align
        int ans = 0;
       
        for(int i = 100 ; i <= 998 ; i+=2){
              if(canForm(i,digits) == true) ans++;
        }
        return ans;        
    }
    public boolean canForm(int i,int[] digits){
        int[] cnt = new int[10];
        for(int d : digits) cnt[d]++;
        
        while(i > 0){
           int rem = i % 10;
           if(cnt[rem] == 0) return false;
           i /= 10;
           cnt[rem]--;
        }
        return true;
    }
}

// // way - 1 generate all number and check for valid ones
        // boolean[] seen = new boolean[1000];
        // int[] dig = new int[10];
        // for(int d : digits) dig[d]++;

        // for(int i = 1 ; i <= 9 ;i++){
        //       if(dig[i] == 0) continue;

        //       int num = i * 100;
        //       dig[i]--;

        //       for(int j = 0 ; j <= 9 ;j++){
        //            if(dig[j] == 0) continue;
                   
        //            num = (i * 100) + (j * 10);
                  
        //            dig[j]--;
        //            for(int k = 0 ; k <= 9 ; k++){
        //              if(dig[k] == 0) continue;
                    
        //              num = (i * 100) + (j * 10) + k; 
                   
        //              seen[num] = true;
        //            }
        //            dig[j]++;
        //       }
        //       dig[i]++;

        // }
        // int ans = 0;
        // for(int i = 100 ; i <= 998 ;i +=2){
        //      if(seen[i]){
        //         ans++;
        //         System.out.println(i);
        //      }
        // }
        // return ans;

       