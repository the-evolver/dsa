class Solution {
    public int maxArea(int[] height) {

        int ans = 0;
        
        int i = 0 , j = height.length - 1;
        int curr;
        while(i < j){
           curr = (j - i) * (height[j] > height[i] ? height[i++]:height[j--]);
           ans = ans > curr ? ans : curr;

        }
        return ans;
        
    }
}