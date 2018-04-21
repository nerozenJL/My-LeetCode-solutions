/*
*Solution的某条评论
*遍历数组，找到第一个大于后一个数的数的位置，其位置即为pos;
*分别判断当nums[pos]=nums[pos-1]时和nums[pos]=nums[pos+1]时，数组是否有序
*若其中任一种情况有序，则返回true，否则返回false
*/
class Solution {
    public boolean checkPossibility(int[] nums) {
        //看最大最小值是否在边界，如果同时不在边界，则失败
        //非最值的拐点个数
        boolean modify = false;
        for(int i = 0; i<nums.length-1; i++) {
            if(nums[i]>nums[i+1]) {
                int temp = nums[i];
                nums[i] = nums[i+1];
                boolean a1 = check(nums);
                nums[i] = temp;
                nums[i+1] = nums[i];
                boolean a2 =check(nums);
                return a1 || a2;
            }
        }
        return true;
    }
    private boolean check(int[] nums) {
        for(int i = 0; i<nums.length-1; i++) {
            if(nums[i]>nums[i+1])return false;
        }
        return true;
    }
}