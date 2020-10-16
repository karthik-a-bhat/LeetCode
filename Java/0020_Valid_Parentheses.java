//https://leetcode.com/problems/valid-parentheses/

class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack();
        
        
        for(char c:s.toCharArray()){
            
            if(c=='[' || c=='{' || c=='('){
                st.push(c);
            }
            else{
                
                if(st.isEmpty()) return false;
                
                char opening = getOpening(c);
                
                if(st.peek()!=opening) return false;
                
                st.pop();
                
            }
            
            
        }
        
        return st.isEmpty();
        
    }
    public char getOpening(char c){
        
        if(c==']') return '[';
        if(c=='}') return '{';
        if(c==')') return '(';
        
        throw new IllegalArgumentException();
        
    }
}
