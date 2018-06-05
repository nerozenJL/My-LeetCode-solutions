class Solution {
    //有一个很重要的点没看到，那就是运动必然是沿右方向顺序遍历的，而不是随意移动
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int accumlate = 0;
        int total = 0;
        int starti = 0;
        int sum = 0;
        for(int i = 0; i<gas.length; i++) {
            total += gas[i] - cost[i];
            
            //入站或死在半路
            if(sum<0) {
                sum = 0;
                starti = i;//这一步是最疑惑的，并不能理解为什么
            }
            
            //出站
            sum += gas[i] - cost[i];
        }
        return total >= 0?starti:-1;
    }
}