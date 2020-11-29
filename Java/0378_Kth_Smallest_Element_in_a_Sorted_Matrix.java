//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Node> pq = new PriorityQueue(new Comparator<Node>(){
            
            public int compare(Node a, Node b){
                return a.val-b.val;
            }
            
        });
        
        for(int i=0;i<Math.min(n,k);i++){
            
            pq.add(new Node(matrix[i][0],i,0));
            
        }
        
        int res=0;
        
        while(k>0){
            
            Node polled = pq.poll();
            res=polled.val;
            
            int polledCol = polled.col;
            int polledRow = polled.row;
            
            if(polledCol<matrix[0].length-1) pq.add(new Node(matrix[polledRow][polledCol+1],polledRow,polledCol+1));
            
            
            k--;
        }
        
        return res;
    }
}
class Node{
    
    int val;
    int row;
    int col;
    
    public Node(int val, int row, int col){
        this.val=val;
        this.row=row;
        this.col=col;
    }
    
}
