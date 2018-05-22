class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        int[] dp = new int[amount+1];
        for(int i = 0; i<dp.length; i++) dp[i] = -1;
        dp[0] = 0;
        //for(int d : dp)System.out.print(d + " ");
        for(int coin : coins) {
            if(coin > amount) continue;
            else dp[coin] = 1;
        }
        for(int a = 1; a<= amount; a++) {
            if(dp[a] == 1) continue;
            else {
                int now = Integer.MAX_VALUE;
                for(int coin : coins) {
                    int last = (a-coin>=0?(dp[a - coin]):-1);
                    if(last == -1)continue;
                    else now = Math.min(last, now);
                }
                now = (now == Integer.MAX_VALUE)?-1:now;
                dp[a] = now == -1?-1:now+1;
            }
        }
        //for(int d : dp)System.out.print(d + " ");
        return dp[amount];
    }
}