class Solution {
    public String convert(String s, int numRows) {
        if(numRows<=1)return s;
        //用字符流数组而不是二维字符数组，减少冗余数据
        StringBuilder[] sbs = new StringBuilder[numRows];
        for(int i = 0; i<sbs.length; i++) sbs[i] = new StringBuilder("");
        int step = -1;
        int nowp = 0;
        for(int i = 0; i<s.length(); i++) {
            if(nowp == 0 || nowp == numRows-1) step*=-1; 
            sbs[nowp].append(s.charAt(i));
            nowp+=step;
        }
        String res = "";
        for(StringBuilder sb : sbs) {
            res += sb.toString();
        }
        return res;
    }
}