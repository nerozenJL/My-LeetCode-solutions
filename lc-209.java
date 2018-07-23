class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int i = 0;
        int sum = 0;
        while(i<nums.length) {
            if(nums[i]==s)return 1;
            sum += nums[i];
            if(sum>=s){
                break;
            }else{
                i++;
            }
        }
        if(sum<s) return 0;
        
        
        int min = i+1; //当前滑动窗口的大小
        int r = i+1; //下一个滑动窗口格
        int l = 0;//当前窗口左侧
        
        //先左调整，在右调整前保证滑动窗口已经是最小
        while(true) {
            if(sum-nums[l]<s)break;
            else {
                sum -= nums[l];
                l++;
                min--;
            }
        }
        
        //继续向右移动
        while(r<nums.length) {
            sum+=nums[r];
            while(true) {
                if(sum-nums[l]<s) break;
                else {
                    sum-=nums[l];
                    l++;
                }
            }
            min = Math.min(min, r-l+1);
            r++;
        }
        return min;
    }
}