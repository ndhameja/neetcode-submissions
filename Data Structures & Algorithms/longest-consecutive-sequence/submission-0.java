class Solution {
    public int longestConsecutive(int[] nums) {
        int maxResult =0;
        HashSet set = new HashSet<>();
        for(int num:nums)
            set.add(num);
        for(int num:nums){
            if(!set.contains(num-1)){
                int localMax=1;
                int init=num;
                while(set.contains(init+1)){
                    localMax++;
                    init++;
                }
                maxResult=Math.max(localMax,maxResult);
            }
        }
        return maxResult;
    }
}
