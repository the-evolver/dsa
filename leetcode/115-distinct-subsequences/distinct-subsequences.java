// class Solution {
//     int ans = 0;

//     public int numDistinct(String s, String t) {
       
//         solve(s, 0, new StringBuilder(), t);
//         return ans;
//     }

//     public void solve(String s, int i, StringBuilder curr, String t) {
        // if (i == s.length()) {
        //     if (t.equals(curr.toString())) {
        //         ans++;
        //     }
        //     return;
        // }
        
        // if(curr.length() > t.length()) return;

        // String temp = curr.toString();

        // for(int j = 0 ; j < temp.length();j++){
        //      if(temp.charAt(j) != t.charAt(j))
        //         return;
        // }

        // solve(s, i + 1, curr, t);

        // curr.append(s.charAt(i));
        // solve(s, i + 1, curr, t);
        // curr.deleteCharAt(curr.length() - 1);

        // state => string i se change ho rha and target is built
        // dp[string actual][target] 

        

//     }
// }

// state => [curr ko dp me dalke]

class Solution {
    Long[][] dp;

    public int numDistinct(String s, String t) {
        dp = new Long[s.length()][t.length()];
        return (int) solve(s, t, 0, 0);
    }

    private long solve(String s, String t, int i, int j) {

        if (j == t.length())
            return 1;      // formed t

        if (i == s.length())
            return 0;      // s exhausted

        if (dp[i][j] != null)
            return dp[i][j];

        long ans;

        if (s.charAt(i) == t.charAt(j)) {
            ans = solve(s, t, i + 1, j + 1) +
                  solve(s, t, i + 1, j);
        } else {
            ans = solve(s, t, i + 1, j);
        }

        return dp[i][j] = ans;
    }
}
