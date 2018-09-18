class Solution {
    Map<Integer, Integer> m =new HashMap();
    public int integerReplacement(int n) {
        
        if(n == 1) return 0;
        if(n == Integer.MAX_VALUE) return integerReplacement(n-1); //整形MAX+1溢出为0，死循环
        if(m.get(n) != null) return m.get(n);
        if(n%2 == 0) {
            //偶数
            int res = integerReplacement(n/2) + 1;
            m.put(n, res);
            return res;
        }else {
            int res = Math.min(integerReplacement(n-1), integerReplacement(n+1)) + 1;
            m.put(n, res);
            return res;
        }
    }
}