https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList();
        
        if(root==null) return res;
        
        Queue<TreeNode> q = new LinkedList();
        
        q.add(root);
        
        int level=1;
        
        while(!q.isEmpty()){
            
            int len = q.size();
            
            LinkedList<Integer> tempList = new LinkedList();
                
            for(int i=0;i<len;i++){
                
                TreeNode curr = q.poll();
                
                //Add to first if order is to be reversed
                //Use LinkedList as the time complexity to add to first and last is O(1)
                if(level%2==0){
                    tempList.addFirst(curr.val);
                }
                else{
                    tempList.addLast(curr.val);
                }
                
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
                
                
            }
            
            level++;
            
            res.add(tempList);
        
        }
        
        return res;
    }
}
