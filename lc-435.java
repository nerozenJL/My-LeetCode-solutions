/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public int eraseOverlapIntervals(Interval[] intervals) {
        int res = 0;
        if(intervals == null || intervals.length<=1) return 0;
        
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return (o1.end != o2.end)?o1.end - o2.end:o1.start - o1.start;
            }
        });
        
        //计算重叠数，并且合并区间
        int s = intervals[0].start, e = intervals[0].end;
        for(int i = 1; i<intervals.length; i++) {
            if(intervals[i].start < e) {
                res++;
            }else {
                e = intervals[i].end;
            }
        }
        return res;
    }
}