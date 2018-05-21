class Solution {
    public int maxProfit(int[] prices) {
        
        if(prices.length<=1) return 0;
        
        int[] cooldown = new int[prices.length]; //交易发生之后的第二天
        int[] hold = new int[prices.length]; //买入之后
        int[] unhold = new int[prices.length]; //交易当天，冷却后的第二天，持续空仓
        
        hold[0] = -prices[0];
        
        for(int i = 1; i<prices.length; i++) {
            cooldown[i] = unhold[i-1];
            hold[i] = Math.max(cooldown[i-1] - prices[i], hold[i-1]);
            unhold[i] = Math.max(hold[i-1] + prices[i], Math.max(unhold[i-1], cooldown[i-1]));
        }
        
        return Math.max(unhold[prices.length-1],cooldown[prices.length-1]);
    }
}