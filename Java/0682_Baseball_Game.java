//https://leetcode.com/problems/baseball-game/

class Solution {
    public int calPoints(String[] ops) {
        
        Stack<Integer> st = new Stack();
        
        
        for(String op : ops){
            
            char firstChar = op.charAt(0);
            
            if(Character.isDigit(firstChar)){
                
                int num = Integer.parseInt(op);
                st.push(num);
                
            }
            else if(firstChar=='-'){
                int num = Integer.parseInt(op);
                st.push(num);
            }
            else if(op.equals("C")){
                
                st.pop();
                
            }
            else if(op.equals("D")){
                
                int prev = st.peek();
                st.push(prev*2);
                
            }
            else if(op.equals("+")){
                
                int prev1 = st.pop();
                int prev2= st.peek();
                
                st.push(prev1);
                
                st.push(prev1+prev2);
                
            }  
            
        }
        
        int sum=0;
        
        for(int i:st){
            sum+=i;
        }
        
        
        return sum;
    }
}
