class Solution(object):
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        #��һ�������sΪ��
        if not s:
            return 0
        
        length = len(s)
        ways = []
        
        #s����С�����������
        if length == 1:
            return (int(s) and 1)
        if length == 2:
            num_s = int(s)
            #print num_s
            if num_s < 10:
                return 0
            if num_s > 26:
                if s[1] == '0':
                    return 0
                else:
                    return 1
            else:
                if num_s == 10 or num_s == 20:
                    return 1
                else:
                    return 2
        
        if length >= 3:
            ways = [0] * length
            #��ʽ��ʼ
            for i in range(0,len(s)):
                if i == 0:
                #�Ե�һλ�������Ƿ�Ϊ0��Ϊ0���Ϊ0����Ϊ0����Ϊ1
                    if s[i] != '0':
                        ways[i] = 1
                    else:
                        return 0
                if i == 1:
                #�Եڶ�λ����ʼ������λ��������������11-26������Ϊ2�������㣬�����������
                    num = int(s[0:2])
                    if num >= 11 and num <= 26 and num != 20:
                        ways[i] = 2
                    else:
                        if num <= 10 or (num > 26 and s[1] != '0'):
                            ways[i]=1
                        if num > 26 and s[1] == '0':
                            ways[i]=0
                
                #�ӵ���λ��ʼһ�㻯
                if i > 1:
                    num = int(s[i-1:i+1]) #��ȡǰһλ�ͱ�λ��ɵ�����
                    if s[i] == '0':
                        if num == 0:
                            return 0
                        else:
                            if num < 26:
                                ways[i] = ways[i-2]
                            else:
                                ways[i] = 0
                    else:
                        #����0�����
                        if num < 10: # 01 - 09�������˵��ȡ��λ���ܼ̳У�ֻ��ȡһλ
                            ways[i] = ways[i-1]
                        if num > 26: # 27 - 99,˵������ȡ��λ��ֻ��ȡһλ
                            ways[i] = ways[i-1]
                        if num <= 26 and num > 10:
                            ways[i] = ways[i-1] + ways[i-2]                      
        return ways[-1]