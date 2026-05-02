class Solution {
public:
    int rotatedDigits(int n) {

        // 2 5 6 9
        // 0 1 8
        // 3 4 7 
         
         int cnt = 0;
         for(int i =  1 ; i <= n; i++) cnt += checkNum(i) == true ? 1 : 0;

        return cnt;
    }

    bool checkNum(int x){
         int diffR = 0 , sameR = 0 , fraudR = 0;
         while(x){
             int d =  x % 10;
             x /= 10;
             if(d == 2 || d == 5 || d == 6 || d == 9) diffR++;
             else if(d == 0 || d == 1 || d == 8 )     sameR++;
             else fraudR++;

             if(fraudR > 0) return false;
             
         }
         return diffR == 0 ? false : true;
    }
};