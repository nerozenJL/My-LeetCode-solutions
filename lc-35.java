class Solution {
    public int searchInsert(int[] nums, int target) {
        for(int i = 0; i<nums.length; i++) {
            if(nums[i] >= target) return i;
        }
        return nums.length;
    }
}

/*

lc-35 有序数组求插入位置，更快可以用二分来找，记得重新做一下

*/