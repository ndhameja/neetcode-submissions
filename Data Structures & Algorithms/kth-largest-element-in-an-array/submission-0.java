class Solution {
     PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int findKthLargest(int[] nums, int k) {
        for (int num : nums) {
            pq.offer(num);
            if(pq.size()>k)
                pq.poll();
        }
        return pq.peek();
    }
}
