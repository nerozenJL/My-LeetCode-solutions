class Solution {
    public int maxRotateFunction(int[] A) {
        if(A.length == 0)return 0;
        //n方的方法
        int max = Integer.MIN_VALUE;
        int last = 0;
        
        int sum = 0;
        for(int a : A) {
            sum+=a;
        }
        
        for(int i = 0; i<A.length; i++) {
            if(i == 0) {
                for(int j = 0; j<A.length; j++) {
                    last += A[j] * j;
                }
                if(last>max)max = last;
            }else {
                last = last - sum + A[i-1] * A.length; //总结规律得到
                max = Math.max(max, last);
            }
        }
        return max;
    }
}