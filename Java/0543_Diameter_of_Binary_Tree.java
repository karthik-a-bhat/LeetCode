//https://leetcode.com/problems/diameter-of-binary-tree/

class Solution {
    
    int diameter = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        
        helper(root);
        
        return diameter;
        
    }
    public int helper(TreeNode root){
        
        if(root==null) return 0;
        
        
        int lVal = helper(root.left);
        
        int rVal = helper(root.right);
        
        diameter = Math.max(diameter,lVal + rVal);
        
        
        return 1+Math.max(lVal, rVal);
    }
}

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
