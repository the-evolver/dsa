// Budget: n = ___ → need O(___)
// Biggest intermediate value = ___ → type ___
// Brute force: ___ → O(___), too slow because ___
// Idea + why it's correct: ___   (state the invariant: what's always true about [lo, hi]?)
// Edge cases I tested: 1) ___  2) ___
// Verdict: ___   Time: ___
class Solution {
    public int search(int[] nums, int target) {

        int lo = 0 , hi = nums.length-1,mid;

        while(lo<= hi){
            mid = (lo+hi)/2;
            if(nums[mid] == target) return mid;
             if (nums[lo] <= nums[mid]) {
                if (target >= nums[lo] && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
           
            else {
                if (target > nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
           
        }
        
        return -1;
        
    }
}