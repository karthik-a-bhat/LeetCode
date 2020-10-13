//https://leetcode.com/problems/flood-fill/

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        dfs(image,sr,sc,newColor,image[sr][sc]);
        
        return image;
        
    }
    public void dfs(int[][] image, int i, int j, int newColor, int oldColor){
        
        if(i<0 || i>=image.length || j<0 || j>=image[0].length || image[i][j]!=oldColor){
            return;
        }
        
        //So that there is no StackOverflow error
        image[i][j]= -1;
        
        
        dfs(image,i+1,j,newColor,oldColor);
        dfs(image,i-1,j,newColor,oldColor);
        dfs(image,i,j+1,newColor,oldColor);
        dfs(image,i,j-1,newColor,oldColor);
     
        image[i][j]=newColor;
    }
    
}
