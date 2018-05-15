//能过绝大部分的case，但是最后一个case超时
//主要是因为固定的策略不对
//
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet();
        Arrays.sort(nums);
        int starti = 1;
        while(starti < nums.length-1) {
            int head = 0, tail = nums.length-1;
            while(head < starti && tail > starti) {
                int sum = nums[head] + nums[starti] + nums[tail];
                boolean canbreak = false;
                if(sum == 0) {
                    List<Integer> a = new ArrayList();
                    a.add(nums[head]);
                    a.add(nums[starti]);
                    a.add(nums[tail]);
                    if(!res.contains(a)) {
                        res.add(a);
                    }
                    tail--;
                    continue;
                }
                if(sum > 0) {
                    if(tail-1>starti) {
                        tail--;
                    }else {
                        head++;
                    }
                    continue;
                }
                if(sum < 0) {
                    if(head+1<starti) {
                        head++;
                    }else{
                        tail--;
                    }
                    continue;
                }
            }
            starti++;
        }
        return new ArrayList(res);
    }
}

//这是AC的版本
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet();
        Arrays.sort(nums);
        for(int i = 0; i<nums.length-2; i++) {
            int mid = i+1, tail = nums.length-1;
            while(mid<tail) {
                int sum = nums[i] + nums[mid] + nums[tail];
                if(sum == 0) {
                    List<Integer> a = new ArrayList();
                    a.add(nums[i]);
                    a.add(nums[mid]);
                    a.add(nums[tail]);
                    if(!res.contains(a))res.add(a);
                    tail--;
                }else if(sum>0) {
                    tail--;
                }else {
                    mid++;
                }
            }
        }
        return new ArrayList(res);
    }
}