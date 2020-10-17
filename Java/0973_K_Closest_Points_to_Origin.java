//https://leetcode.com/problems/k-closest-points-to-origin/

class Solution {
    public int[][] kClosest(int[][] points, int K) {
        
        //Custom Sort Comparator for maxHeap. 
        PriorityQueue<int[]> maxHeap = new PriorityQueue(new Comparator<int[]>(){
           
            public int compare(int[] a, int[] b){
                
                int a_dist = ((a[0]*a[0]) + (a[1]*a[1]));
                int b_dist = ((b[0]*b[0]) + (b[1]*b[1]));
                
                return b_dist-a_dist;
            }
                
        });
        
        
        for(int[] point : points){
            
            maxHeap.add(point);
            
            if(maxHeap.size()>K){
                maxHeap.poll();
            }
            
        }
        
        int[][] res = new int[K][2];
        int i=0;
        
        while(!maxHeap.isEmpty()){
            
            int[] point = maxHeap.poll();
            
            res[i][0]=point[0];
            res[i][1]=point[1];
            i++;
        }
        
        return res;
    }
}
