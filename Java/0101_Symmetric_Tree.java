//https://leetcode.com/problems/symmetric-tree

//Iterative version

class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        if(root==null) return true;
        
        Queue<TreeNode> q = new LinkedList();
        
        q.add(root.left);
        q.add(root.right);
        
        
        while(!q.isEmpty()){
            
            int len = q.size();
            
            for(int i=0;i<len;i++){
                
                TreeNode curr1= q.poll();
                
                TreeNode curr2 = q.poll();
                
                if(curr1==null && curr2==null) continue;
                
                if(curr1!=null && curr2==null) return false;
                
                if(curr1==null && curr2!=null) return false;
                
                if(curr1.val!=curr2.val) return false;
                
                
                q.add(curr1.left);
                q.add(curr2.right);
                
                q.add(curr1.right);
                
                q.add(curr2.left);
            
            }
            
        }
        return true;
        
    }
}

------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//Recursive version

class Solution {
    public boolean isSymmetric(TreeNode root) {
        
        if(root==null) return true;
        
        return helper(root.left,root.right);
        
    }
    public boolean helper(TreeNode left, TreeNode right){
        
        if(left==null && right==null) return true;
        
        if(left==null || right==null) return false;
        
        if(left.val!=right.val) return false;
        
        boolean res = helper(left.left, right.right) && helper(left.right, right.left);
        
        return res;
        
    }
}

