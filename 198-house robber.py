class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #从第一个元素进行遍历
        #定义两个变量，表示上一次的偷盗值与上上一次的偷盗值
        #注意当前下标与上次偷盗的下标的相对关系，如果是相邻的，需要进行比较
        #如何比较？如果要偷当前位置，表面上一次偷盗无效，此时需要进行权衡。
        #是上上次的偷盗加上本次元素的值大？还是放弃本次偷盗，上次的偷盗值大？
        #思考当前的算法是不是考虑周全，比如下标的维护
        
        formerRob=0
        moreformerRob=0
        laststolen_i=1
        for index in range(len(nums)):
            if index - laststolen_i == 1: #表明相邻
                if  (moreformerRob + nums[index]) > formerRob:
                    tmp = formerRob
                    formerRob = moreformerRob + nums[index]
                    moreformerRob = tmp
                    laststolen_i=index
            else:
                #这里的步骤是值得推敲的，主要是变量更迭的时候会不会影响到全局的选择
                moreformerRob = formerRob
                formerRob += nums[index]
                laststolen_i = index
                
        return formerRob