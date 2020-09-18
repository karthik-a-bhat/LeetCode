//https://leetcode.com/problems/merge-intervals/

class Solution {
    public int[][] merge(int[][] intervals) {
        
        if(intervals==null || intervals.length==0) return intervals;
        
        List<int[]> res = new ArrayList();
        
        Arrays.sort(intervals, new Comparator<int[]>(){
            
            public int compare(int[] a, int[] b){
                return a[0]-b[0];
            }
        
        });
        
        
        int oldStartTime = intervals[0][0];
        int oldEndTime   = intervals[0][1];
        
        for(int[] interval : intervals){
            
            int currStartTime = interval[0];
            int currEndTime   = interval[1];
            
            
            if(currStartTime<=oldEndTime){
                oldEndTime = Math.max(oldEndTime, currEndTime);
            }
            else{
                int[] arr = new int[]{oldStartTime, oldEndTime};
                
                oldStartTime = currStartTime;
                oldEndTime   = currEndTime;
                
                res.add(arr);
                
            }
            
        }
        
        res.add(new int[]{oldStartTime, oldEndTime});
        
        return res.toArray(new int[res.size()][]);   
    }
}
