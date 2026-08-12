class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        helper(result, new ArrayList<>(), nums,0 );
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> currentSubset, int[] nums, int start) {
        result.add(new ArrayList<> (currentSubset));
        for (int i = start; i < nums.length; i++) {
            currentSubset.add(nums[i]);
            helper(result, currentSubset, nums, i+1);
            currentSubset.remove(currentSubset.size() - 1);
        }
    }
}
