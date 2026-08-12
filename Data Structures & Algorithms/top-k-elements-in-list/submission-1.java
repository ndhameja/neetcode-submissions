class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer,Integer> map = new HashMap<>();

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((a,b)->
        b.getValue()-a.getValue());

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        pq.addAll(map.entrySet());
        
        for(int i=0;i<k;i++){
            res[i] = pq.poll().getKey();
        }
        return res;
    }
}
