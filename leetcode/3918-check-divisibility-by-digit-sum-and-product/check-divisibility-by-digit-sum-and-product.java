class Solution {
    public boolean checkDivisibility(int n) {

        int digSum = 0 ,digProd = 1;
        int temp = n;
        while(temp > 0){
            int d = temp % 10;
            temp /= 10;
            digSum += d;
            digProd *= d;
        }
      
        return ( n % (digSum + digProd)) == 0 ? true : false;
        
    }
}