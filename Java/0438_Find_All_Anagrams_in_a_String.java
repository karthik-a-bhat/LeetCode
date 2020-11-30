//https://leetcode.com/problems/find-all-anagrams-in-a-string/

//Very similar to LC 76 - Min Window Substring
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        
        List<Integer> res = new ArrayList();
        
        int[] p_map = new int[26];
        
        
        for(char c:p.toCharArray()){
            
            p_map[c-'a']++;
            
        }
        
        int left=0, right=0,count=p.length();
        
        
        while(right<s.length()){
        
            if(p_map[s.charAt(right)-'a']>=1){
                count--;
            }
            
            p_map[s.charAt(right)-'a']--;
            
            right++;
            
            if(count==0){
                res.add(left);
            }
            
            
            if(right-left==p.length()){

                p_map[s.charAt(left)-'a']++;
                
                
                if(p_map[s.charAt(left)-'a']>0){
                    
                    count++;
                    
                }
                
                left++;
                
            }
  
        }
        
        return res;        
    }
}
