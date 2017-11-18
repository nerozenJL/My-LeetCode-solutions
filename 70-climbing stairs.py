class Solution(object):
    def climbStairs(self, n):
        """
        :type n: int
        :rtype: int
        :以动态规划的角度，所有问题都可以归结到子问题。
        :从n开始，因为这样容易将前面的工作变成后面的输出。
        :问题的焦点是如何表达这个关系式
        :以五为例，以5为终点，有两种走法，从3走两步，或者从4走一步
        :以3为终点，可以从2走一步，从1走两步；以4为终点，可以从3走1步，从2走两步。以此类推
        :从中可以发现什么呢？
        :从某点开始，到终点有几种走法，等式为到下一点的方法*下一点到终点的方法
        """
        if n==1:
            return 1
        if n==2:
            return 2
        dpArray = [0]*n
        dpArray[0]=1
        dpArray[1]=2
        for i in range(2,n):
            dpArray[i] = dpArray[i-1] + dpArray[i-2]
        return dpArray[n-1] 