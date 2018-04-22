class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int tail1=m-1, tail2=n-1, writetail = n+m-1;
        //分别代表数组一队尾，数组二队尾，写入位置
        while(tail2>=0 && tail1>=0) {
            if(nums2[tail2]>nums1[tail1]) {
                nums1[writetail]=nums2[tail2];
                tail2--;
                writetail--;
            }else {
                nums1[writetail]=nums1[tail1];
                tail1--;
                writetail--;
            }
        }
        if(tail2>=0) {
            for(int i = 0; i<=tail2; i++) {
                nums1[i] = nums2[i];
            }
        }
    }
}