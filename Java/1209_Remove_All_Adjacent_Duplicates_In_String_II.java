//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/

class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Character> stLetter = new Stack();
        Stack<Integer> stCount    = new Stack();
        
        
        for(char c: s.toCharArray()){
        
            
            if(!stLetter.isEmpty() && stLetter.peek()==c){
                int count = stCount.pop();
                count+=1;
                
                if(count==k){
                    stLetter.pop();
                }
                else{
                    stCount.push(count);
                }
                
            }
            else{
                stCount.push(1);
                stLetter.push(c);
            }
            
            
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!stLetter.isEmpty()){
            int count = stCount.pop();
            char c = stLetter.pop();
            for(int i=0;i<count;i++){
                sb.insert(0,c);
            }
            
        }
        
        return sb.toString();
        
    }
}
