class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res;
        Map<String, List> m = new HashMap();
        for(String s : strs) {
            //对字符串排序
            char[] sorted = (s.toCharArray());
            Arrays.sort(sorted);
            String label = new String(sorted);
            List<String> l = m.getOrDefault(label, new ArrayList());
            l.add(s);
            m.put(label, l);
        }
        res = new ArrayList(m.values());
        return res;
    }
}