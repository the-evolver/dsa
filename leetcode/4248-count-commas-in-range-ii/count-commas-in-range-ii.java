class Solution {
    public long countCommas(long n) {

        int t = inWhichRange(n);

        return solve(t,n);
        
    }
    public int inWhichRange(long n){
        int powTenCnt = 0;
        while(n > 0){
            n /= 10;
            powTenCnt++;
        }
        return powTenCnt-1;
    }
    public long solve(int t,long n){
        long ans = 0;

        if(t < 3){
            // nothing
        }
        else if( t < 6){
            ans = (n - 1000 + 1);
        }
        else if (t < 9){
            ans = (n - 1000000 + 1) * 2 + (999999 - 1000 + 1);
        }
        else if (t < 12){
            ans = (n - 1000000000 + 1) * 3 + (999999999 - 1000000 + 1) * 2 + (999999 - 1000 + 1); 
        }
        else if (t < 15){
            ans = (n - 1000000000000L + 1) * 4 +(999999999999L - 1000000000L + 1) * 3 + (999999999L - 1000000L + 1) * 2 + (999999L - 1000L + 1); 
        }
        else{
            ans = (n - 1000000000000000L + 1) * 5 +(999999999999999L - 1000000000000L + 1) * 4 +(999999999999L - 1000000000L + 1) * 3 + (999999999L - 1000000L + 1) * 2 + (999999 - 1000 + 1); 
        }
        return ans;
    }
}

// 1,000 => 1,000,000 => 1,000,000,000

// 0 - 999 => 0
// 1,000 - 999,999 => 999000
// 1,000,000 - 999,999,999 => 