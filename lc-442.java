/*
*用hashset太犯规了，考虑用别的办法吧
*
*/
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> s = new HashSet();
        List<Integer> res = new ArrayList();
        for(int num : nums) {
            if(s.contains(num)) {
                res.add(num);
            }else{
                s.add(num);
            }
        }
        return res;
    }
}
//解法2，没有用set，数组值与下标的使用
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList();
        for(int i = 0; i<nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if(nums[index]<0) {
                res.add(index+1);
            }else {
                nums[index] *= -1;
            }
        }
        return res;
    }
}