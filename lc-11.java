class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int maxa = 0;
        int ml = l, mr = r;
        while(l < r) {
            int a = Math.min(height[l], height[r]) * (r-l);
            if(a > maxa) maxa = a;
            if(height[l]>height[r]) {
                r--;
            }else{
                l++;
            }
        }
        return maxa;
    }
}