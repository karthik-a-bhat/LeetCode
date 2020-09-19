//https://leetcode.com/problems/binary-tree-maximum-path-sum/

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
    
    int res = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        
        postOrder(root);
        
        return res;
        
    }
    public int postOrder(TreeNode root){
        
        if(root==null) return 0;
        
        //Get the left and right values 
        int leftVal = postOrder(root.left);
        int rightVal = postOrder(root.right);
        
        //Get the current sum of left subtree, right subtree and root 
        int currVal = root.val + leftVal + rightVal;
        
        //Check if it is the max seen till now
        res =  Math.max(currVal,res);
        
        //Return either the left subtree and root, or right subtree and root, iff it is greater than 0
        return Math.max(0,Math.max(root.val + leftVal, root.val+rightVal));
        
    }
}
