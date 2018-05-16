class Solution {
    public int[] searchRange(int[] nums, int target) {
        //先二分查找
        //注意细节
        int ti = binarySearch(nums, target);
        //System.out.println(ti);
        if(ti == -1) {
            return new int[]{-1, -1};
        }else{
            int l = ti;
            int r = ti;
            while(l-1>=0) {
                if(nums[l-1] != nums[ti]) {
                    break;
                }else{
                    l--;
                }
            }
            while(r+1<nums.length) {
                if(nums[r+1] != nums[ti]) break;
                else r++;
            }
            l = l>=0?l:0;
            r = r<nums.length?r:r-1;
            return new int[]{l, r};
        }
    }
    private int binarySearch(int[] nums, int t) {
        int resi = -1;
        int low = 0, high = nums.length-1;
        while(low <= high) { //终止条件
            int mid = low + (high-low)/2; //中位数的求法
            
            //之后就好做了
            if(nums[mid] > t) high = mid - 1;
            if(nums[mid] < t) low = mid + 1;
            if(nums[mid] == t) {
                resi = mid;
                break;
            }
        }
        return resi;
    }
}