class Solution {
    public int threeSumMulti(int[] A, int target) {
        Map<Integer, Integer> m = new HashMap();
        
        for(int num : A) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }
        
        int res = 0;
        
        for(int i : m.keySet()) {
            for(int j : m.keySet()) {
                int k = target - i - j;
                if(m.containsKey(k)) {
                    if(i < j && j < k) { //这个很妙，我自己肯定想不到
                        res += m.get(i) * m.get(j) * m.get(k);
                    }
                    if(i == j && j == k && m.get(i)>=3) {
                        res += (m.get(i) * (m.get(i)-1) * (m.get(i)-2)) / 6;
                    }
                    if(i == j && j != k && m.get(i)>=2) {
                        res += (m.get(i) * (m.get(i)-1))/2 * m.get(k);
                    }
                }
            }
        }
        return (int)(res % (1e9 + 7));
    }
}





/*

Think Outside of The Box!
Intuitively, you will try to solve it based on the solution of 3Sum.
But... Build a map for counting different sums of two numbers. The rest of things are straightfoward.


*/

class Solution {
    public int threeSumMulti(int[] A, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int res = 0;
        int mod = 1000000007;
        for (int i = 0; i < A.length; i++) {
            res = (res + map.getOrDefault(target - A[i], 0)) % mod;
            
            for (int j = 0; j < i; j++) {
                int temp = A[i] + A[j];
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }
        }
        return res;
    }
}