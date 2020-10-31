//https://leetcode.com/problems/task-scheduler/

class Solution {
    public int leastInterval(char[] tasks, int n) {
        
        int[] arr = new int[26];
        
        
        for(char c: tasks){
            
            arr[c-'A']++;
            
        }
        
        
        //Most frequent elements will be at the end.
        Arrays.sort(arr);
        
        
        int maxSpaces = arr[25]-1;
        
        int emptySpots = n*maxSpaces;
        
        
        for(int i=24;i>=0;i--){
            
            int val = arr[i];
            
            //We take minimum
            //If there are less spaces then we can only insert that many number of tasks
            //Else we insert total number of tasks
            emptySpots = emptySpots - Math.min(val,maxSpaces);
            
        }
        
        int res = tasks.length;
        
        if(emptySpots>0){
            res+=emptySpots;
        }
        
        
        return res;
        
    }
}
