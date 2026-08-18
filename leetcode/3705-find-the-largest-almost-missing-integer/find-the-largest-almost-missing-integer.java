class Solution {
    public int largestInteger(int[] nums, int k) {
        Map<Integer, Integer> cnt = new HashMap<>();

        for (int i = 0; i <= nums.length - k; i++) {
            Set<Integer> st = new HashSet<>();

            int j = i;
            while (j < i + k) {
                if (st.contains(nums[j])) {
                    j++;
                    continue;
                }

                st.add(nums[j]);
                cnt.merge(nums[j], 1, Integer::sum);
                j++;
            }
        }

        int maxi = Integer.MIN_VALUE;

        for (Map.Entry<Integer, Integer> it : cnt.entrySet()) {
            if (it.getValue() == 1) {
                maxi = Math.max(maxi, it.getKey());
            }
        }

        return maxi == Integer.MIN_VALUE ? -1 : maxi;
    }
}