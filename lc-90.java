class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList();
        helper(res, new ArrayList(), nums, 0);
        //res.add(new ArrayList());
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> comb, int[] nums, int i) {
        res.add(new ArrayList(comb));
        for(int j = i; j<nums.length; j++) {
            comb.add(nums[j]);
            helper(res, comb, nums, j+1);
            comb.remove(comb.size()-1);
            //helper(res, comb, nums, j+1);
            while(j<nums.length-1 && nums[j] == nums[j+1]) j++;
        }
    }
}