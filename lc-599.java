class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> rank = new HashMap();       
        for(int i = 0; i<list1.length; i++) rank.put(list1[i], i);
        int least = Integer.MAX_VALUE;
        List<String> res = new ArrayList();
        for(int j = 0; j<list2.length; j++) {
            if(rank.containsKey(list2[j])) {
                if(j + rank.get(list2[j]) < least) {                  
                    least = j+rank.get(list2[j]);
                    res.clear();
                    res.add(list2[j]);
                }else if(j + rank.get(list2[j]) == least) {
                    res.add(list2[j]);
                }
            }
        }
        return (String[])(res.toArray(new String[0])); //注意toArray的正确用法
    }
}