//https://leetcode.com/problems/partition-labels/

class Solution {
    public List<Integer> partitionLabels(String S) {
        
        List<Integer> res = new ArrayList();
        
        if(S==null || S.length()==0) return res;
        
        
        int[] last_index = new int[26];
        
        for(int i=0;i<S.length();i++){
            
            last_index[S.charAt(i)-'a']=i;
            
        }
        
        int start=0;
        int end=0;
        
        for(int i=0;i<S.length();i++){
            
            end = Math.max(end,last_index[S.charAt(i)-'a']);
            
            if(i==end){
                res.add(end-start+1);
                start=end+1;
            }
                     
        }
        
        return res;
        
        
    }
}
