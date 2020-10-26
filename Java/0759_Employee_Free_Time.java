//https://leetcode.com/problems/employee-free-time/

/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
     
        List<Interval> res = new LinkedList();
        
        PriorityQueue<Interval> pq = new PriorityQueue(new Comparator<Interval>(){
            
            public int compare(Interval a, Interval b){
                
                int res = a.start-b.start;
                
                if(res==0){
                    res=a.end-b.end;
                }
                
                return res;
            }
           
        });
        
        for(List<Interval>employee : schedule){
            
            for(Interval i : employee){
                
                pq.add(i);
                
            }
        }
        
        if(pq.isEmpty()) return res;
        
        Interval pre = pq.poll();
        
        
        while(!pq.isEmpty()){
            
            Interval curr = pq.poll();
            
            if(pre.end < curr.start){
                res.add(new Interval(pre.end,curr.start));
            }
            else{
                curr.start = Math.min(pre.start,curr.start);
                curr.end = Math.max(curr.end, pre.end);
            }
            pre=curr;
            
        }
        
        return res;
        
    }
}
