//https://leetcode.com/problems/course-schedule/

class Solution {
    
    int[] inDegree;
    
    HashMap<Integer, List<Integer>> hm;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        inDegree = new int[numCourses];
        
        hm = new HashMap();
        
        
        for(int[] pre : prerequisites){
            
            int preCourse = pre[1];
            int course = pre[0];
            
            List<Integer>listOfEdges = hm.getOrDefault(preCourse, new ArrayList());
            
            listOfEdges.add(course);
            
            hm.put(preCourse,listOfEdges);
            
            inDegree[course]++;
            
        }
        
        Queue<Integer> q = new LinkedList();
        
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0){
                q.add(i);
            }
        }
        
        int count=0;
        
        while(!q.isEmpty()){
            
            int node = q.poll();
            
            if(inDegree[node]==0){
                count++;
            }
            
            if(!hm.containsKey(node)) continue;
            
            List<Integer> neighList = hm.get(node);
            
            
            for(int nei : neighList){
                
                inDegree[nei]--;
                
                if(inDegree[nei]==0){
                    q.add(nei);
                }

            }
            
                        
        }
        
        return count==numCourses;
        
    }
}
