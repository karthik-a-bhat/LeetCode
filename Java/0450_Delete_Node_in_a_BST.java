//https://leetcode.com/problems/delete-node-in-a-bst/

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
    public TreeNode deleteNode(TreeNode root, int key) {
     
        if(root==null) return root;
        
        if(root.val>key){
            
            root.left = deleteNode(root.left,key);
            
        }
        else if(root.val<key){
            
            root.right=deleteNode(root.right,key);
            
        }
        //We have found the node!!
        else{
            //If left of the node is null, return right, else left;
            if(root.left==null){
                return root.right;
            }
            
            if(root.right==null){
                return root.left;
            }
            
            //If both are not null, return minval of the right subtree and delete the minval
            
            TreeNode minNode = getMin(root.right);
            root.val=minNode.val;
            
            //Recursively delete the minNode
            root.right=deleteNode(root.right,minNode.val);
            
        }
        
        return root;

    }
    public TreeNode getMin(TreeNode root){
        
        while(root.left!=null){
            root=root.left;
        }
        return root;
    }
}
