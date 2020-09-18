//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/

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
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList();
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap();
        
        
        if(root==null) return res;
        
        Queue<TreeNode> q1 = new LinkedList();
        Queue<Integer>  q2 = new LinkedList();
        
        q1.add(root); q2.add(0);
        
        while(!q1.isEmpty()){
            
            int len = q1.size();
            
            //Temporary Map for each level
            Map<Integer, List<Integer>> levelMap = new HashMap();
            
            for(int i=0;i<len;i++){
                
                TreeNode curr = q1.poll();
                int col = q2.poll();
                
                List<Integer> tempList = levelMap.getOrDefault(col,new ArrayList());
                
                
                tempList.add(curr.val);
                
                
                levelMap.put(col,tempList);
                
                if(curr.left!=null){
                    q1.add(curr.left);
                    q2.add(col-1);
                }
                if(curr.right!=null){
                    q1.add(curr.right);
                    q2.add(col+1);
                }
                
                
            }
            for(int key : levelMap.keySet()){
                
                List<Integer> tempList = levelMap.get(key);
                
                Collections.sort(tempList);
                
                List<Integer> mainList = treeMap.getOrDefault(key,new ArrayList());
                mainList.addAll(tempList);
                
                treeMap.put(key,mainList);
                
            }
            
            
        }
        
        res.addAll(treeMap.values());
        
        return res;
        
    }
}
