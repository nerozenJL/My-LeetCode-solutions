class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0)return 0;
        int maxcombo = 1;
        int combo = 1;
        for(int i = 0; i<nums.length-1; i++) {
            if(nums[i+1]>nums[i]) {
                combo++;
            }else{
                if(combo>maxcombo)maxcombo=combo;
                combo = 1;
            }
            if(i == nums.length-2 && combo>maxcombo) maxcombo=combo;
        }
        return maxcombo;
    }
}