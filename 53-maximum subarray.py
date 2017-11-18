class Solution(object):
    def maxSubArray(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max=0
        sum=0
        if nums:
            max=nums[0]            
        for num in nums:
            """
            问题简化：对每一位元素，只有两个决定，加入到原有的子序列中；舍弃（暗含放弃原有子序列）
            何时要加入原有子序列：这个序列还有增长的可能（尽管减少了，但是它可能只后还会增长）
            何时舍弃：原有的序列没有必要再添加了（原有子序列和为负数）
            舍弃的方法：从该位开始，或者从下一位开始
            
            剩下的问题：如何处理全负数的情况？
            
            """
            if sum <= 0:
                if num > 0:
                    sum = num
                    if sum>=max:
                        max=sum
                else:
                    if max<0 and num>max: 
                        max = num
            else:
                sum+=num
                if num>0 and sum>max:
                    max=sum    
        return max