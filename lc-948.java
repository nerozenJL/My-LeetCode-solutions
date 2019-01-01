class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        
        int point = 0, res = 0;
        //其实每个回合你可以什么都不用做
        //所以对获利最大的回合做出行动即可
        //所谓最大获利，即是低入高出，最便宜的代币换取point，用1point换取最大的power
        Arrays.sort(tokens);
        int l = 0, r = tokens.length-1;
        
        while(l <= r) {
            if(P >= tokens[l]) {
                point++;
                P-=tokens[l];
                l++;
            } else if(point>0){
                //能量不足，就考虑购买能量
                point--;
                P+=tokens[r];
                r--;
            } else break; //需要一个终止条件
            res = Math.max(point, res);
            
        }
        return res;
    }
}