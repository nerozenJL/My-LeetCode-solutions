class Solution(object):
    def numDecodings(self, s):
        """
        :type s: str
        :rtype: int
        """
        #第一种情况，s为空
        if not s:
            return 0
        
        length = len(s)
        ways = []
        
        #s长度小于三的情况：
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
            #正式开始
            for i in range(0,len(s)):
                if i == 0:
                #对第一位，考虑是否为0，为0标记为0。不为0则标记为1
                    if s[i] != '0':
                        ways[i] = 1
                    else:
                        return 0
                if i == 1:
                #对第二位，开始考虑两位数情况，如果满足11-26，则标记为2。不满足，分两种情况，
                    num = int(s[0:2])
                    if num >= 11 and num <= 26 and num != 20:
                        ways[i] = 2
                    else:
                        if num <= 10 or (num > 26 and s[1] != '0'):
                            ways[i]=1
                        if num > 26 and s[1] == '0':
                            ways[i]=0
                
                #从第三位开始一般化
                if i > 1:
                    num = int(s[i-1:i+1]) #截取前一位和本位组成的数字
                    if s[i] == '0':
                        if num == 0:
                            return 0
                        else:
                            if num < 26:
                                ways[i] = ways[i-2]
                            else:
                                ways[i] = 0
                    else:
                        #不是0的情况
                        if num < 10: # 01 - 09的情况，说明取两位不能继承，只能取一位
                            ways[i] = ways[i-1]
                        if num > 26: # 27 - 99,说明不能取两位，只能取一位
                            ways[i] = ways[i-1]
                        if num <= 26 and num > 10:
                            ways[i] = ways[i-1] + ways[i-2]                      
        return ways[-1]