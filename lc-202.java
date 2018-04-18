class Solution {
    public boolean isHappy(int n) {
        char[] str = String.valueOf(n).toCharArray();
        int sum = 0;
        for(char c : str) {
            int a = c - '0';
            sum += a*a;
        }
        //System.out.println(sum);
        if(sum==1)return true;
        else {
            boolean res = false;
            try {
                res = isHappy(sum);
            }finally{
                return res;
            }
        }
    }
}