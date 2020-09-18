//https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> st = new Stack();
        
        for(char c: S.toCharArray()){
            
            if(!st.isEmpty() && st.peek()==c){
                st.pop();
            }
            else{
                st.push(c);
            }
            
            
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(char c: st){
            sb.append(c);
        }
        
        return sb.toString();
     
    }
}
