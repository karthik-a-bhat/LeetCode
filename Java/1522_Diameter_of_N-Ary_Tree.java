//https://leetcode.com/problems/diameter-of-n-ary-tree/

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    
    int res=0;
    
    public int diameter(Node root) {
        
        //Call helper method
        helper(root);
        
        //Return res. Initially zero. 
        return res;
        
    }
    
    //Return height of largest subtree at each step
    public int helper(Node root){
        
        //If there are no children, return null
        if(root.children.size()==0) return 1;
        
        //Keep a maxHeap to store values returned by all childre
        PriorityQueue<Integer> maxHeap = new PriorityQueue(Comparator.reverseOrder());
        
        //Recursively call each method on each child
        for(Node child : root.children){
            
            maxHeap.add(helper(child));
            
        }
        
        //Take only the top 2 values from the maxHeap. As these can form the max diameter
        int topVal = maxHeap.poll();
        int secondVal = (maxHeap.isEmpty()) ? 0 : maxHeap.peek();
        
        //Check if it greater than the current max seen (res), if so update 
        res = Math.max(res,topVal+secondVal);
        
        
        //Return maxValue returned by a child. This is the top of the max heap.
        return 1+topVal;
        
    }
}
