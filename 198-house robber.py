class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        #�ӵ�һ��Ԫ�ؽ��б���
        #����������������ʾ��һ�ε�͵��ֵ������һ�ε�͵��ֵ
        #ע�⵱ǰ�±����ϴ�͵�����±����Թ�ϵ����������ڵģ���Ҫ���бȽ�
        #��αȽϣ����Ҫ͵��ǰλ�ã�������һ��͵����Ч����ʱ��Ҫ����Ȩ�⡣
        #�����ϴε�͵�����ϱ���Ԫ�ص�ֵ�󣿻��Ƿ�������͵�����ϴε�͵��ֵ��
        #˼����ǰ���㷨�ǲ��ǿ�����ȫ�������±��ά��
        
        formerRob=0
        moreformerRob=0
        laststolen_i=1
        for index in range(len(nums)):
            if index - laststolen_i == 1: #��������
                if  (moreformerRob + nums[index]) > formerRob:
                    tmp = formerRob
                    formerRob = moreformerRob + nums[index]
                    moreformerRob = tmp
                    laststolen_i=index
            else:
                #����Ĳ�����ֵ�����õģ���Ҫ�Ǳ���������ʱ��᲻��Ӱ�쵽ȫ�ֵ�ѡ��
                moreformerRob = formerRob
                formerRob += nums[index]
                laststolen_i = index
                
        return formerRob