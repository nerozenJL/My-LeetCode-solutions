class Solution {
    public int totalFruit(int[] tree) {
        //带限制条件的dp问题(其实是贪心,不行，最后还是要dp)
        //如何描述种类
        
        Set<Integer> types = new HashSet();
        int max = Integer.MIN_VALUE;
        int count = 0;
        for(int i = 0; i<tree.length; i++) {
            if(types.contains(tree[i])) {
                count++;
            }else {
                if(types.size()<2) {
                    types.add(tree[i]);
                    count++;
                }else {
                    //上一轮摘果子结束
                    if(count>max) {
                        max = count;
                    }
                    count = 2;
                    //忠实地保留状态
                    for(int j = i-2; j>=0; j--) {
                        if(tree[j] == tree[i-1]) count++;
                        else break;
                    }
                    types.clear();
                    types.add(tree[i]);
                    types.add(tree[i-1]);
                }
            }
        }
        max = count>max?count:max;
        return max;
    }
}