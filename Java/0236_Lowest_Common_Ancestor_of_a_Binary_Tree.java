//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        return helper(root,p,q);
        
    }
    public TreeNode helper(TreeNode root, TreeNode p, TreeNode q){
        
        if(root==null || root==p || root==q){
            return root;
        }
        
        
        TreeNode left = helper(root.left,p,q);
        
        TreeNode right = helper(root.right,p,q);
        
        
        if(left!=null && right!=null){
            return root;
        }
        
        return (left!=null) ? left : right;
        
    }
}
