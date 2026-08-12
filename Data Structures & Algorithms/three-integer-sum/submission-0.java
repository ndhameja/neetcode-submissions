class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){
            int left=i+1, right = nums.length-1;
            while(left<right){
                int sum =nums[i]+nums[left]+nums[right];
                if(sum==0){
                    result.add(Arrays.asList(nums[i],nums[right],nums[left]));
                } 
                if(sum>0){
                    right--;
                }else{
                    left++;
                }

            }
        }
        return new ArrayList(result);
    }
}
