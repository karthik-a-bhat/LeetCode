//https://leetcode.com/problems/cut-off-trees-for-golf-event/

class Solution {
    
    int[][] dir = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int cutOffTree(List<List<Integer>> forest) {
     
        if(forest==null || forest.size()==0) return 0;
        
        int maxRow = forest.size();
        int maxCol = forest.get(0).size();
        
        
        //Sort all the trees according to height and put the row,col values along with height into the minheap
        PriorityQueue<int[]> pq = new PriorityQueue(new Comparator<int[]>(){
            
            public int compare(int[] a, int[] b){
                return a[2]-b[2];
            }
            
        });
        
        
        for (int i = 0; i < maxRow; i++) {
            for (int j = 0; j < maxCol; j++) {
                if (forest.get(i).get(j) > 1) {
                    pq.add(new int[] {i, j, forest.get(i).get(j)});
                }
            }
        }
        
        int[] start = new int[2];
        
        int res = 0;
        
        //Count min steps to reach each tree from the previous tree. Start from 0,0. If steps =-1, return -1;
        while(!pq.isEmpty()){
            
            int[] tree = pq.poll();
            
            int step = minSteps(maxRow, maxCol, tree, start,forest);
            
            if(step<0) return -1;
            
            res+=step;
            
            start[0]=tree[0];
            start[1]=tree[1];
            
        }
        
        return res;
        
    }
    
    //Track minimum steps to reach tree from given starting point. 
    private int minSteps(int maxRow, int maxCol, int[] tree, int[] start, List<List<Integer>> forest){
        
        boolean[][] vis = new boolean[maxRow][maxCol];
        
        int step=0;
        
        Queue<int[]> q = new LinkedList();
        
        vis[start[0]][start[1]]=true;
        
        q.add(start);
        
       
        while(!q.isEmpty()){
            
            int len = q.size();
            
            for(int i=0;i<len;i++){
                
                int[] curr = q.poll();
            
                
                //Check if current node popped is the tree
                if(curr[0]==tree[0] && curr[1]==tree[1]) return step;
                
                //Else, go in all 4 directions
                for(int[] di : dir){
                    
                    int nr = di[0] + curr[0];
                    int nc = di[1] + curr[1];
                    
                    //Check for out of bounds
                    //Label A
                    if(nr<0 || nr>=maxRow || nc<0 || nc>=maxCol || vis[nr][nc] || forest.get(nr).get(nc)==0){
                        continue;   
                    }
                    
                    int[] newTree = new int[]{nr,nc};
                    
                    //Important to mark vis here as sometimes it may cause TLE at label A;
                    vis[nr][nc]=true;
                    
                    q.add(newTree);
                    
                }
            
            }
            step++;
        }  
        return -1;
    }
    
}

