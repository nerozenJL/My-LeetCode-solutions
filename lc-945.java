/*
* 两个变量 need, moves
* moves 代表最终输出，改动次数
* 每个循环维护need，保证need不小于num
* need表示下一次改动要成为的目标
*/
class Solution {
    public int minIncrementForUnique(int[] A) {
        int need = 0, moves = 0;
        Arrays.sort(A);
        for(int num : A) {
            moves += Math.max(need - num, 0);
            need = Math.max(need, num) + 1;
        }
        return moves;
    }
}