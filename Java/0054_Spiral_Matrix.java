//https://leetcode.com/problems/spiral-matrix/

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> res = new ArrayList();
        
        if(matrix==null || matrix.length==0) return res;
        
        int rowBeg = 0;
        int rowEnd = matrix.length-1;
        int colBeg = 0;
        int colEnd = matrix[0].length-1;
        
        
        while(rowBeg<=rowEnd && colBeg<=colEnd){
            
            for(int i=colBeg;i<=colEnd;i++){
                res.add(matrix[rowBeg][i]);
            }
            rowBeg++;
            
            for(int i=rowBeg;i<=rowEnd;i++){
                res.add(matrix[i][colEnd]);
            }
            colEnd--;
            
            if(rowBeg<=rowEnd){
                
                for(int i=colEnd;i>=colBeg;i--){
                    res.add(matrix[rowEnd][i]);

                }
                rowEnd--;
            }
            
            if(colBeg<=colEnd){
            
                for(int i=rowEnd;i>=rowBeg;i--){
                    res.add(matrix[i][colBeg]);
                }
                colBeg++;
            }
            
        }
        return res;
        
    }
}
