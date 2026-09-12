class Solution {
    public int totalNumbers(int[] digits) {
        

        boolean[] seen = new boolean[1000];
        int[] dig = new int[10];
        for(int d : digits) dig[d]++;

        for(int i = 1 ; i <= 9 ;i++){
              if(dig[i] == 0) continue;

              int num = i * 100;
              dig[i]--;

              for(int j = 0 ; j <= 9 ;j++){
                   if(dig[j] == 0) continue;
                   
                   num = (i * 100) + (j * 10);
                  
                   dig[j]--;
                   for(int k = 0 ; k <= 9 ; k++){
                     if(dig[k] == 0) continue;
                    
                     num = (i * 100) + (j * 10) + k; 
                   
                     seen[num] = true;
                   }
                   dig[j]++;
              }
              dig[i]++;

        }
        int ans = 0;
        for(int i = 100 ; i <= 998 ;i +=2){
             if(seen[i]){
                ans++;
                System.out.println(i);
             }
        }
        return ans;
    }
}