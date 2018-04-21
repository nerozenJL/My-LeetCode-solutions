class Solution {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, List<Integer>> m = new HashMap();
        int max = 0;//出现次数最大值
        int[] min_D = {-1, Integer.MAX_VALUE};
        if(nums.length == 0 || nums.length == 1)return nums.length;
        for(int i = 0; i<nums.length; i++) {
            if(m.containsKey(nums[i])) {
                List<Integer> instance = m.get(nums[i]);
                instance.add(i);           
                if(instance.size() >= max) {
                    //等于max也要考虑，因为可能最短距离会被刷新
                    int d = instance.get(instance.size()-1) - instance.get(0);
                    //System.out.println(i + " " + nums[i] + " " + instance + " " +  min_D[0] + " " + min_D[1] + " " + d);
                    if(min_D[0] == nums[i]) {
                        min_D[1] = d;
                    }else {
                        //如果不是同一元素，则检查最短距离是否更新
                        if(instance.size() > max || d < min_D[1]) {
                            //System.out.println("haha");
                            min_D[1] = d;
                            min_D[0] = nums[i];
                        }
                    }
                    
                    if(min_D[0] == -1) {
                        min_D[1] = d;
                        min_D[0] = nums[i];
                    }
                    
                    max = instance.size();
                }
            }else {
                List<Integer> l = new ArrayList();
                l.add(i);
                m.put(nums[i], l);
            }
        }
        if(min_D[0] == -1) return 1;//说明所有的元素没有重复
        return min_D[1] + 1;
    }
}