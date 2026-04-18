class Solution {
public:
    int mirrorDistance(int n) {
      if(n < 10) return 0;

      int rev = reverse(n);
      return rev > n ? rev - n : n - rev ;
        
    }
    int reverse(int num){
        int x = 0;
        while(num){
            x *=10;
            x+= num % 10;
            num/=10;
        }
        return x;
    }
};