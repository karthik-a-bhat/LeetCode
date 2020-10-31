//https://leetcode.com/problems/longest-palindromic-substring/

class Solution {
    
    int maxLen=0;
    int start=0;
    
    public String longestPalindrome(String s) {
        
        if(s==null || s.length()<2) return s;
        
        
        for(int i=0;i<s.length()-1;i++){
            
            helper(s,i,i);
            helper(s,i,i+1);
        }
        
        return s.substring(start,start+maxLaen);
    }
    
    public void helper(String s, int left, int right){
        
        if(s==null || left>right) return;
        
        while(left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            left--;
            right++;
        }
        
        if(maxLen<right-left-1){
            
            maxLen=right-left-1;
            start=left+1;
            
        }
        
        return;
        
    }
    
}
