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
            ����򻯣���ÿһλԪ�أ�ֻ���������������뵽ԭ�е��������У���������������ԭ�������У�
            ��ʱҪ����ԭ�������У�������л��������Ŀ��ܣ����ܼ����ˣ�����������ֻ�󻹻�������
            ��ʱ������ԭ�е�����û�б�Ҫ������ˣ�ԭ�������к�Ϊ������
            �����ķ������Ӹ�λ��ʼ�����ߴ���һλ��ʼ
            
            ʣ�µ����⣺��δ���ȫ�����������
            
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