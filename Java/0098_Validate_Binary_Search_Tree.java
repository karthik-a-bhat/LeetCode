//https://leetcode.com/problems/validate-binary-search-tree/

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
    public boolean isValidBST(TreeNode root) {
        
        return isValid(root,null,null);
            
    }
    public boolean isValid(TreeNode root, Integer low, Integer high){
        
        if(root==null) return true;
        
        if(low!=null && root.val<=low) return false;
        if(high!=null && root.val>=high) return false;
        
        
        boolean res = isValid(root.left,low,root.val) && isValid(root.right,root.val,high);
        
        return res;
        
    }
}
