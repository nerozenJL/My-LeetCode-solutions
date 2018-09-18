class Solution {
    public int findNthDigit(int n) {
        //一位数，9个，共1*9=9位
        //两位数,90个，共2*90=180位
        //三位数，900个，共3*900=270位
        //以此类推
        long count = 9;
        int len = 1;
        int start = 1;

        while(n > count * len) {
            n -= count*len;
            start *= 10;
            count *= 10;
            len++;
        }
        //此时n就是剩余的位数
        start += (n-1)/len;
        String res = Integer.toString(start);
        //return res.charAt((n - 1) % len) - '0';
        return Character.getNumericValue(res.charAt((n - 1) % len));
    }
}