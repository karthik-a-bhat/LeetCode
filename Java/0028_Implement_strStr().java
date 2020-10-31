//https://leetcode.com/problems/implement-strstr

class Solution {
    public int strStr(String haystack, String needle) {
        
        if(haystack.length()<needle.length()) return -1;
       
        for(int i=0;i<=haystack.length()-needle.length();i++){
            
            
            int count=0;
            
            while(count<needle.length() && haystack.charAt(i+count)==needle.charAt(count)){
                count++;
            }
            if(count==needle.length()){
                return i;
            }
            
        }
        
        return -1;
        
    }
}
