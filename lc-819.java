/*
*1.正则表达式分割字符串
*2.与banned比较 (使用contains方法，这个之前已经碰过一次了)
*3.对hashmap排序(想复杂了,每次都用value和当前最大值比较即可)
*/
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        //paragraph.toLowerCase();//tolowercase会返回一个新对象，而不是在原有对象上修改

        //String[] words = paragraph.split("[\\p{Punct}\\s]+"); 正则表达式,以空格和标点符号分割开
        String[] words = paragraph.toLowerCase().split("[\\p{Punct}\\s]+");   
        
        Map<String, Integer> countMap = new HashMap();
        
        Set<String> ban = new HashSet<>(Arrays.asList(banned)); //非常简洁的调用
        
        int maxcount = 0;
        String res = "";
        for(String word : words) {
            //思维的差距，要多像这种简洁代码学习
            if(!ban.contains(word)) {
                countMap.put(word, countMap.getOrDefault(word, 0) + 1);//还是简洁的API，熟悉api
                if(countMap.get(word) >= maxcount) {
                    maxcount = countMap.get(word);
                    res = word;
                }
            }
        }
        //使用排序或者简单遍历map(想复杂了，不用排序)
        //sort
        return res;
    }
}