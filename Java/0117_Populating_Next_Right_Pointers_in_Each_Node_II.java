//https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        
        Node level_start=null;
        Node curr = root;
        Node prev=null;
        
        while(curr!=null){
            
            while(curr!=null){
                
                if(curr.left!=null){
                    
                    if(prev!=null){
                        prev.next=curr.left;
                    }
                    else{
                        level_start=curr.left;
                    }
                    prev=curr.left;
                    
                }
                if(curr.right!=null){
                    
                    if(prev!=null){
                        prev.next=curr.right;
                    }
                    else{
                        level_start=curr.right;
                    }
                    prev=curr.right;
                }
                
                curr=curr.next;    
            }
            
            curr=level_start;
            prev=null;
            level_start=null;
        }
        return root;
    }
}
