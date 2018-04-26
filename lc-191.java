public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int num = 0;
        //if(n<0)num++;
        while(n!=0) {
            if((n & 1) == 1) num++; //注意 == 优先级 比 & 大，因此要加括号
            n=n>>>1;
        }
        return num;
    }
}