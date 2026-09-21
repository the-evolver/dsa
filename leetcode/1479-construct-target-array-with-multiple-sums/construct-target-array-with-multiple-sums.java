class Solution {
    public boolean isPossible(int[] target) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        long sum = 0;

        for (int num : target) {
            sum += num;
            maxHeap.offer(num);
        }

        while (true) {

            int top = maxHeap.poll();

            long rest = sum - top;

            if (top == 1 || rest == 1)
                return true;

            if (rest == 0 || top <= rest)
                return false;

            int prev = (int)(top % rest);

            if (prev == 0)
                return false;

            maxHeap.offer(prev);

            sum = rest + prev;
        }
    }
}