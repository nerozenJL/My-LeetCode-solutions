//区间合并的思路是不对的，只关注最新的两个区间并不能保证最优解

/*
* unhold[i] = max(unhold[i - 1], hold[i - 1] + prices[i] - fee) 
* hold[i] = max(hold[i - 1], unhold[i - 1] - prices[i])
*/
class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[] unhold = new int[prices.length];
        int[] hold = new int[prices.length];
        
        hold[0] = -prices[0];
        unhold[0] = 0;
        
        for(int i = 1; i<prices.length; i++) {
            unhold[i] = Math.max(prices[i] + hold[i-1] - fee, unhold[i-1]);
            hold[i] = Math.max(unhold[i-1] - prices[i], hold[i-1]);
        }
        
        return unhold[prices.length - 1];
    }
}