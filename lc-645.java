class Solution {
    public int[] findErrorNums(int[] nums) {
        int sum = 0;
        int osum = (1+nums.length)*nums.length/2;
        int rn = 0;
        Set<Integer> s = new HashSet();
        for(int a : nums) {
            if(s.contains(a)){
                rn = a;
            }else{
                s.add(a);
            }
            sum+=a;
        }
        int[] res = new int[2];
        res[0] = rn;
        if(osum>sum) {
            //被覆盖的比重复数大
            res[1] = rn + (osum - sum);
        }else {
            res[1] = rn - (sum - osum);
        }     
        return res;
    }
}

/*
看到个解法，很有启发性，将下标与数字结合起来。因为是1到n的元素，因此存在对应关系。访问一次，以元素为下标的元素*-1
*/