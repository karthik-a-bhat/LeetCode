//https://leetcode.com/problems/all-paths-from-source-to-target/

class Solution {
    
    List<List<Integer>> res = new ArrayList();
    
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
     
        dfs(graph,0,new ArrayList());
        
        return res;
    }
    public void dfs(int[][] graph, int node, List<Integer> path){
        
        path.add(node);
        
        if(node==graph.length-1){
            res.add(new ArrayList(path));
            return;
        }
        
        for(int n : graph[node]){
        
            dfs(graph,n,path);
            
            path.remove(path.size()-1);
            
        }
        
    }
}
