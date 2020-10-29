//https://leetcode.com/problems/candy-crush/

class Solution {
    public int[][] candyCrush(int[][] board) {
        
        int rowmax = board.length;
        int colmax = board[0].length;
        
        
        boolean shouldContinue = false;
        
        
        //Crush Horizontally
        
        for(int i=0;i<rowmax;i++){
            
            for(int j=0;j<colmax-2;j++){
                
                int val = Math.abs(board[i][j]);
                
                if(val>0 && val == Math.abs(board[i][j + 1]) && val == Math.abs(board[i][j + 2])){
                    
                    board[i][j] = board[i][j + 1] = board[i][j + 2] = -val;
                    
                    shouldContinue=true;
                }
                
                
            }
            
        }
            
        //Crush Vertically
        
        
            for(int j=0;j<colmax;j++){
                
                for(int i=0;i<rowmax-2;i++){
                
                    int val = Math.abs(board[i][j]);

                    if(val>0 && val == Math.abs(board[i + 1][j]) && val == Math.abs(board[i + 2][j])){

                        board[i][j] = board[i+1][j] = board[i+2][j] = -val;

                        shouldContinue=true;
                    }
                
                
            }
            
        }
      
       
        //Drop columns. Go from the leftmost column, bottom to top and look for values greater than 0
        //If present, start putting them from the bottom to top
        //Fill empty spaces in the top with zeros
        
        for(int j=0;j<colmax;j++){
            
            int r = rowmax-1;
            
            for(int i=rowmax-1;i>=0;i--){
                
                if(board[i][j]>=0){
                
                    board[r--][j] = board[i][j]; 
                }
            }
             for (int i = r; i >= 0; i--) {
                board[i][j] = 0;
             }
            
        }
        
        
       return shouldContinue ?  candyCrush(board) : board;
        
    }
}
