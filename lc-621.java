class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        int maxFreq=0,maxFreqCount=0;
        for(int i=0;i<tasks.length;i++){
            freq[tasks[i]-'A']++;
        }
        for(int i=0;i<26;i++){
            if(freq[i]>maxFreq){
                maxFreq=freq[i];
                maxFreqCount=1;
            }else if(freq[i]==maxFreq){
                maxFreqCount++;
            }
        }
        return Math.max(tasks.length,(maxFreq-1)*(n+1)+maxFreqCount);
    }
}