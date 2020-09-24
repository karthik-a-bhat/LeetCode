//https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/

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
    
    int preStart=0;
    int[] preOrder;
    int[] inOrder;
    
    HashMap<Integer, Integer> hm = new HashMap();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        preOrder = preorder;
        inOrder = inorder;
        
        for(int i=0;i<inOrder.length;i++){
            hm.put(inOrder[i],i);
        }
        
        return helper(0,inOrder.length-1);
        
    }
    
    public TreeNode helper(int left, int right){
        
        if(right<left) return null;
        
        TreeNode root = new TreeNode(preOrder[preStart]);
        
        int inIndex = hm.get(preOrder[preStart]);
        
         preStart++;
        
        root.left = helper(left,inIndex-1);
        root.right = helper(inIndex+1,right);
        
        return root;
    }
    
}
