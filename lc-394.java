class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> cntStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        String res = "";
        int num = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = 10*num + c - '0';
            }
            if (Character.isLetter(c)) {
                res += c;
            }
            if (c == '[') {
                cntStack.push(num);
                resStack.push(res);
                num = 0;
                res = "";
            }
            if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int counts = cntStack.pop();
                for (int i = 0; i < counts; ++i) {
                    tmp.append(res);
                }

                res = resStack.pop() + tmp.toString();
                num = 0;
            }
        }
        return res;
    }
}