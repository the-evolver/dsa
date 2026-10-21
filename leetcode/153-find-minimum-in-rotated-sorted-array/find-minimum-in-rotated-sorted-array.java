// Budget: n = ___ → need O(___)
// Biggest intermediate value = ___ → type ___
// Brute force: ___ → O(___), too slow because ___
// Idea + why it's correct: ___   (invariant / proof, not "it works")
// Edge cases I tested: 1) ___  2) ___
// Verdict: ___   Time: ___
class Solution {
    public int findMin(int[] nums) {

        int st = 0 , en = nums.length-1,mid;
        int ans = Integer.MAX_VALUE;

        while(st <= en){
                mid = (st + (en-st)/2);
                ans = Math.min(ans,nums[mid]);
                if(nums[mid] > nums[en])
                    st = mid+1;
                else
                   en = mid-1;
                
        }
        return ans;
    }
}