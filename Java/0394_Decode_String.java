//https://leetcode.com/problems/decode-string/

class Solution {
    public String decodeString(String s) {
        
        Stack<Integer> countStack = new Stack();
        Stack<String> letterStack = new Stack();
        
        String res="";
        
        int i=0;
        
        while(i<s.length()){
            
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                
                int num=0;
                while(i<s.length() && Character.isDigit(s.charAt(i))){
                    
                    num=num*10 + (s.charAt(i)-'0');
                    i++;    
                }
                countStack.push(num);
                
            }
            else if(c=='['){
                
                letterStack.push(res);
                res="";
                i++;
            }
            else if(c==']'){
                
                StringBuilder sb = new StringBuilder(letterStack.pop());
                
                int count = countStack.pop();
                
                for(int j=0;j<count;j++){
                    sb.append(res);
                }
                
                res=sb.toString();
                
                i++;
            }
            else{
                res+=c;
                i++;
                
            }
        
            
        }
        
        return res;
    }
}
