class KthLargest {
    private final PriorityQueue<Integer> minHeap;
    private final int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.minHeap= new PriorityQueue<>(k);
        //for(int num:nums){

        //}
        Arrays.stream(nums).forEach(this::add);
    }
    
    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.offer(val);
        }
        else if (val > minHeap.peek()) {
            minHeap.poll(); // Evict the smallest of the top k
            minHeap.offer(val); // Insert the new element
        }
        return minHeap.peek();
    }
}
