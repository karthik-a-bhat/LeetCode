//https://leetcode.com/problems/kill-process/

class Solution {
    List<Integer> res = new LinkedList();
    HashMap<Integer, List<Integer>> hm = new HashMap();
    
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
                
        for(int i=0;i<pid.size();i++){
            
            int child = pid.get(i);
            int parent = ppid.get(i);
            
            
            List<Integer> childList = hm.getOrDefault(parent,new ArrayList());
            
            childList.add(child);
            
            hm.put(parent,childList);
            
            
        }
    
        dfs(kill);
        
        return res;
        
    }
    public void dfs(int kill){
        
        res.add(kill);
        
        List<Integer> childList = hm.get(kill);
        
        if(childList==null) return;
        
        for(int child : childList){
            
            dfs(child);
            
        }
        
    }
}
