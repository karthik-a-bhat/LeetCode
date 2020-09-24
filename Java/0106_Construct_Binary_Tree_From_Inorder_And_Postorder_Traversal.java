//https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    int postStart;
    int[] inOrder;
    int[] postOrder;
    
    HashMap<Integer, Integer> hm = new HashMap();
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        inOrder = inorder;
        postOrder = postorder;
        
        postStart = postOrder.length-1;
        
        for(int i=0;i<inOrder.length;i++){
            hm.put(inOrder[i],i);
        }
        
        return helper(0,inOrder.length-1);
        
    }
    
    public TreeNode helper(int left, int right){
        
        if(right<left) return null;
        
        TreeNode root = new TreeNode(postOrder[postStart]);
        
        int inIndex = hm.get(postOrder[postStart]);
        
        postStart--;
        
        root.right = helper(inIndex+1,right);
        
        root.left = helper(left,inIndex-1);
        
        return root;
        
    }
    
    
    
}
