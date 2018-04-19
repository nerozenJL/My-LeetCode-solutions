class Solution {
    public String addStrings(String num1, String num2) {
        String res;
        int sp1 = num1.length()-1, sp2 = num2.length()-1;
        StringBuilder sb = new StringBuilder();
        boolean isUp = false;
        while(sp1 >= 0 || sp2 >= 0) {
            int n1 = sp1>=0?num1.charAt(sp1) - '0':0;
            int n2 = sp2>=0?num2.charAt(sp2) - '0':0;
            int sum = n1+n2;
            if(isUp)sum++;
            if(sum>=10){
                isUp=true;
                sb.insert(0, Integer.toString(sum-10));
            }
            else {
                isUp = false;
                sb.insert(0, Integer.toString(sum));
            }
            sp1--;
            sp2--;
        }
        if(isUp)sb.insert(0, "1");
        return sb.toString();
    }
}
/*
1.StringBuilder有个insert方法，可以插入到任何一个地方，开头末尾都可以，太强了
2.三目表达式：line8-9解决长短不一致的问题，不用在循环外部解决，很不错
*/