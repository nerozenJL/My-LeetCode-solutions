class Solution(object):
    def maxProfit(self, prices):
        """
        :type prices: List[int]
        :rtype: int
        """
        if not prices:
            return 0
        mparray=[0]*len(prices)
        maxPrice=prices[-1]
        i=len(prices)-1
        for price in prices[::-1]:
            print maxPrice,price
            mparray[i] = maxPrice-price
            maxPrice = max(price, maxPrice)
            i=i-1
        print mparray
        if max(mparray)<0:
            return 0
        else:
            return max(mparray)